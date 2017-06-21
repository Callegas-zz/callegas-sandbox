package jt.ilegra.callegasdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RequestMapping("/gitHubRepos")
public class AppController {

    @Autowired
    private GitHubRepoService gitHubRepoService;

    @RequestMapping("/{username}")
    @ResponseBody
    public String gitHubRepos(@PathVariable(value = "username") String username){
        if (gitHubRepoService.gitHubRepoService(username) != "error" )
            return "Repositories of "+username+": " + gitHubRepoService.gitHubRepoService(username);
        else
            return "Invalid User";
    }
}
