package com.voc.voc.adapter.in.web;


import com.voc.voc.adapter.in.web.dto.VocGetAllDto;
import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;
import com.voc.voc.application.port.in.VocGetAllUseCase;
import com.voc.voc.application.port.in.VocRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voc")
public class VocController {

    private final VocRegistrationUseCase vocRegistrationUseCase;
    private final VocGetAllUseCase vocGetAllUseCase;

    @PostMapping
    public ResponseEntity<VocRegistrationDto.Response> registration(
            @RequestBody VocRegistrationDto.Request request) {
        VocRegistrationDto.Response result = vocRegistrationUseCase.registration(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<VocGetAllDto.Response> getAllVoc(){
        VocGetAllDto.Response result = vocGetAllUseCase.getAll();
        return ResponseEntity.ok(result);
    }
}
