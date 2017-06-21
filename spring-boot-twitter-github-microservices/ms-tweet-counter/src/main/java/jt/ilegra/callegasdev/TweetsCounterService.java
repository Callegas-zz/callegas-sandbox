package jt.ilegra.callegasdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;

@SpringBootApplication
public class TweetsCounterService {

    @Autowired
    private Twitter twitter;

    public Integer tweetsCounterService(String username){
        try {
            TwitterProfile profile = twitter.userOperations().getUserProfile(username);
            return profile.getStatusesCount();
        }catch (Exception e){
            return -1;
        }
    }
}
