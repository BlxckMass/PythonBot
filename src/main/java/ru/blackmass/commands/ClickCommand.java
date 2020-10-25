package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.data.MessageText;
import ru.blackmass.entities.User;
import ru.blackmass.services.UserService;

@Component
public class ClickCommand extends VkCommand {

    private UserService userService;

    @Autowired
    public ClickCommand(VkApiClient vk, GroupActor group, UserService userService) {
        super(vk, group);
        this.userService = userService;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {

        User user = userService.getUserById(message.getFromId());
        user.setBalance(user.getBalance() + user.getClickPower());
        user.setExp(user.getExp() + user.getExpBoost());

        lvlUp(user, message);

        sendMessage(MessageText.getClickText(user), message);
    }

    public void lvlUp(User user, Message message) throws ClientException, ApiException {
        if (user.getExp() == user.getMaxExp()) {
            int currentLvl = user.getLvl();
            int nextLvl = user.getLvl() + 1;
            int currentMaxExp = user.getMaxExp();
            int maxWithdraw = user.getMaxWithdraw() + 250;
            user.setExp(0);
            user.setLvl(nextLvl);
            user.setMaxWithdraw(maxWithdraw);

            if (currentLvl <= 4) {
                if (currentLvl == 4) {
                    user.setMaxExp(currentMaxExp + 500);
                } else {
                    user.setMaxExp(currentMaxExp + 250);
                }
            } else if (currentLvl <= 9) {
                if (currentLvl == 9) {
                    user.setMaxExp(currentMaxExp + 1500);
                } else {
                    user.setMaxExp(currentMaxExp + 500);
                }
            } else if (currentLvl <= 14) {
                if (currentLvl == 14) {
                    user.setMaxExp(currentMaxExp + 3000);
                } else {
                    user.setMaxExp(currentMaxExp + 1000);
                }
            } else if (currentLvl <= 19) {
                if (currentLvl == 19) {
                    user.setMaxExp(currentMaxExp + 5000);
                } else {
                    user.setMaxExp(currentMaxExp + 2000);
                }
            }

            userService.updateUser(user);
            sendMessage("Повышен уровень", message);
        } else {
            userService.updateUser(user);
        }
    }
}
