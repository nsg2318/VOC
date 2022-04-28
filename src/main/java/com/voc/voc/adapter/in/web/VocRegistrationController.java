package com.voc.voc.adapter.in.web;


import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;
import com.voc.voc.application.port.in.VocRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voc")
public class VocRegistrationController {

    private final VocRegistrationUseCase vocRegistrationUseCase;

    @PostMapping
    public ResponseEntity<VocRegistrationDto.Response> registration(
            @RequestBody VocRegistrationDto.Request request) {
        VocRegistrationDto.Response result = vocRegistrationUseCase.registration(request);
        return ResponseEntity.ok(result);
    }

}
