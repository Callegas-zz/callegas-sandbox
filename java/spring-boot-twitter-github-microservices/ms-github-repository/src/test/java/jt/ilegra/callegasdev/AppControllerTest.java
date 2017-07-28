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
@ContextConfiguration(classes = { GitHubConfigTest.class })
public class AppControllerTest {

    @Autowired
    AppController appController;

    @Autowired
    GitHubRepoService gitHubRepoService;


    @Test
    public void gitHubRepoOfValidUser(){
        when(gitHubRepoService.gitHubRepoService("callegas")).
                thenReturn("Repositories of callegas: [Node-js, OrlandoCity, Uniritter]");
        Assert.assertEquals("Repositories of callegas: [Node-js, OrlandoCity, Uniritter]",
                appController.gitHubRepos("callegas"));

    }

    @Test
    public void gitHubRepoOfInvalidUser(){
        when(gitHubRepoService.gitHubRepoService("james")).
                thenReturn("error");
        Assert.assertEquals("Invalid User",
                appController.gitHubRepos("james"));
    }




}
