package com.voc.voc.adapter.in.web;

import com.voc.voc.adapter.in.web.dto.CompensationGetAllDto;
import com.voc.voc.adapter.in.web.dto.CompensationRegistrationDto;
import com.voc.voc.application.port.in.CompensationGetAllUseCase;
import com.voc.voc.application.port.in.CompensationRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compensation")
public class CompensationController {

    private final CompensationRegistrationUseCase compensationRegistrationUseCase;
    private final CompensationGetAllUseCase compensationGetAllUseCase;

    @PostMapping
    public ResponseEntity<CompensationRegistrationDto.Response> registration(
            @RequestBody CompensationRegistrationDto.Request request) {
        CompensationRegistrationDto.Response registration = compensationRegistrationUseCase.registration(request);
        return ResponseEntity.ok(registration);
    }

    @GetMapping
    public ResponseEntity<CompensationGetAllDto.Response> getAllCompensation() {
        CompensationGetAllDto.Response result = compensationGetAllUseCase.getAllCompensation();
        return ResponseEntity.ok(result);
    }
}
