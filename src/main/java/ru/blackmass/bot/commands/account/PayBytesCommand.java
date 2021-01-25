package ru.blackmass.bot.commands.account;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.utils.MessageTextUtil;

@Component
public class PayBytesCommand extends VkCommand {

    private Logger log;

    @Autowired
    public PayBytesCommand(VkApiClient vk, GroupActor group, Logger log) {
        super(vk, group, log);
        this.log = log;
    }

    @Override
    public void run(Message message) {
        sendMessage(MessageTextUtil.getPayBytesText(), message);
    }
}
