package ru.blackmass;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
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
    public UserActor user() {return new UserActor(233894995, "4dc9953286e9522f8ef3333739162400b03407a074a66c22049a4e2137823e2eb2680fab059b35e2b8501");}

    @Bean
    public GroupActor group() {
        return new GroupActor(Integer.parseInt(env.getProperty("vk.group.id")), env.getProperty("vk.group.token"));
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
