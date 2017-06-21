package jt.ilegra.callegasdev;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitHubRepoService {

    @Autowired
    private GitHub gitHub;

    public  String gitHubRepoService(String username){
        try {
            return gitHub.getUser(username).getRepositories().keySet() + "";
        }catch (Exception e){
            return "error";
        }
    }
}
