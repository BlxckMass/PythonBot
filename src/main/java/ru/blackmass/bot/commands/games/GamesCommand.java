package ru.blackmass.bot.commands.games;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.keyboards.PythonKeyboard;
import ru.blackmass.bot.utils.MessageTextUtil;

@Component
public class GamesCommand extends VkCommand {

    private Logger log;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public GamesCommand(VkApiClient vk, GroupActor group, Logger log, PythonKeyboard pythonKeyboard) {
        super(vk, group, log);
        this.log = log;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) {
        sendMessage(MessageTextUtil.getEnterGamesText(), message, pythonKeyboard.createGamesKeyboard());
    }
}
