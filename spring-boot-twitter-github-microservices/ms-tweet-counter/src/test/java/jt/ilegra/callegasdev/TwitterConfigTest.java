package jt.ilegra.callegasdev;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.Twitter;

import static org.mockito.Mockito.mock;

@Profile("Test")
@Configuration
public class TwitterConfigTest {

    @Bean
    public AppController appController(){
        return new AppController();
    }

    @Bean
    public TweetsCounterService tweetsCounterService(){
        return mock(TweetsCounterService.class);
    }

    @Bean
    public Twitter twitter(){
        return mock(Twitter.class);
    }



}
