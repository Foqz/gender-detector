package com.silenteight.genderdetector.algorithmfactory;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;

public interface GenderDetectorAlgorithm {
    Gender detectGender(String name, AlgorithmVariant algorithmVariant);
}
