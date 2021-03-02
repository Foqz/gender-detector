package com.silenteight.genderdetector.controller;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GenderDetectorService {

    public Gender checkGender(String name, AlgorithmVariant algorithmVariant) {
        return Gender.MALE;
    }

    public List<String> getAvailableNames(Gender gender) {
        return new ArrayList<>();
    }


}
