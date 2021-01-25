package ru.blackmass.bot.commands.account;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.utils.MessageTextUtil;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.keyboards.PythonKeyboard;
import ru.blackmass.bot.services.UserService;

@Component
public class MyAccountCommand extends VkCommand {

    private Logger log;
    private UserService userService;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public MyAccountCommand(VkApiClient vk, GroupActor group, Logger log, UserService userService, PythonKeyboard pythonKeyboard) {
        super(vk, group, log);
        this.log = log;
        this.userService = userService;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) {
        User user = userService.findUserById(message.getFromId());
        int withdrawLimit = user.getMaxWithdraw();
        if (user.getFlag().isVip()) {
            withdrawLimit *= 2;
        } else if (user.getFlag().isPremium()) {
            withdrawLimit *= 3;
        }

        sendMessage(MessageTextUtil.getMyAccountText(user, withdrawLimit), message, pythonKeyboard.createMyAccountKeyboard());
    }
}
