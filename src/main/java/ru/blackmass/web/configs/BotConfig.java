package ru.blackmass.web.configs;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:python.properties"),
})
@ComponentScan("ru.blackmass")
public class BotConfig {

    @Autowired
    private Environment env;

    @Bean
    public TransportClient transportClient() {
        return HttpTransportClient.getInstance();
    }

    @Bean
    public VkApiClient vk() {
        return new VkApiClient(transportClient());
    }

    @Bean
    public UserActor user() {return new UserActor(233894995, "2f8f36b06a534240d49b956218f6d4364660be01b708169d246ee86ee6cf39a0264d354bd174fa07b3329");}

    @Bean
    public GroupActor group() {
        return new GroupActor(Integer.parseInt(env.getProperty("vk.group.id")), env.getProperty("vk.group.token"));
    }

    @Bean
    public Logger log() {
        return LogManager.getLogger();
    }

//    @Value("${vk.group.id}")
//    private String groupId;
//
//    @Value("${vk.group.token}")
//    private String groupToken;
//
//    @Bean
//    public TransportClient transportClient() {
//        return HttpTransportClient.getInstance();
//    }
//
//    @Bean
//    public VkApiClient vk() {
//        return new VkApiClient(transportClient());
//    }
//
//    @Bean
//    public GroupActor group() {
//        return new GroupActor(Integer.parseInt(groupId), groupToken);
//    }
//
//    @Bean
//    public CallbackLongPollHandler handler() {
//        return new CallbackLongPollHandler(vk(), group());
//    }
//
//    @Bean
//    public MessageHandler messageHandler() {
//        return new MessageHandler();
//    }
//
//    @Bean
//    public Starter starter() {
//        return new Starter();
//    }
//
////    @Bean
////    public MessageHandler messageHandler() {
////        return new MessageHandler();
////    }
////    @Bean
////    public ButtonText buttonText() {
////        return new ButtonText();
////    }
////
////    @Bean
////    public PythonKeyboard pythonKeyboard() {
////        return new PythonKeyboard(buttonText());
////    }

}
