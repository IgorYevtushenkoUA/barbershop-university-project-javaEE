package com.example.barbershop.controllers;

import com.example.barbershop.dtos.AccountDto;
import com.example.barbershop.dtos.RecordDto;
import com.example.barbershop.dtos.TimeSlot;
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

    @RequestMapping(value = "/records/add", method = RequestMethod.POST)
    void addBooking(@RequestBody @Valid RecordDto recordDto){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        records.addRecord(account.getAccountId(), recordDto.getMasterId(), recordDto.getProcedureId(), recordDto.getDateTime());
    }
}
