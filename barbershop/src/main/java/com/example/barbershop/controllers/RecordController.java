package com.example.barbershop.controllers;

import com.example.barbershop.dtos.TimeSlot;
import com.example.barbershop.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService records;

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
}
