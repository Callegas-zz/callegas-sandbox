package jt.ilegra.callegasdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {

    @Bean
    public Twitter getTwitter(){
        String consumerKey = System.getenv("TWITTER_APP_KEY");
        String consumerSecret = System.getenv("TWITTER_APP_SECRET");
        String accessToken = System.getenv("TWITTER_APP_TOKEN_KEY");
        String accessTokenSecret = System.getenv("TWITTER_APP_TOKEN_SECRET");

        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        return twitter;
    }

}
