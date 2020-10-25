package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Component;
import ru.blackmass.data.MessageText;

@Component
public class GamesCommand extends VkCommand {

    public GamesCommand(VkApiClient vk, GroupActor group) {
        super(vk, group);
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {
        sendMessage("Games", message);
    }
}
