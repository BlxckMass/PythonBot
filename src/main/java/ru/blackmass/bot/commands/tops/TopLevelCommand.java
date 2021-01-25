package ru.blackmass.bot.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.keyboards.PythonKeyboard;
import ru.blackmass.bot.services.UserService;

import java.util.List;

@Component
public class TopLevelCommand extends VkCommand {

    private Logger log;
    private UserService userService;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public TopLevelCommand(VkApiClient vk, GroupActor group, Logger log, UserService userService, PythonKeyboard pythonKeyboard) {
        super(vk, group, log);
        this.log = log;
        this.userService = userService;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) {

        int numberToper = 1;
        List<User> topUsers = userService.findUsersByTopLevel();
        StringBuilder topMessage = new StringBuilder("Топ по уровню:\n");

        for (User topUser : topUsers) {
            topMessage.append("♯" + numberToper +
                    " @id" + topUser.getId() + "(" + topUser.getNickname() + ")" +
                    " ⇨ " + topUser.getLvl() + " уровень (" + topUser.getExp() + " / " + topUser.getMaxExp() + ")\n");
            numberToper++;
        }

        sendMessage(topMessage.toString(), message);
    }
}
