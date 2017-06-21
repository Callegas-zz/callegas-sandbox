package jt.ilegra.callegasdev;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class GitHubConfig {

    @Bean
    public GitHub getGitHub() throws IOException {
        GitHub gitHub = GitHub.connect();
        return gitHub;
    }

}
