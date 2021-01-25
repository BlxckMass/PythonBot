package ru.blackmass.bot.starter;

import lombok.SneakyThrows;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.entities.Statistic;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.handlers.CallbackLongPollHandler;
import ru.blackmass.bot.services.FlagService;
import ru.blackmass.bot.services.StatisticService;
import ru.blackmass.bot.services.UserService;
import ru.blackmass.bot.timers.DailyTimerTask;
import ru.blackmass.bot.utils.VkRequestsUtil;

import java.util.*;

@Component
public class Starter {

    private Logger log;
    private CallbackLongPollHandler handler;
    private DailyTimerTask dailyTimerTask;
    private StatisticService statisticService;
    private VkRequestsUtil vkRequestsUtil;
    private UserService userService;
    private FlagService flagService;

    @Autowired
    public Starter(Logger log, CallbackLongPollHandler handler, DailyTimerTask dailyTimerTask, StatisticService statisticService, VkRequestsUtil vkRequestsUtil, UserService userService, FlagService flagService) {
        this.log = log;
        this.handler = handler;
        this.dailyTimerTask = dailyTimerTask;
        this.statisticService = statisticService;
        this.vkRequestsUtil = vkRequestsUtil;
        this.userService = userService;
        this.flagService = flagService;
    }

    @SneakyThrows
    public void start() {

//        long begin = System.nanoTime();
//
//        List<User> allUsers = userService.findAllUsers();
//
//        for (User user : allUsers) {
//            Message message = new Message();
//            message.setPeerId(user.getId());
//
//            vkRequestsUtil.sendMessageWithAttachment(message, "ЖИРНЫЙ КОНКУРС РЕПОСТОВ НА ВИПКИ И БАЙТЫ! РЕПОСТЬ И ВЫИГРЫВАЙ!", "wall-180945535_7737");
//        }
//
//        System.out.println(System.nanoTime() - begin);

        Calendar calendar = Calendar.getInstance();
        Date todayDate = calendar.getTime();

        Statistic statistic = statisticService.findStatisticByDate(todayDate);
        if (statistic == null) {
            statistic = new Statistic();
            statistic.setDate(todayDate);
            statisticService.saveStatistic(statistic);
        }

        Timer timer = new Timer();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        timer.schedule(dailyTimerTask, calendar.getTime(), 1000 * 60 * 60 * 24);

        handler.run();
    }

}
