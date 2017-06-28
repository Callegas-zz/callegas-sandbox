package com.callegasdev;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BRMService {

    public Double calculateBRM(String gender, Integer age, Double heightInCm, Double weightInKg){
        if (gender.equalsIgnoreCase("male"))
            return maleCalc(age, heightInCm, weightInKg);

        if (gender.equalsIgnoreCase("female"))
            return femaleCalc(age, heightInCm, weightInKg);

        return 0.0;
    }

    private Double femaleCalc(Integer age, Double heightInCm, Double weightInKg){
        return 655 + (9.6 * weightInKg) + (1.8 * heightInCm) - (4.7 * age);
    }

    private Double maleCalc(Integer age, Double heightInCm, Double weightInKg){
        return 66 + (13.7 * weightInKg) + (5 * heightInCm) - (6.8 * age);
    }

}
