package ru.blackmass.handlers;

import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.friends.responses.GetResponse;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.users.UsersGetQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class CallbackLongPollHandler extends CallbackApiLongPoll {

    private VkApiClient vk;
    private GroupActor group;
    private MessageHandler messageHandler;

    @Autowired
    public CallbackLongPollHandler(VkApiClient client, GroupActor actor, MessageHandler handler) {
        super(client, actor);
        this.vk = client;
        this.group = actor;
        this.messageHandler = handler;
    }

    @SneakyThrows
    @Override
    public void messageNew(Integer groupId, Message message) {
        super.messageNew(groupId, message);

        UserActor userActor = new UserActor(233894995, "4dc9953286e9522f8ef3333739162400b03407a074a66c22049a4e2137823e2eb2680fab059b35e2b8501");
        List<UserXtrCounters> users = vk.users().get(userActor)
                .userIds(message.getFromId().toString())
                .execute();

        messageHandler.parseMessage(groupId, message);
    }


}
