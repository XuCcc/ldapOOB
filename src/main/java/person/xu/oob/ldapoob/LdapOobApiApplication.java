package person.xu.oob.ldapoob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Properties.class})
public class LdapOobApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdapOobApiApplication.class, args);
    }

}
