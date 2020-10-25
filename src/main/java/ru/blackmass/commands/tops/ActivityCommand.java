package ru.blackmass.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.VkCommand;
import ru.blackmass.entities.User;
import ru.blackmass.services.UserService;

import java.util.Iterator;
import java.util.List;

@Component
public class ActivityCommand extends VkCommand {

    private UserService userService;

    public ActivityCommand(VkApiClient vk, GroupActor group) {
        super(vk, group);
    }

    @Override
    public void run(Message message) throws ClientException, ApiException {

//        List<User> topUsers = userService.getUsersTopBalance();
//        Iterator<User> iterator = topUsers.iterator();

        sendMessage("Activity", message);
    }
}
