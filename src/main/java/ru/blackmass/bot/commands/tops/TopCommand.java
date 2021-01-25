package ru.blackmass.bot.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.keyboards.PythonKeyboard;

@Component
public class TopCommand extends VkCommand {

    private Logger log;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public TopCommand(VkApiClient vk, GroupActor group, Logger log, PythonKeyboard pythonKeyboard) {
        super(vk, group, log);
        this.log = log;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) {

        sendMessage("Выберите топ.", message, pythonKeyboard.createTopKeyboard());
    }
}
