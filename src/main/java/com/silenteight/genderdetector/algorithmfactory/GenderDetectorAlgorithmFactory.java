package com.silenteight.genderdetector.algorithmfactory;

import com.silenteight.genderdetector.algorithmfactory.algorithmversions.GenderDetectorAlgorithmV01;
import com.silenteight.genderdetector.exception.GenderDetectorException;

public class GenderDetectorAlgorithmFactory {
    public static final String GENDER_DETECTOR_ALGORITHM_V01 = "GENDER_DETECTOR_ALGORITHM_V01";

    public final GenderDetectorAlgorithm getDetectorAlgorithmByVersion(final String detectorAlgorithmVersion) {
        switch (detectorAlgorithmVersion) {
            case GENDER_DETECTOR_ALGORITHM_V01:
                return new GenderDetectorAlgorithmV01();
            default:
                throw new GenderDetectorException("No algorithm found for detection");
        }
    }
}
