package io.javabrains.springbootconfig;

import io.javabrains.springbootconfig.beanSelectionByProfile.DefaultDataSourceBean;
import io.javabrains.springbootconfig.beanSelectionByProfile.TestDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@RefreshScope
public class GreetingController
{
    /* ******************************************************************* */
    // 1) INJECT Value from .properties file ==> With Default Value
    @Value("${my.greeting: Hello World Default Value}")
    private String greetingMessage;

    // 1) Inject Static Text
    @Value("Some Static Message")
    private String staticMessage;

    // 1) INJECT list of values from .properties file
    @Value("${my.list.values}")
    private List<String> listValues;

    // 1) Inject Key-Value Pairs into Map from .properties file
    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    /* ******************************************************************* */
    // 2) Inject BULK Data via @Configuration + @ConfigurationProperties
    @Autowired
    private DbSettings dbSettings;

    /* ******************************************************************* */
    // Experimentation with @Profile ==> Prohibiting Bean Instantiation ==> CHECK ??

//    @Autowired
//    IDataSource dataSource;

    @Autowired
    DefaultDataSourceBean defaultDataSourceBean;

    @Autowired
    TestDataSourceBean testDataSourceBean;

    /* ******************************************************************* */

    @Autowired
    private Environment env;



    /* ******************************************************************* */
    // 1) Injection values from property files using:
    // @Value("${}"), @Value("#{${}}")
    // @ConfigurationProperties("<prefix>") + @Configuration

    @GetMapping("/greeting")
    public String greeting()
    {
        String response = String.format("%s %n %s %n %s %n " +
                                        "[%s - %s - %s], %n " +
                                        "[%s, %s, %s, %s]",
                                        greetingMessage,
                                        staticMessage,
                                        listValues,
                                        dbValues.get("connectionString"),
                                        dbValues.get("userName"),
                                        dbValues.get("password"),
                                        dbSettings.getConnection(),
                                        dbSettings.getHost(),
                                        dbSettings.getPort(),
                                        dbSettings.getValues()
                                      );
        System.out.println(response);
        return response;
    }

    /* ******************************************************************* */
    // 2) Running with Different Spring Profiles from CMD

    // jar path>java -jar spring-boot-config-0.0.1-SNAPSHOT.jar
    // jar path>java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=test


    @GetMapping("/profileTest")
    public String profileTest()
    {
        System.out.println("\nDB Settings: " + dbSettings.toString());

        /* ************************************************************** */
        // @Profile("test") ==> Prohibiting Bean Creation

        //System.out.println("\nIData Source: " + dataSource.toString());
        // System.out.println("\nDefault-Data-Source-Bean: " + defaultDataSourceBean.toString());
        // System.out.println("\nTest-Data-Source-Bean: " + testDataSourceBean.toString());

        //return dataSource.toString();

        /* ************************************************************** */
        return dbSettings.toString();
     }

    /* ******************************************************************* */
    // 3) Using Environment Object

    @GetMapping("/envDetails")
     public String  envDetails()
     {

        String envLookUp = String.format("\n\nProperty + Profile LookUp Via Environment Object %n" +
                                        "Active Spring Profile: %s %n" +
                                        "Active Profiles: %s %n" +
                                        "Default Profiles: %s %n" +
                                        "DB Connection: %s %n" +
                                        "DB Host: %s %n" +
                                        "DB Port: %d %n" +
                                        "DB values: %s %n",
                                        env.getProperty("spring.profiles.active"),
                                        Arrays.toString(env.getActiveProfiles()),
                                        Arrays.toString(env.getDefaultProfiles()),
                                        env.getProperty("db.connection"),
                                        env.getProperty("db.host"),
                                        Integer.parseInt(env.getProperty("db.port")),
                                        env.getProperty("db.values"));

        System.out.println(envLookUp);
        return env.toString();
     }

    /* ******************************************************************* */

}
