package ru.blackmass.bot.handlers;

import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.timers.DailyTimerTask;
import ru.blackmass.bot.utils.VkRequestsUtil;

import java.net.SocketTimeoutException;

@Component
@Getter
@Setter
public class CallbackLongPollHandler extends CallbackApiLongPoll {

    private Logger log;
    private VkApiClient vk;
    private GroupActor group;
    private MessageHandler messageHandler;
    private DailyTimerTask dailyTimerTask;

    @Autowired
    public CallbackLongPollHandler(Logger log, VkApiClient client, GroupActor actor, MessageHandler handler, DailyTimerTask dailyTimerTask) {
        super(client, actor);
        this.log = log;
        this.vk = client;
        this.group = actor;
        this.messageHandler = handler;
        this.dailyTimerTask = dailyTimerTask;
    }

    @Override
    public void messageNew(Integer groupId, Message message) {
        super.messageNew(groupId, message);

        try {
            messageHandler.parseMessage(groupId, message);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            run();
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        try {
            super.run();
        } catch (ApiException | ClientException clientOrApiException) {
            log.error("Api or Client", clientOrApiException);
            Thread.sleep(1000);
            run();
        } catch (Exception e) {
            log.error("Exception", e);
            Thread.sleep(1000);
            run();
        }
    }
}
