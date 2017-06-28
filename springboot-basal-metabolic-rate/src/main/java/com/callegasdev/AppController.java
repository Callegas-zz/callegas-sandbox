package com.callegasdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@RequestMapping("/calculateBRM")
public class AppController {

    @Autowired
    private BRMService brmService;

    @RequestMapping("/{gender}/{age}/{heightInCm}/{weightInKg}")
    @ResponseBody
    public String calculateBRM(@PathVariable(value = "gender") String gender,
                               @PathVariable(value = "age") Integer age,
                               @PathVariable(value = "heightInCm") Double heightInCm,
                               @PathVariable(value = "weightInKg") Double weightInKg) {
        if (brmService.calculateBRM(gender, age, heightInCm, weightInKg) != 0)
            return "This " + age + " year old " + gender + " needs " +
                    brmService.calculateBRM(gender, age, heightInCm, weightInKg) +
                    " calories per day to maintain her current weight.";
        else
            return "Invalid gender";
    }

}
