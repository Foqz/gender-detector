package com.silenteight.genderdetector.algorithmfactory.algorithmversions;

import com.silenteight.genderdetector.algorithmfactory.GenderDetectorAlgorithm;
import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import com.silenteight.genderdetector.exception.GenderDetectorAlgorithmException;

import java.util.Set;

public class GenderDetectorAlgorithmV01 implements GenderDetectorAlgorithm {
    @Override
    public Gender detectGender(String name, AlgorithmVariant algorithmVariant, Set<String> maleNamesSet, Set<String> femaleNamesSet) {
        if (!name.isBlank()) {
            int maleNameHits = 0;
            int femaleNameHits = 0;

            String[] splitNameArray = name.trim().toLowerCase().split(" ");
            String[] splitNameArrayBasedOnVariant;
            switch (algorithmVariant) {
                case FIRST_TOKEN:
                    splitNameArrayBasedOnVariant = new String[1];
                    splitNameArrayBasedOnVariant[0] = splitNameArray[0];
                    break;
                case ALL_TOKENS:
                    splitNameArrayBasedOnVariant = splitNameArray;
                    break;
                default:
                    throw new GenderDetectorAlgorithmException("Could not find algorithm variant for: " + algorithmVariant);
            }

            for (String namePart : splitNameArrayBasedOnVariant) {
                if (maleNamesSet.contains(namePart)) {
                    maleNameHits++;
                }
                if (femaleNamesSet.contains(namePart)) {
                    femaleNameHits++;
                }
            }

            if (maleNameHits == 0 && femaleNameHits == 0) {
                throw new GenderDetectorAlgorithmException("Could not find any matching name in data files");
            } else if (maleNameHits == femaleNameHits) {
                return Gender.INCONCLUSIVE;
            } else if (maleNameHits > femaleNameHits) {
                return Gender.MALE;
            } else {
                return Gender.FEMALE;
            }
        } else {
            throw new GenderDetectorAlgorithmException("Name cannot be blank");
        }
    }
}
