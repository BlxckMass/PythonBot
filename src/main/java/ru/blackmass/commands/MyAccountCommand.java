package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.data.MessageText;
import ru.blackmass.entities.User;
import ru.blackmass.keyboards.PythonKeyboard;
import ru.blackmass.services.UserService;

@Component
public class MyAccountCommand extends VkCommand {

    private UserService userService;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public MyAccountCommand(VkApiClient vk, GroupActor group, UserService userService, PythonKeyboard pythonKeyboard) {
        super(vk, group);
        this.userService = userService;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {
        User user = userService.getUserById(message.getFromId());

        sendMessage(MessageText.getMyAccountText(user), message, pythonKeyboard.createMyAccountKeyboard());
    }
}
