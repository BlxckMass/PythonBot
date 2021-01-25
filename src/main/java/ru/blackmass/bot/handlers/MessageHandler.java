package ru.blackmass.bot.handlers;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.PythonCommands;
import ru.blackmass.bot.commands.games.GameChooser;
import ru.blackmass.bot.utils.CommandTextUtil;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.services.UserService;
import ru.blackmass.bot.utils.VkRequestsUtil;

import java.net.SocketTimeoutException;

@Component
@Getter
public class MessageHandler {

    private VkApiClient vk;
    private GroupActor group;
    private VkRequestsUtil vkRequestsUtil;
    private PythonCommands pythonCommands;
    private GameChooser gameChooser;
    private UserService userService;

    @Autowired
    public MessageHandler(VkApiClient vk, GroupActor group, VkRequestsUtil vkRequestsUtil, PythonCommands pythonCommands, GameChooser gameChooser, UserService userService) {
        this.vk = vk;
        this.group = group;
        this.vkRequestsUtil = vkRequestsUtil;
        this.pythonCommands = pythonCommands;
        this.gameChooser = gameChooser;
        this.userService = userService;
    }

    public void parseMessage(Integer groupId, Message message) throws SocketTimeoutException {
//        if (message.getFromId() != 233894995) {
//            return;
//        }
        String fullMessage = message.getText().toLowerCase();

        if (fullMessage.contains("[club180945535|@pxthxnshop]")) {
            fullMessage = fullMessage.substring(28);
        }

        String[] splitMessage = fullMessage.split(" ");
        String command = fullMessage;

        if (splitMessage[0].contains("промокод") ||
                splitMessage[0].contains("ник") ||
                splitMessage[0].contains("перевод")) {
            command = splitMessage[0];
        }

        switch (command) {
            case CommandTextUtil.beginLower:
                pythonCommands.getBeginCommand().run(message);
                break;

            case CommandTextUtil.clickLower:
                pythonCommands.getClickCommand().run(message);
                break;

            case CommandTextUtil.tasksLower:
                pythonCommands.getTasksCommand().run(message);
                break;

            case CommandTextUtil.taskVkTargetLower:
                pythonCommands.getTaskVkTarget().run(message);
                break;

            case CommandTextUtil.taskKrutilkaLower:
                pythonCommands.getTaskKrutilka().run(message);
                break;

            case CommandTextUtil.taskLottohaLower:
                pythonCommands.getTaskLottoha().run(message);
                break;

            case CommandTextUtil.taskFartGameLower:
                pythonCommands.getTaskFartGame().run(message);
                break;

            case CommandTextUtil.myAccountLower:
                pythonCommands.getMyAccountCommand().run(message);
                break;

            case CommandTextUtil.myBankLower:
                pythonCommands.getMyBankCommand().run(message);
                break;

            case CommandTextUtil.payBytesLower:
                pythonCommands.getPayBytesCommand().run(message);
                break;

            case CommandTextUtil.withdrawLower:
                pythonCommands.getWithdrawCommand().run(message);
                break;

            case CommandTextUtil.infoLower:
                pythonCommands.getInfoCommand().run(message);
                break;

            case CommandTextUtil.buyOrSellLower:
                pythonCommands.getBuyOrSellCommand().run(message);
                break;

            case CommandTextUtil.buyBytesLower:
                pythonCommands.getBuyByteCoinCommand().run(message);
                break;

            case CommandTextUtil.sellVkCoinsLower:
                pythonCommands.getSellVkCoinCommand().run(message);
                break;

            case CommandTextUtil.vipLower:
                pythonCommands.getVipCommand().run(message);
                break;

            case CommandTextUtil.gamesLower:
                pythonCommands.getGamesCommand().run(message);
                break;

            case CommandTextUtil.moreLower:
                User gamerMore = userService.findUserById(message.getFromId());
                if (gamerMore.getFlag().isOpenMoreOrLessChoice()) {
                    pythonCommands.getMoreOrLessGameCommand().finalGame(gamerMore, message, CommandTextUtil.more);
                }
                break;

            case CommandTextUtil.lessLower:
                User gamerLess = userService.findUserById(message.getFromId());
                if (gamerLess.getFlag().isOpenMoreOrLessChoice()) {
                    pythonCommands.getMoreOrLessGameCommand().finalGame(gamerLess, message, CommandTextUtil.less);
                }
                break;

            case CommandTextUtil.bumCaseLower:
            case CommandTextUtil.silverCaseLower:
            case CommandTextUtil.goldCaseLower:
            case CommandTextUtil.premiumCaseLower:
                pythonCommands.getCaseGameCommand().finalGame(message, command);
                break;

            case CommandTextUtil.chestsLower:
            case CommandTextUtil.exitChestsLower:
                pythonCommands.getChestsGameCommand().run(message);
                break;

            case CommandTextUtil.goldChestLower:
            case CommandTextUtil.magicChestLower:
            case CommandTextUtil.epicChestLower:
            case CommandTextUtil.legendaryChestLower:
            case CommandTextUtil.pythonChestLower:
                pythonCommands.getChestsGameCommand().selectChest(message, command);
                break;

            case CommandTextUtil.openGoldChestLower:
            case CommandTextUtil.openMagicChestLower:
            case CommandTextUtil.openEpicChestLower:
            case CommandTextUtil.openLegendaryChestLower:
            case CommandTextUtil.openPythonChestLower:
                pythonCommands.getChestsGameCommand().openChest(message, command);
                break;

            case CommandTextUtil.thimblesGameLower:
                pythonCommands.getThimblesGameCommand().run(message);
                break;

            case CommandTextUtil.moreOrLessGameLower:
                pythonCommands.getMoreOrLessGameCommand().run(message);
                break;

            case CommandTextUtil.caseGameLower:
                pythonCommands.getCaseGameCommand().run(message);
                break;

            case CommandTextUtil.fortuneWheelGameLower:
                pythonCommands.getFortuneWheelGameCommand().run(message);
                break;

            case CommandTextUtil.fortuneWheelRollLower:
                pythonCommands.getFortuneWheelGameCommand().rollFortuneWheel(message);
                break;

            case CommandTextUtil.fortuneWheelPrizesLower:
                pythonCommands.getFortuneWheelGameCommand().getPrizes(message);
                break;

            case CommandTextUtil.topLower:
                pythonCommands.getTopCommand().run(message);
                break;

            case CommandTextUtil.topClickersLower:
                pythonCommands.getTopClickersCommand().run(message);
                break;

            case CommandTextUtil.topCoinsLower:
                pythonCommands.getTopCoinsCommand().run(message);
                break;

            case CommandTextUtil.topLvlLower:
                pythonCommands.getTopLevelCommand().run(message);
                break;

            case CommandTextUtil.topPromoLower:
                pythonCommands.getTopPromoCodeCommand().run(message);
                break;

            case CommandTextUtil.topReferralsLower:
                pythonCommands.getTopReferralsCommand().run(message);
                break;

            case CommandTextUtil.activityLower:
                pythonCommands.getActivityCommand().run(message);
                break;

            case CommandTextUtil.promoCodeLower:
                pythonCommands.getPromoCodeCommand().run(message);
                break;

            case CommandTextUtil.nicknameLower:
                pythonCommands.getChangeNicknameCommand().run(message);
                break;

            case CommandTextUtil.transferBytesLower:
                pythonCommands.getTransferBytesCommand().run(message);
                break;

            case CommandTextUtil.exitMainMenuLower:
                pythonCommands.getExitMainMenu().run(message);
                break;

            case CommandTextUtil.exitOfGamesLower:
                pythonCommands.getExitOfGamesCommand().run(message);
                break;

            default:

        }

        if (command.matches("-?\\d+(\\.\\d+)?")) {
            try {
                int betOrChoose = Integer.parseInt(command);
                User user = userService.findUserById(message.getFromId());

                if (user.getFlag().isOpenThimbles()) {
                    pythonCommands.getThimblesGameCommand().runGame(user, message, betOrChoose);
                } else if (user.getFlag().isOpenMoreOrLess()) {
                    pythonCommands.getMoreOrLessGameCommand().runGame(user, message, betOrChoose);
                } else if (user.getFlag().isOpenThimblesChoice()) {
                    pythonCommands.getThimblesGameCommand().finalGame(user, message, betOrChoose);
                }
            } catch (NumberFormatException numberFormatException) {
                vkRequestsUtil.sendMessage(message, "Слишком большое число, попробуй еще раз.");
            }
        }
    }
}
