package jt.ilegra.callegasdev;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import static org.mockito.Mockito.mock;

@Profile("Test")
@Configuration
public class GitHubConfigTest {

    @Bean
    public AppController appController(){
        return new AppController();
    }

    @Bean
    public GitHubRepoService gitHubRepoService(){
        return mock(GitHubRepoService.class);
    }

    @Bean
    public GitHub gitHub(){
        return mock(GitHub.class);
    }



}
