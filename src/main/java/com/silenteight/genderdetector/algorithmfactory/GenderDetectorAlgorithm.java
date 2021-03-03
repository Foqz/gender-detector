package com.silenteight.genderdetector.algorithmfactory;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;

import java.util.Set;

public interface GenderDetectorAlgorithm {
    Gender detectGender(String name, AlgorithmVariant algorithmVariant, Set<String> maleNamesSet, Set<String> femaleNamesSet);
}
