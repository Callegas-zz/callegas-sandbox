package com.callegasdev;

public class BRMService {

    public Long calculateBRM(String gender, Integer age, Double heightInCm, Double weightInKg){
        if (gender.equalsIgnoreCase("male"))
            return Math.round(maleCalc(age, heightInCm, weightInKg));

        if (gender.equalsIgnoreCase("female"))
            return Math.round(femaleCalc(age, heightInCm, weightInKg));

        return 0L;
    }

    private Double femaleCalc(Integer age, Double heightInCm, Double weightInKg){
        return 655 + (9.6 * weightInKg) + (1.8 * heightInCm) - (4.7 * age);
    }

    private Double maleCalc(Integer age, Double heightInCm, Double weightInKg){
        return 66 + (13.7 * weightInKg) + (5 * heightInCm) - (6.8 * age);
    }

}
