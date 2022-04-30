package com.voc.voc.adapter.in.web;

import com.voc.voc.adapter.in.web.dto.PenaltyObjectionDto;
import com.voc.voc.adapter.in.web.dto.PenaltyRegistrationDto;
import com.voc.voc.application.port.in.PenaltyRegistrationUseCase;
import com.voc.voc.application.port.in.PenaltyUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/penalty")
public class PenaltyController {

    private final PenaltyRegistrationUseCase penaltyRegistrationUseCase;
    private final PenaltyUpdateUseCase penaltyUpdateUseCase;

    @PostMapping
    public ResponseEntity<PenaltyRegistrationDto.Response> registration(
            @RequestBody PenaltyRegistrationDto.Request request) {

        PenaltyRegistrationDto.Response result = penaltyRegistrationUseCase.registration(request);
        return ResponseEntity.ok(result);

    }

    @PostMapping("/objection/{penaltyIndex}")
    public void objectionRequest(
            @PathVariable Long penaltyIndex,
            @RequestBody PenaltyObjectionDto.Request request) {
        penaltyUpdateUseCase.updateObjection(penaltyIndex, request);
    }

    @PatchMapping("/read/{penaltyIndex}")
    public void updateRead(
            @PathVariable Long penaltyIndex) {
        penaltyUpdateUseCase.updateRead(penaltyIndex);
    }

    @PatchMapping("/objection/{penaltyIndex}")
    public void agreeFault(
            @PathVariable Long penaltyIndex) {
        penaltyUpdateUseCase.updateObjection(penaltyIndex);
    }
}


// TODO: 2022/04/30  test
// TODO: 2022/04/30  Exception handling
// TODO: 2022/04/30  리즌등록