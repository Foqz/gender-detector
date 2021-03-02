package com.silenteight.genderdetector.controller;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender-detector")
@AllArgsConstructor
public class GenderDetectorController {

    private final GenderDetectorService genderDetectorService;

    @GetMapping("/check-gender/{name}/{algorithm-variant}")
    public ResponseEntity<Gender> checkGender(@PathVariable("name") String name, @PathVariable("algorithm-variant") AlgorithmVariant algorithmVariant) {
        return ResponseEntity.status(HttpStatus.OK).body(genderDetectorService.checkGender(name, algorithmVariant));
    }

    @GetMapping("/available-names/{gender}")
    public ResponseEntity<List<String>> getAvailableNames(@PathVariable Gender gender) {
        return ResponseEntity.status(HttpStatus.OK).body(genderDetectorService.getAvailableNames(gender));
    }
}
