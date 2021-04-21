package com.example.barbershop.controllers;

import com.example.barbershop.dtos.AccountDto;
import com.example.barbershop.dtos.RecordDto;
import com.example.barbershop.dtos.RecordInfoDto;
import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import com.example.barbershop.exceptions.UnauthorizedException;
import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService records;
    private final AccountService accountService;

    @GetMapping("/records")
    public List<RecordEntity> getAllRecords(){
        return records.findAllRecords();
    }

    @RequestMapping("/timeSlots")
    List<TimeSlot> getTimeSlots(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant end,
            @RequestParam Integer master,
            @RequestParam Integer procedure) {
        return records.getTimeSlotsForInterval(
                start,
                end,
                master,
                procedure);
    }

    @PostMapping("/admin/record/add")
    public void addRecord(@RequestBody RecordEntity record){
        records.addRecord(record);
    }

    @PutMapping("/admin/record/update")
    public void updateRecord(@RequestBody RecordEntity record){
        records.updateRecord(record);
    }

    @DeleteMapping("/admin/record/delete/{id}")
    public void deleteRecord(@PathVariable int id) {
        records.removeByRecordId(id);
    }
    @RequestMapping(value = "/records/add", method = RequestMethod.POST)
    void addBooking(@RequestBody @Valid RecordDto recordDto){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        records.addRecord(account.getAccountId(), recordDto.getMasterId(), recordDto.getProcedureId(), recordDto.getDateTime());
    }

    @RequestMapping(value = "/records")
    RecordInfoDto getBooking(@RequestParam Integer id){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        if (account == null)
            throw new UnauthorizedException();
        return records.findCustomerRecordById(id, account.getAccountId());
    }

    @RequestMapping(value = "/records/my")
    List<RecordInfoDto> getClientBookings(){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        if (account == null)
            throw new UnauthorizedException();
        return records.findAllRecordsByClientId(account.getAccountId());
    }
}
