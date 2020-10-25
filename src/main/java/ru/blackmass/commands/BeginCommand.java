package ru.blackmass.commands;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.data.MessageText;
import ru.blackmass.entities.User;
import ru.blackmass.keyboards.PythonKeyboard;
import ru.blackmass.services.FlagService;
import ru.blackmass.services.UserService;

import java.util.List;

@Component
@Getter
public class BeginCommand extends VkCommand {

    private UserService userService;
    private FlagService flagService;
    private UserActor user;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public BeginCommand(VkApiClient vk, GroupActor group, UserService userService, FlagService flagService, UserActor user, PythonKeyboard pythonKeyboard) {
        super(vk, group);
        this.userService = userService;
        this.flagService = flagService;
        this.user = user;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {

        User mainer = userService.getUserById(message.getFromId());

        if (mainer == null) {
            List<UserXtrCounters> users = getVk().users().get(user)
                    .userIds(message.getFromId().toString())
                    .execute();
            User newUser = new User();
            newUser.setId(message.getFromId());
            newUser.setName(users.get(0).getFirstName());
            newUser.setLastName(users.get(0).getLastName());
            newUser.setClickPower(5);
            newUser.setExpBoost(1);
            newUser.setMaxExp(250);
            newUser.setMaxWithdraw(3000);
            newUser.setFlag(flagService.createNewFlag(message.getFromId()));

            userService.updateUser(newUser);
        }

        sendMessage(MessageText.getBeginText(), message, pythonKeyboard.createMainKeyboard());
    }

}
