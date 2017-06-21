package jt.ilegra.callegasdev;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


@SpringBootApplication
@RequestMapping("/tweetsAndRepos")
public class TweetsCounterAndGitHubRepos {

    private static final String GITHUB_IP = "http://localhost:8082/gitHubRepos/";
    private static final String TWITTER_IP = "http://localhost:8081/tweetsCounter/";


    @RequestMapping("/{twitterUsername}/{gitHubUsername}")
    @ResponseBody
    public String tweetsCounterAndGitHubRepos(@PathVariable(value = "twitterUsername") String twitterUsername,
                                              @PathVariable(value = "gitHubUsername") String gitHubUsername) throws IOException {

        String msError = "Temporarily unavailable";

        String twitterPath = TWITTER_IP + twitterUsername;
        String twitter;
        try {
            twitter = new Scanner(new URL(twitterPath).openStream(), "UTF-8").useDelimiter("\\A").next();
        }catch (Exception e) {
            twitter = msError;
        }


        String gitHubPath = GITHUB_IP + gitHubUsername;
        String gitHub;
        try {
            gitHub = new Scanner(new URL(gitHubPath).openStream(), "UTF-8").useDelimiter("\\A").next();
        }catch (Exception e) {
            gitHub = msError;
        }

        return twitter + "<br />" + gitHub;
    }

}
