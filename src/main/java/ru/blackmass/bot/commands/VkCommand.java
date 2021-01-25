package ru.blackmass.bot.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Getter
public abstract class VkCommand {

    private final Logger log;
    private final VkApiClient vk;
    private final GroupActor group;
    private Random random;

    @Autowired
    public VkCommand(VkApiClient vk, GroupActor group, Logger log) {
        this.vk = vk;
        this.group = group;
        this.log = log;
    }

    public void sendMessage(String msg, Message message) {
        random = new Random();

        try {
            vk.messages().send(group)
                    .peerId(message.getPeerId())
                    .randomId(random.nextInt())
                    .message(msg)
                    .execute();
        } catch (ClientException | ApiException clientOrApiException) {
            log.error("Error Client, Api", clientOrApiException);
        } catch (Exception exception) {
            log.error("Error", exception);
        }
    }

    public void sendMessage(String msg, Message message, Keyboard keyboard) {
        random = new Random();

        try {
            vk.messages().send(group)
                    .peerId(message.getPeerId())
                    .randomId(random.nextInt())
                    .keyboard(keyboard)
                    .message(msg)
                    .execute();
        } catch (ClientException | ApiException clientOrApiException) {
            log.error("Error Client, Api", clientOrApiException);
        }
    }

    public void sendSticker(Message message, Integer stickerId) {
        Random random = new Random();
        try {
            vk.messages().send(group)
                    .peerId(message.getPeerId())
                    .randomId(random.nextInt())
                    .stickerId(stickerId)
                    .execute();
        } catch (ApiException | ClientException clientOrApiException) {
            log.error("Error Client, Api", clientOrApiException);
        }
    }

    public abstract void run(Message message);

}
