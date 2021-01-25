package ru.blackmass.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.entities.User;
import ru.blackmass.bot.repositories.FlagRepository;
import ru.blackmass.bot.repositories.UserRepository;
import ru.blackmass.bot.utils.VkRequestsUtil;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private FlagRepository flagRepository;
    private VkRequestsUtil vkRequestsUtil;

    @Autowired
    public UserService(UserRepository userRepository, FlagRepository flagRepository, VkRequestsUtil vkRequestsUtil) {
        this.userRepository = userRepository;
        this.flagRepository = flagRepository;
        this.vkRequestsUtil = vkRequestsUtil;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public void nullWins() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPoints(0);
        }
        userRepository.saveAll(users);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void updateUserById(Integer id,
                               int balance,
                               int bank,
                               int lvl,
                               int exp,
                               int maxExp,
                               int expBoost,
                               int clickPower,
                               int clicksCount,
                               int promoCodesCount,
                               int maxWithdraw,
                               int withdrawn,
                               int points,
                               int referralsCount,
                               boolean vip,
                               boolean premium) {
        User user = userRepository.findUserById(id);
        user.setBalance(balance);
        user.setBank(bank);
        user.setLvl(lvl);
        user.setExp(exp);
        user.setMaxExp(maxExp);
        user.setExpBoost(expBoost);
        user.setClickPower(clickPower);
        user.setClicksCount(clicksCount);
        user.setPromoCodesCount(promoCodesCount);
        user.setMaxWithdraw(maxWithdraw);
        user.setWithdrawn(withdrawn);
        user.setPoints(points);
        user.setReferralsCount(referralsCount);
        Flag flag = user.getFlag();
        flag.setVip(vip);
        flag.setPremium(premium);
        userRepository.save(user);
        flagRepository.save(flag);
    }

    public void updateAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public long getUsersCount() {
        return userRepository.count();
    }

    public int findBankBalance(Integer id) {
        User user = findUserById(id);
        return user.getBank();
    }

    public List<User> findUsersByTopBalance() {
        return userRepository.findTop10ByOrderByBalanceDesc();
    }

    public List<User> findUsersByTopCountClick() {
        return userRepository.findTop10ByOrderByClicksCountDesc();
    }

    public List<User> findUsersByTopLevel() {
        return userRepository.findTop10ByOrderByLvlDescExpDesc();
    }

    public List<User> findUsersByTopPromoCodes() {
        return userRepository.findTop10ByOrderByPromoCodesCountDesc();
    }

    public List<User> findUsersByTopReferrals() {
        return userRepository.findTop10ByOrderByReferralsCountDesc();
    }

    public List<User> findUsersByTopWins() {
        return userRepository.findTop10ByOrderByPointsDesc();
    }

}
