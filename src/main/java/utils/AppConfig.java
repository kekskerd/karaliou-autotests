package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:./app.properties"})
public interface AppConfig extends Config {

    @Key("start.url")
    String startUrl();

    @Key("valid.email")
    String validEmail();

    @Key("valid.password")
    String validPassword();

    @Key("timeout.element")
    int elementTimeout();

    @Key("timeout.page")
    int pageLoadTimeout();

}