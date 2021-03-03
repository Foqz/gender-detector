package com.silenteight.genderdetector.service;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import com.silenteight.genderdetector.exception.GenderDetectorException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class GenderDetectorService {

    private static final String FEMALE_TOKEN_LIST_PATH = "src/main/resources/nameslists/female_names_list.txt";
    private static final String MALE_TOKEN_LIST_PATH = "src/main/resources/nameslists/male_names_list.txt";

    public Gender checkGender(String name, AlgorithmVariant algorithmVariant) {
        return Gender.MALE;
    }

    public ArrayList<String> getAvailableNames(Gender gender) {
        return getNamesForGender(gender);
    }

    private ArrayList<String> getNamesForGender(Gender gender) {
        ArrayList<String> namesListForGender = new ArrayList<>();
        try (FileReader reader = new FileReader(getFilePathByGender(gender));
             BufferedReader bufferedReader = new BufferedReader((reader))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                namesListForGender.add(line);
            }
        } catch (IOException e) {
            log.error("There was an exception during generating names list for gender", e);
        }
        return namesListForGender;
    }

    private String getFilePathByGender(Gender gender) {
        switch (gender) {
            case MALE:
                return MALE_TOKEN_LIST_PATH;
            case FEMALE:
                return FEMALE_TOKEN_LIST_PATH;
            default:
                throw new GenderDetectorException("Could not find file path for provided gender: " + gender);
        }
    }
}
