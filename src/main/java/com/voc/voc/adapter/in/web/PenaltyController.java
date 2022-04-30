package com.voc.voc.adapter.in.web;

import com.voc.voc.adapter.in.web.dto.PenaltyRegistrationDto;
import com.voc.voc.application.port.in.PenaltyRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/penalty")
public class PenaltyController {

    private final PenaltyRegistrationUseCase penaltyRegistrationUseCase;

    @PostMapping
    public ResponseEntity<PenaltyRegistrationDto.Response> registration(
            @RequestBody PenaltyRegistrationDto.Request request){

        PenaltyRegistrationDto.Response result = penaltyRegistrationUseCase.registration(request);
        return ResponseEntity.ok(result);

    }
}


// TODO: 2022/04/30  test
// TODO: 2022/04/30  Exception handling
// TODO: 2022/04/30 페널티 기능 - 이의제기 true, 리즌등록, CLOSED