package ru.blackmass.commands.tasks;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.VkCommand;
import ru.blackmass.data.MessageText;

@Component
public class TaskKrutilka extends VkCommand {

    public TaskKrutilka(VkApiClient vk, GroupActor group) {
        super(vk, group);
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {
        sendMessage(MessageText.getTaskKrutilkaText(), message);
    }
}
