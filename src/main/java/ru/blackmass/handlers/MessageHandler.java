package ru.blackmass.handlers;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.PythonCommands;
import ru.blackmass.commands.VkCommand;
import ru.blackmass.data.CommandText;
import ru.blackmass.keyboards.PythonKeyboard;

import java.util.Locale;
import java.util.Random;

@Component
@Getter
public class MessageHandler {

    private VkApiClient vk;
    private GroupActor group;
    private PythonKeyboard pythonKeyboard;
    private PythonCommands pythonCommands;


    @Autowired
    public MessageHandler(VkApiClient vk, GroupActor group, PythonKeyboard pythonKeyboard, PythonCommands pythonCommands) {
        this.vk = vk;
        this.group = group;
        this.pythonKeyboard = pythonKeyboard;
        this.pythonCommands = pythonCommands;
    }

    public void parseMessage(Integer groupId, Message message) throws ClientException, ApiException {

        Integer vkId = message.getFromId();
//        String[] args = message.getText().split(" ");
//        String command = args[0];
        String command = message.getText();

        if (command.contains("[club197145153|@public197145153]")) {
            command = command.substring(33);
            // System.out.println(command);
        }

        switch (command.toLowerCase()) {
            case CommandText.beginLower:
                pythonCommands.getBeginCommand().run(message);
                break;

            case CommandText.clickLower:
                pythonCommands.getClickCommand().run(message);
                break;

            case CommandText.tasksLower:
                pythonCommands.getTasksCommand().run(message);
                break;

            case CommandText.taskVkTargetLower:
                pythonCommands.getTaskVkTarget().run(message);
                break;

            case CommandText.taskKrutilkaLower:
                pythonCommands.getTaskKrutilka().run(message);
                break;

            case CommandText.myAccountLower:
                pythonCommands.getMyAccountCommand().run(message);
                break;

            case CommandText.payBytesLower:
                pythonCommands.getPayBytesCommand().run(message);
                break;

            case CommandText.withdrawLower:
                pythonCommands.getWithdrawCommand().run(message);
                break;

            case CommandText.infoLower:
                pythonCommands.getInfoCommand().run(message);
                break;

            case CommandText.buyLower:
                pythonCommands.getBuyCommand().run(message);
                break;

            case CommandText.vipLower:
                pythonCommands.getVipCommand().run(message);
                break;

            case CommandText.gamesLower:
                pythonCommands.getGamesCommand().run(message);
                break;

            case CommandText.topLower:
                pythonCommands.getTopCommand().run(message);
                break;

            case CommandText.topClickersLower:
                pythonCommands.getTopClickersCommand().run(message);
                break;

            case CommandText.topCoinsLower:
                pythonCommands.getTopCoinsCommand().run(message);
                break;

            case CommandText.topLvlLower:
                pythonCommands.getTopLevelCommand().run(message);
                break;

            case CommandText.activityLower:
                pythonCommands.getActivityCommand().run(message);
                break;

            case CommandText.exitMainMenuLower:
                pythonCommands.getExitMainMenu().run(message);
            default:

        }

    }
}
