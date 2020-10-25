package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Getter
public abstract class VkCommand {

    private VkApiClient vk;
    private GroupActor group;
    private Random random;

    @Autowired
    public VkCommand(VkApiClient vk, GroupActor group) {
        this.vk = vk;
        this.group = group;
    }

    public void sendMessage(String msg, Message message) throws ClientException, ApiException {
        random = new Random();
        vk.messages().send(group)
                .peerId(message.getPeerId())
                .randomId(random.nextInt())
                .message(msg)
                .execute();
    }

    public void sendMessage(String msg, Message message, Keyboard keyboard) throws ClientException, ApiException {
        random = new Random();
        vk.messages().send(group)
                .peerId(message.getPeerId())
                .randomId(random.nextInt())
                .keyboard(keyboard)
                .message(msg)
                .execute();
    }

    public abstract void run(Message message) throws ClientException, ApiException;

}
