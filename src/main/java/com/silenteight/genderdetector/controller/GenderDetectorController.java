package com.silenteight.genderdetector.controller;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import com.silenteight.genderdetector.service.GenderDetectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/gender-detector")
@AllArgsConstructor
public class GenderDetectorController {

    private final GenderDetectorService genderDetectorService;

    @GetMapping("/by-name/{name}/{algorithm-variant}")
    public Gender getGenderByName(@PathVariable("name") String name, @PathVariable("algorithm-variant") AlgorithmVariant algorithmVariant) {
        return genderDetectorService.getGenderByName(name, algorithmVariant);
    }

    @GetMapping("/available-names/{gender}")
    public Set<String> getAvailableNames(@PathVariable Gender gender) {
        return genderDetectorService.getAvailableNamesForGender(gender);
    }
}
