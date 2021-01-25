package ru.blackmass.bot.commands.account;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.services.FlagService;
import ru.blackmass.bot.services.StatisticService;
import ru.blackmass.bot.services.UserService;
import ru.blackmass.bot.utils.MessageTextUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class WithdrawCommand extends VkCommand {

    private final Logger log;
    private Calendar calendar;
    private StatisticService statisticService;
    private UserService userService;
    private FlagService flagService;

    private static final int BEGIN_DAY_WITHDRAW = 14;
    private static final int BEGIN_DAY_WITHDRAW_TWO = 15;
    private static final int BEGIN_NIGHT_WITHDRAW = 23;

    @Autowired
    public WithdrawCommand(VkApiClient vk, GroupActor group, Logger log, StatisticService statisticService, UserService userService, FlagService flagService) {
        super(vk, group, log);
        this.log = log;
        this.statisticService = statisticService;
        this.userService = userService;
        this.flagService = flagService;
    }

    @Override
    public void run(Message message) {

        if (!message.getPeerId().equals(message.getFromId())) {
            sendMessage(MessageTextUtil.getErrorWithdrawInChat(), message);
            sendSticker(message, 17209);
            return;
        }

        calendar = new GregorianCalendar();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);

        if (currentHour == BEGIN_DAY_WITHDRAW ||
                currentHour == BEGIN_DAY_WITHDRAW_TWO ||
                currentHour == BEGIN_NIGHT_WITHDRAW) {
            User user = userService.findUserById(message.getFromId());
            Flag flag = flagService.findFlagById(message.getFromId());

            if (user.getBalance() >= 1000 && !flag.isWithdraw()) {
                flag.setWithdraw(true);
                flagService.updateFlag(flag);

                int currentBalance = user.getBalance();
                int sumWithdraw = user.getMaxWithdraw();

                if (currentBalance <= sumWithdraw) {
                    makeWithdraw(message, user, 1, true);
                } else if (user.getFlag().isVip()) {
                    makeWithdraw(message, user, 2, currentBalance <= sumWithdraw * 2);
                } else if (user.getFlag().isPremium()) {
                    makeWithdraw(message, user, 3, currentBalance <= sumWithdraw * 3);
                } else {
                    makeWithdraw(message, user, 1, false);
                }
                return;
            } else if (flag.isWithdraw()){
                sendMessage(MessageTextUtil.getWithdrawAlreadyText(), message);
                sendSticker(message, 17204);
                return;
            } else {
                sendMessage(MessageTextUtil.getWithdrawNoCoinsText(), message);
                sendSticker(message, 17204);
                return;
            }
        }

        sendMessage(MessageTextUtil.getWithdrawTimeIsNotWithdrawText(), message);
        sendSticker(message, 17204);
    }

    public void makeWithdraw(Message message, User user, int odds, boolean isAll) {
        int currentBalance = user.getBalance();
        int sumWithdraw = user.getMaxWithdraw();

        if (isAll) {
            user.setBalance(0);
            user.setWithdrawn(user.getWithdrawn() + currentBalance);
            userService.updateUser(user);
            sendMessage(MessageTextUtil.getWithdrawText(calendar, currentBalance), message);
            statisticService.refreshWithdrawCountAndAmount(currentBalance);
        } else {
            user.setBalance(currentBalance - sumWithdraw * odds);
            user.setWithdrawn(user.getWithdrawn() + sumWithdraw * odds);
            userService.updateUser(user);
            sendMessage(MessageTextUtil.getWithdrawText(calendar, sumWithdraw * odds), message);
            statisticService.refreshWithdrawCountAndAmount(sumWithdraw * odds);
        }

        sendSticker(message, 17194);
    }
}
