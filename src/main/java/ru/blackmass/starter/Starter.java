package ru.blackmass.starter;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.entities.Flag;
import ru.blackmass.entities.User;
import ru.blackmass.handlers.CallbackLongPollHandler;
import ru.blackmass.repositories.UserRepository;

@Component
public class Starter {

    private CallbackLongPollHandler handler;
    private UserRepository userRepository;

    @Autowired
    public Starter(CallbackLongPollHandler handler, UserRepository userRepository) {
        this.handler = handler;
        this.userRepository = userRepository;
    }

    public void start() throws ClientException, ApiException {
        handler.run();
    }

}
