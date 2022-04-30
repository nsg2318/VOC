package com.voc.voc.adapter.in.web;

import com.voc.voc.adapter.in.web.dto.CompensationRegistrationDto;
import com.voc.voc.application.port.in.CompensationRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compensation")
public class CompensationController {

    private final CompensationRegistrationUseCase compensationRegistrationUseCase;

    @PostMapping
    public ResponseEntity<CompensationRegistrationDto.Response> registration(
            @RequestBody CompensationRegistrationDto.Request request) {
        CompensationRegistrationDto.Response registration = compensationRegistrationUseCase.registration(request);
        return ResponseEntity.ok(registration);
    }
}
