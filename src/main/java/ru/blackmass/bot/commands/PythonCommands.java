package ru.blackmass.bot.commands;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.commands.account.MyAccountCommand;
import ru.blackmass.bot.commands.account.MyBankCommand;
import ru.blackmass.bot.commands.account.PayBytesCommand;
import ru.blackmass.bot.commands.account.WithdrawCommand;
import ru.blackmass.bot.commands.buy.BuyByteCoinCommand;
import ru.blackmass.bot.commands.buy.BuyOrSellCommand;
import ru.blackmass.bot.commands.buy.SellVkCoinCommand;
import ru.blackmass.bot.commands.exits.ExitMainMenu;
import ru.blackmass.bot.commands.exits.ExitOfGamesCommand;
import ru.blackmass.bot.commands.games.*;
import ru.blackmass.bot.commands.main.*;
import ru.blackmass.bot.commands.single.ChangeNicknameCommand;
import ru.blackmass.bot.commands.single.PromoCodeCommand;
import ru.blackmass.bot.commands.single.TransferBytesCommand;
import ru.blackmass.bot.commands.tasks.*;
import ru.blackmass.bot.commands.tops.*;

@Component
@Getter
public class PythonCommands {

    private BeginCommand beginCommand;
    private ClickCommand clickCommand;
    private TasksCommand tasksCommand;
    private MyAccountCommand myAccountCommand;
    private MyBankCommand myBankCommand;
    private InfoCommand infoCommand;
    private BuyOrSellCommand buyOrSellCommand;
    private BuyByteCoinCommand buyByteCoinCommand;
    private SellVkCoinCommand sellVkCoinCommand;
    private VipCommand vipCommand;
    private GamesCommand gamesCommand;
    private ThimblesGameCommand thimblesGameCommand;
    private MoreOrLessGameCommand moreOrLessGameCommand;
    private CaseGameCommand caseGameCommand;
    private ChestsGameCommand chestsGameCommand;
    private FortuneWheelGameCommand fortuneWheelGameCommand;
    private TopClickersCommand topClickersCommand;
    private TopCoinsCommand topCoinsCommand;
    private TopLevelCommand topLevelCommand;
    private TopPromoCodeCommand topPromoCodeCommand;
    private TopReferralsCommand topReferralsCommand;
    private ActivityCommand activityCommand;
    private ExitMainMenu exitMainMenu;
    private ExitOfGamesCommand exitOfGamesCommand;
    private TopCommand topCommand;
    private TaskVkTarget taskVkTarget;
    private TaskKrutilka taskKrutilka;
    private TaskLottoha taskLottoha;
    private TaskFartGame taskFartGame;
    private PayBytesCommand payBytesCommand;
    private WithdrawCommand withdrawCommand;
    private PromoCodeCommand promoCodeCommand;
    private ChangeNicknameCommand changeNicknameCommand;
    private TransferBytesCommand transferBytesCommand;

    @Autowired
    public PythonCommands(BeginCommand beginCommand,
                          InfoCommand infoCommand,
                          ClickCommand clickCommand,
                          TasksCommand tasksCommand,
                          MyAccountCommand myAccountCommand,
                          MyBankCommand myBankCommand,
                          BuyOrSellCommand buyOrSellCommand,
                          BuyByteCoinCommand buyByteCoinCommand,
                          SellVkCoinCommand sellVkCoinCommand,
                          VipCommand vipCommand,
                          GamesCommand gamesCommand,
                          ThimblesGameCommand thimblesGameCommand,
                          MoreOrLessGameCommand moreOrLessGameCommand,
                          CaseGameCommand caseGameCommand,
                          ChestsGameCommand chestsGameCommand,
                          FortuneWheelGameCommand fortuneWheelGameCommand,
                          TopClickersCommand topClickersCommand,
                          TopCoinsCommand topCoinsCommand,
                          TopLevelCommand topLevelCommand,
                          TopPromoCodeCommand topPromoCodeCommand,
                          TopReferralsCommand topReferralsCommand,
                          ActivityCommand activityCommand,
                          ExitMainMenu exitMainMenu,
                          ExitOfGamesCommand exitOfGamesCommand,
                          TopCommand topCommand,
                          TaskVkTarget taskVkTarget,
                          TaskKrutilka taskKrutilka,
                          TaskLottoha taskLottoha,
                          TaskFartGame taskFartGame,
                          PayBytesCommand payBytesCommand,
                          WithdrawCommand withdrawCommand,
                          PromoCodeCommand promoCodeCommand,
                          ChangeNicknameCommand changeNicknameCommand,
                          TransferBytesCommand transferBytesCommand) {
        this.beginCommand = beginCommand;
        this.infoCommand = infoCommand;
        this.clickCommand = clickCommand;
        this.tasksCommand = tasksCommand;
        this.myAccountCommand = myAccountCommand;
        this.myBankCommand = myBankCommand;
        this.buyOrSellCommand = buyOrSellCommand;
        this.buyByteCoinCommand = buyByteCoinCommand;
        this.sellVkCoinCommand = sellVkCoinCommand;
        this.vipCommand = vipCommand;
        this.gamesCommand = gamesCommand;
        this.thimblesGameCommand = thimblesGameCommand;
        this.moreOrLessGameCommand = moreOrLessGameCommand;
        this.caseGameCommand = caseGameCommand;
        this.chestsGameCommand = chestsGameCommand;
        this.fortuneWheelGameCommand = fortuneWheelGameCommand;
        this.topClickersCommand = topClickersCommand;
        this.topCoinsCommand = topCoinsCommand;
        this.topLevelCommand = topLevelCommand;
        this.topPromoCodeCommand = topPromoCodeCommand;
        this.topReferralsCommand = topReferralsCommand;
        this.activityCommand = activityCommand;
        this.exitMainMenu = exitMainMenu;
        this.exitOfGamesCommand = exitOfGamesCommand;
        this.topCommand = topCommand;
        this.taskVkTarget = taskVkTarget;
        this.taskKrutilka = taskKrutilka;
        this.taskLottoha = taskLottoha;
        this.taskFartGame = taskFartGame;
        this.payBytesCommand = payBytesCommand;
        this.withdrawCommand = withdrawCommand;
        this.promoCodeCommand = promoCodeCommand;
        this.changeNicknameCommand = changeNicknameCommand;
        this.transferBytesCommand = transferBytesCommand;
    }
}
