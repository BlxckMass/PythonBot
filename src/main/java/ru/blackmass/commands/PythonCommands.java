package ru.blackmass.commands;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.commands.tasks.TaskKrutilka;
import ru.blackmass.commands.tasks.TaskVkTarget;
import ru.blackmass.commands.tasks.TasksCommand;
import ru.blackmass.commands.tops.*;

@Component
@Getter
public class PythonCommands {

    private BeginCommand beginCommand;
    private ClickCommand clickCommand;
    private TasksCommand tasksCommand;
    private MyAccountCommand myAccountCommand;
    private InfoCommand infoCommand;
    private BuyCommand buyCommand;
    private VipCommand vipCommand;
    private GamesCommand gamesCommand;
    private TopClickersCommand topClickersCommand;
    private TopCoinsCommand topCoinsCommand;
    private TopLevelCommand topLevelCommand;
    private ActivityCommand activityCommand;
    private ExitMainMenu exitMainMenu;
    private TopCommand topCommand;
    private TaskVkTarget taskVkTarget;
    private TaskKrutilka taskKrutilka;
    private PayBytesCommand payBytesCommand;
    private WithdrawCommand withdrawCommand;

    @Autowired
    public PythonCommands(BeginCommand beginCommand,
                          InfoCommand infoCommand,
                          ClickCommand clickCommand,
                          TasksCommand tasksCommand,
                          MyAccountCommand myAccountCommand,
                          BuyCommand buyCommand,
                          VipCommand vipCommand,
                          GamesCommand gamesCommand,
                          TopClickersCommand topClickersCommand,
                          TopCoinsCommand topCoinsCommand,
                          TopLevelCommand topLevelCommand,
                          ActivityCommand activityCommand,
                          ExitMainMenu exitMainMenu,
                          TopCommand topCommand,
                          TaskVkTarget taskVkTarget,
                          TaskKrutilka taskKrutilka,
                          PayBytesCommand payBytesCommand,
                          WithdrawCommand withdrawCommand) {
        this.beginCommand = beginCommand;
        this.infoCommand = infoCommand;
        this.clickCommand = clickCommand;
        this.tasksCommand = tasksCommand;
        this.myAccountCommand = myAccountCommand;
        this.buyCommand = buyCommand;
        this.vipCommand = vipCommand;
        this.gamesCommand = gamesCommand;
        this.topClickersCommand = topClickersCommand;
        this.topCoinsCommand = topCoinsCommand;
        this.topLevelCommand = topLevelCommand;
        this.activityCommand = activityCommand;
        this.exitMainMenu = exitMainMenu;
        this.topCommand = topCommand;
        this.taskVkTarget = taskVkTarget;
        this.taskKrutilka = taskKrutilka;
        this.payBytesCommand = payBytesCommand;
        this.withdrawCommand = withdrawCommand;
    }
}
