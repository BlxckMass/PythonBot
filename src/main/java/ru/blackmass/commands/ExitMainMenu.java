package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.data.MessageText;
import ru.blackmass.keyboards.PythonKeyboard;

@Component
public class ExitMainMenu extends VkCommand {

    private PythonKeyboard pythonKeyboard;

    @Autowired
    public ExitMainMenu(VkApiClient vk, GroupActor group, PythonKeyboard pythonKeyboard) {
        super(vk, group);
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {
        sendMessage(MessageText.getExitMainMenuText(), message, pythonKeyboard.createMainKeyboard());
    }
}
