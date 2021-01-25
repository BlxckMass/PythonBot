package ru.blackmass.bot.commands.main;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.VkCommand;
import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.utils.MessageTextUtil;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.keyboards.PythonKeyboard;
import ru.blackmass.bot.services.FlagService;
import ru.blackmass.bot.services.UserService;
import ru.blackmass.bot.utils.VkRequestsUtil;

import java.util.List;

@Component
@Getter
public class BeginCommand extends VkCommand {

    private Logger log;
    private VkRequestsUtil vkRequestsUtil;
    private UserService userService;
    private FlagService flagService;
    private UserActor user;
    private PythonKeyboard pythonKeyboard;

    @Autowired
    public BeginCommand(VkApiClient vk, GroupActor group, Logger log, VkRequestsUtil vkRequestsUtil, UserService userService, FlagService flagService, UserActor user, PythonKeyboard pythonKeyboard) {
        super(vk, group, log);
        this.log = log;
        this.vkRequestsUtil = vkRequestsUtil;
        this.userService = userService;
        this.flagService = flagService;
        this.user = user;
        this.pythonKeyboard = pythonKeyboard;
    }

    @Override
    public void run(Message message) {

        User mainer = userService.findUserById(message.getFromId());

        try {
            if (mainer == null) {
                List<UserXtrCounters> users = vkRequestsUtil.findUserInVk(message.getFromId().toString());
                String ref = message.getRef();
                User newUser = new User();
                newUser.setId(message.getFromId());
                newUser.setName(users.get(0).getFirstName());
                newUser.setLastName(users.get(0).getLastName());
                newUser.setNickname(users.get(0).getFirstName() + " " + users.get(0).getLastName());

                if (ref == null) {
                    newUser.setFlag(flagService.createNewFlag(message.getFromId()));
                    if (!message.getPeerId().equals(message.getFromId())) {
                        sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createChatMainKeyboard());
                    } else {
                        sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createMainKeyboard());
                    }
                } else {
                    newUser.setFlag(flagService.createNewFlagWithReferral(message.getFromId()));

                    if (!message.getPeerId().equals(message.getFromId())) {
                        sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createChatMainKeyboard());
                    } else {
                        sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createMainKeyboard());
                    }

                    setReferralsAndReferrers(message, newUser, true);
                }

                userService.updateUser(newUser);
            } else if (!mainer.getFlag().isReferral() &&
                    message.getRef() != null && !String.valueOf(mainer.getId()).equals(message.getRef())) {
                if (!message.getPeerId().equals(message.getFromId())) {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createChatMainKeyboard());
                } else {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createMainKeyboard());
                }
                setReferralsAndReferrers(message, mainer, false);
            } else if (mainer.getFlag().isReferral() && message.getRef() != null) {
                if (!message.getPeerId().equals(message.getFromId())) {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createChatMainKeyboard());
                } else {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createMainKeyboard());
                }
                sendMessage("Вы уже чей-то реферал!", message);
            } else {
                if (!message.getPeerId().equals(message.getFromId())) {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createChatMainKeyboard());
                } else {
                    sendMessage(MessageTextUtil.getBeginText(), message, pythonKeyboard.createMainKeyboard());
                }
            }

        } catch (NullPointerException nullPointerException) {
            log.error("Error in BeginCommand", nullPointerException);
        }

    }

    protected void setReferralsAndReferrers(Message message, User mainer, boolean isNew) {
        if (!isNew) {
            Flag flag = mainer.getFlag();
            flag.setReferral(true);
            flagService.updateFlag(flag);
        }

        String ref = message.getRef();
        User referrer = userService.findUserById(Integer.parseInt(ref));
        referrer.setReferralsCount(referrer.getReferralsCount() + 1);
        referrer.setBalance(referrer.getBalance() + 20000);
        referrer.setPoints(referrer.getPoints() + 20);

        mainer.setBalance(mainer.getBalance() + 20000);
        userService.updateUser(referrer);
        userService.updateUser(mainer);
        Message messageForReferrer = new Message();
        messageForReferrer.setPeerId(Integer.parseInt(ref));

        sendMessage("Вас пригласил - @id" + referrer.getId() + "(" + referrer.getName() + " " + referrer.getLastName() + ")\n Вы получили 20000 байтов!", message);
        sendMessage("У вас новый реферал - @id" + mainer.getId() + "(" + mainer.getName() + " " + mainer.getLastName() + ")\n Вы получили 20000 байтов!", messageForReferrer);
    }
}
