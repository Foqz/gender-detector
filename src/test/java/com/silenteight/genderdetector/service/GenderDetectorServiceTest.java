package com.silenteight.genderdetector.service;

import com.silenteight.genderdetector.enumeration.AlgorithmVariant;
import com.silenteight.genderdetector.enumeration.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class GenderDetectorServiceTest {

    @Autowired
    private GenderDetectorService genderDetectorService;

    @Test
    void getGenderByNameAllTokens() {
        //Given
        String maleName = "JaN";
        String femaleName = "MaRia";
        String combinedName = "Jan mArIa rOkitA";
        AlgorithmVariant algorithmVariant = AlgorithmVariant.ALL_TOKENS;
        //When
        Gender genderWithMaleName = genderDetectorService.getGenderByName(maleName, algorithmVariant);
        Gender genderWithFemaleName = genderDetectorService.getGenderByName(femaleName, algorithmVariant);
        Gender genderWithCombinedName = genderDetectorService.getGenderByName(combinedName, algorithmVariant);
        //Then
        Assertions.assertEquals(Gender.MALE, genderWithMaleName);
        Assertions.assertEquals(Gender.FEMALE, genderWithFemaleName);
        Assertions.assertEquals(Gender.INCONCLUSIVE, genderWithCombinedName);
    }

    @Test
    void getGenderByNameFirstToken() {
        //Given
        String maleName = "JaN";
        String femaleName = "MaRia";
        String combinedName = "Jan mArIa rOkitA";
        AlgorithmVariant algorithmVariant = AlgorithmVariant.FIRST_TOKEN;
        //When
        Gender genderWithMaleName = genderDetectorService.getGenderByName(maleName, algorithmVariant);
        Gender genderWithFemaleName = genderDetectorService.getGenderByName(femaleName, algorithmVariant);
        Gender genderWithCombinedName = genderDetectorService.getGenderByName(combinedName, algorithmVariant);
        //Then
        Assertions.assertEquals(Gender.MALE, genderWithMaleName);
        Assertions.assertEquals(Gender.FEMALE, genderWithFemaleName);
        Assertions.assertEquals(Gender.MALE, genderWithCombinedName);
    }

    @Test
    void getAvailableNamesForGender() {
        //Given
        Gender maleGender = Gender.MALE;
        Gender femaleGender = Gender.FEMALE;
        //When
        Set<String> maleNamesSet = genderDetectorService.getAvailableNamesForGender(maleGender);
        Set<String> femaleNamesSet = genderDetectorService.getAvailableNamesForGender(femaleGender);
        //Then
        Assertions.assertNotEquals(0, maleNamesSet.size());
        Assertions.assertNotEquals(0, femaleNamesSet.size());
    }
}
