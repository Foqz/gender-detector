package com.silenteight.genderdetector.service;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class GenderDetectorService {

    private final GenderDetectorAlgorithmService genderDetectorAlgorithmService;

    public Gender getGenderByName(String name, AlgorithmVariant algorithmVariant) {
        return genderDetectorAlgorithmService.detectGender(name, algorithmVariant);
    }

    public Set<String> getAvailableNamesForGender(Gender gender) {
        return genderDetectorAlgorithmService.getNamesForGender(gender);
    }
}
