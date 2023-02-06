package ch.divtechx.swisscansatapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "swisscansatapi")
@Getter
@Setter
public class SwissCanSatProperties {
    private Auth auth = new Auth();
    private Cors cors = new Cors();

    @Getter
    @Setter
    public static class Cors {
        private String[] allowedOrigins;
    }

    @Getter
    @Setter
    public static class Auth {
        private String user;
        private String password;
    }
}
