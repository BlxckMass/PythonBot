package ru.blackmass.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.VkCommand;
import ru.blackmass.entities.User;
import ru.blackmass.keyboards.PythonKeyboard;
import ru.blackmass.services.UserService;

import java.util.List;

@Component
public class TopLevelCommand extends VkCommand {

    private UserService userService;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public TopLevelCommand(VkApiClient vk, GroupActor group, UserService userService, PythonKeyboard pythonKeyboard) {
        super(vk, group);
        this.userService = userService;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {

        int numberToper = 1;
        List<User> topUsers = userService.getUsersTopBalance();
        StringBuilder topMessage = new StringBuilder("Топ кликеров:\n");

        for (User topUser : topUsers) {
            topMessage.append("♯" + numberToper +
                    " @id" + topUser.getId() + "(" + topUser.getName() + " " + topUser.getLastName() + ")" +
                    " ⇨ " + topUser.getLvl() + " уровень (" + topUser.getExp() + " / " + topUser.getMaxExp() + ")\n");
            numberToper++;
        }

        sendMessage(topMessage.toString(), message);
    }
}
