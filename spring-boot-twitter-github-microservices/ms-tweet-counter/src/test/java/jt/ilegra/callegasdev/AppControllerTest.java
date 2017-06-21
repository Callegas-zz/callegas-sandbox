package jt.ilegra.callegasdev;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@ActiveProfiles("Test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TwitterConfigTest.class })
public class AppControllerTest {

    @Autowired
    AppController appController;

    @Autowired
    TweetsCounterService tweetsCounterService;



    @Test
    public void tweetsCounterOfValidUser(){
        when(tweetsCounterService.tweetsCounterService("callegas")).thenReturn(10);
        Assert.assertEquals(appController.tweetsCounter("callegas"), "Total tweets of callegas: 10");
    }

    @Test
    public void tweetsCounterOfInvalidUser(){
        when(tweetsCounterService.tweetsCounterService("james")).thenReturn(-1  );
        Assert.assertEquals(appController.tweetsCounter("james"), "User not found");
    }


}
