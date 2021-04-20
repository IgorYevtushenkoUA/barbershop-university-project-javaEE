package com.example.barbershop.controllers;

import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.entity.RecordEntity;
import com.example.barbershop.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService records;

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
    public void deleteRecord(@PathVariable int id){
        records.removeByRecordId(id);
    }
}
