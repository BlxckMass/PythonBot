package ru.blackmass.bot.commands.main;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.services.FondService;
import ru.blackmass.bot.services.StatisticService;
import ru.blackmass.bot.utils.MessageTextUtil;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.services.UserService;

import java.util.Random;

@Component
public class ClickCommand extends VkCommand {

    private Logger log;
    private UserService userService;
    private StatisticService statisticService;
    private FondService fondService;

    @Autowired
    public ClickCommand(VkApiClient vk, GroupActor group, Logger log, UserService userService, StatisticService statisticService, FondService fondService) {
        super(vk, group, log);
        this.log = log;
        this.userService = userService;
        this.statisticService = statisticService;
        this.fondService = fondService;
    }

    @Override
    public void run(Message message) {
        if (!message.getPeerId().equals(message.getFromId())) {
            sendMessage("В беседе запрещено кликать.", message);
            sendSticker(message, 17209);
            return;
        }

        User user = userService.findUserById(message.getFromId());

        boolean isSteal = stealBritki(message, user);

        if (!isSteal) {
            user.setBalance(user.getBalance() + user.getClickPower());
            user.setExp(user.getExp() + user.getExpBoost());
            user.setClicksCount(user.getClicksCount() + 1);
            lvlUp(user, message);

            statisticService.refreshClicksCount();

            sendMessage(MessageTextUtil.getClickText(user), message);
        }

        fondService.addClickPowerToFond(user.getClickPower());
    }

    public void lvlUp(User user, Message message) {
        if (user.getExp() == user.getMaxExp()) {
            int nextLvl = user.getLvl() + 1;
            int currentMaxExp = user.getMaxExp();
            int maxWithdraw = user.getMaxWithdraw() + 500;
            user.setExp(0);
            user.setLvl(nextLvl);
            user.setMaxWithdraw(maxWithdraw);

            if (nextLvl == 2 || nextLvl == 4 || nextLvl == 6 || nextLvl == 8 || nextLvl == 10) {
                user.setClickPower(user.getClickPower() + 1);
            }

            if (nextLvl <= 4) {
                if (nextLvl == 4) {
                    user.setMaxExp(currentMaxExp + 500);
                } else {
                    user.setMaxExp(currentMaxExp + 250);
                }
            } else if (nextLvl <= 9) {
                if (nextLvl == 9) {
                    user.setMaxExp(currentMaxExp + 1500);
                } else {
                    user.setMaxExp(currentMaxExp + 500);
                }
            } else if (nextLvl <= 14) {
                if (nextLvl == 14) {
                    user.setMaxExp(currentMaxExp + 3000);
                } else {
                    user.setMaxExp(currentMaxExp + 1000);
                }
            } else if (nextLvl <= 19) {
                if (nextLvl == 19) {
                    user.setMaxExp(currentMaxExp + 5000);
                } else {
                    user.setMaxExp(currentMaxExp + 2000);
                }
            }

            userService.updateUser(user);
            sendMessage(MessageTextUtil.getLvlUpText(), message);
        } else {
            userService.updateUser(user);
        }
    }

    public boolean stealBritki(Message message, User user) {
        Random random = new Random();
        int chanceSteal = random.nextInt(101);

        if (chanceSteal <= 15) {
            int lvl = user.getLvl();
            int currentBalance = user.getBalance();
            int stealSum = 0;

            switch (lvl) {
                case 0:
                case 1:
                    stealSum = random.nextInt(3) + 5;
                    break;
                case 2:
                case 3:
                    stealSum = random.nextInt(3) + 6;
                    break;
                case 4:
                case 5:
                    stealSum = random.nextInt(4) + 7;
                    break;
                case 6:
                case 7:
                    stealSum = random.nextInt(4) + 8;
                    break;
                case 8:
                case 9:
                    stealSum = random.nextInt(5) + 9;
                    break;
                default:
                    stealSum = random.nextInt(5) + 10;
                    break;
            }
            user.setBalance(currentBalance - stealSum);
            userService.updateUser(user);

            sendMessage(MessageTextUtil.getStealClickText(stealSum), message);
            return true;
        } else {
            return false;
        }
    }
}
