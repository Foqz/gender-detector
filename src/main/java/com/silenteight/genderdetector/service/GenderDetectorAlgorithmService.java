package com.silenteight.genderdetector.service;

import com.silenteight.genderdetector.algorithmfactory.GenderDetectorAlgorithm;
import com.silenteight.genderdetector.algorithmfactory.GenderDetectorAlgorithmFactory;
import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import com.silenteight.genderdetector.exception.GenderDetectorException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class GenderDetectorAlgorithmService {

    private static final String FEMALE_NAMES_PATH = "src/main/resources/avaliabletokensfiles/female_names.txt";
    private static final String MALE_NAMES_PATH = "src/main/resources/avaliabletokensfiles/male_names.txt";


    public Gender detectGender(String name, AlgorithmVariant algorithmVariant) {

        GenderDetectorAlgorithmFactory factory = new GenderDetectorAlgorithmFactory();
        GenderDetectorAlgorithm genderDetectorAlgorithm = factory
                .getDetectorAlgorithmByVersion(GenderDetectorAlgorithmFactory.GENDER_DETECTOR_ALGORITHM_V01);

        Set<String> maleNamesSet = getNamesForGender(Gender.MALE, true);
        Set<String> femaleNamesSet = getNamesForGender(Gender.FEMALE, true);

        return Objects.requireNonNull(genderDetectorAlgorithm).detectGender(name, algorithmVariant, maleNamesSet, femaleNamesSet);

    }

    public Set<String> getNamesForGender(Gender gender, boolean isLowerCase) {
        Set<String> namesSetForGender = new HashSet<>();
        try (FileReader reader = new FileReader(getFilePathByGender(gender));
             BufferedReader bufferedReader = new BufferedReader((reader))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isLowerCase) {
                    namesSetForGender.add(line.toLowerCase());
                } else {
                    namesSetForGender.add(line);
                }
            }
        } catch (IOException e) {
            log.error("There was an exception during generating names list for gender", e);
        }
        return namesSetForGender;
    }

    private String getFilePathByGender(Gender gender) {
        switch (gender) {
            case MALE:
                return MALE_NAMES_PATH;
            case FEMALE:
                return FEMALE_NAMES_PATH;
            default:
                throw new GenderDetectorException("Could not find file path for provided gender: " + gender);
        }
    }
}
