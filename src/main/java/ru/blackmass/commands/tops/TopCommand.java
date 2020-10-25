package ru.blackmass.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.VkCommand;
import ru.blackmass.keyboards.PythonKeyboard;

@Component
public class TopCommand extends VkCommand {

    private PythonKeyboard pythonKeyboard;

    @Autowired
    public TopCommand(VkApiClient vk, GroupActor group, PythonKeyboard pythonKeyboard) {
        super(vk, group);
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {

        sendMessage("Выберите топ:", message, pythonKeyboard.createTopKeyboard());
    }
}
