package ru.blackmass.bot.commands.tops;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.services.FondService;
import ru.blackmass.bot.services.UserService;
import ru.blackmass.bot.utils.MessageTextUtil;

import java.util.List;
import java.util.ListIterator;

@Component
public class ActivityCommand extends VkCommand {

    private Logger log;
    private UserService userService;
    private FondService fondService;

    @Autowired
    public ActivityCommand(VkApiClient vk, GroupActor group, Logger log, UserService userService, FondService fondService) {
        super(vk, group, log);
        this.log = log;
        this.userService = userService;
        this.fondService = fondService;
    }

    @Override
    public void run(Message message) {
        int numberToper = 1;
        double fondBalance = fondService.getFondBalance();
        int fondBalanceTop = 0;
        List<User> topUsers = userService.findUsersByTopWins();
        ListIterator<User> listIterator = topUsers.listIterator();

        StringBuilder topMessage = new StringBuilder(MessageTextUtil.getActivityText(fondBalance));
        while (listIterator.hasNext()) {
            if (numberToper == 1) {
                fondBalanceTop = (int) (fondBalance * 0.5);
            } else if (numberToper == 2) {
                fondBalanceTop = (int) (fondBalance * 0.35);
            } else if (numberToper == 3) {
                fondBalanceTop = (int) (fondBalance * 0.15);
            } else break;

            User topUser = listIterator.next();
            topMessage.append("♯" + numberToper +
                    " @id" + topUser.getId() + "(" + topUser.getNickname() + ")" +
                    " ⇨ " + topUser.getPoints() + " очков ⇨ " + fondBalanceTop + " байтов\n");
            numberToper++;
            listIterator.remove();
        }

        while (listIterator.hasNext()) {
            User topUser = listIterator.next();

            topMessage.append("♯" + numberToper +
                    " @id" + topUser.getId() + "(" + topUser.getNickname() + ")" +
                    " ⇨ " + topUser.getPoints() + " очков\n");
            numberToper++;
        }

        topMessage.append("\n\uD83C\uDFC6Ваш счет: " + userService.findUserById(message.getFromId()).getPoints() + " очков\uD83C\uDFC6");

        sendMessage(topMessage.toString(), message);
    }
}
