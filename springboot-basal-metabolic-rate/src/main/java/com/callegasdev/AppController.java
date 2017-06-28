package com.callegasdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
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

        Long brmResult = brmService.calculateBRM(gender, age, heightInCm, weightInKg);

        if (brmResult != 0)
            return "This "+age+" year old "+gender+" needs "+brmResult+
                        " calories per day to maintain her current weight.";
        else
            return "Invalid gender";
    }

}
