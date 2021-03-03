package com.silenteight.genderdetector.algorithmfactory;

import com.silenteight.genderdetector.algorithmfactory.algorithmversions.GenderDetectorAlgorithmV01;

public class GenderDetectorAlgorithmFactory {
    private static final String GENDER_DETECTOR_ALGORITHM_V01 = "GENDER_DETECTOR_ALGORITHM_V01";

    public final GenderDetectorAlgorithm getDetectorAlgorithmByVersion(final String detectorAlgorithmVersion) {
        switch (detectorAlgorithmVersion) {
            case GENDER_DETECTOR_ALGORITHM_V01:
                return new GenderDetectorAlgorithmV01();
            default:
                return null;
        }
    }
}
