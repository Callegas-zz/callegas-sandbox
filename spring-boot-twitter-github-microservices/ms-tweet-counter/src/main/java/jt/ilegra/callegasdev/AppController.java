package jt.ilegra.callegasdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@RequestMapping("/tweetsCounter")
public class AppController {

    @Autowired
    private TweetsCounterService tweetsCounterService;

    @RequestMapping("/{username}")
    @ResponseBody
    public String tweetsCounter(@PathVariable(value = "username") String username){
        if (tweetsCounterService.tweetsCounterService(username) != -1)
            return "Total tweets of "+username+": " + tweetsCounterService.tweetsCounterService(username);
        else
            return "User not found";
    }

}
