package ru.blackmass.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.repositories.FlagRepository;

import java.util.List;

@Service
public class FlagService {

    @Autowired
    private FlagRepository flagRepository;

    public Flag createNewFlag(Integer flagId) {
        Flag flag = new Flag();
        flag.setFlagId(flagId);
        flagRepository.save(flag);

        return flag;
    }

    public void saveFlag(Flag flag) {
        flagRepository.save(flag);
    }

    public Flag createNewFlagWithReferral(Integer flagId) {
        Flag flag = new Flag();
        flag.setFlagId(flagId);
        flag.setReferral(true);
        flagRepository.save(flag);

        return flag;
    }

    public void nullDailyFlags() {
        List<Flag> flags = flagRepository.findAll();
        for (Flag flag : flags) {
            flag.setWithdraw(false);
            flag.setDailyFlip(false);
        }
        flagRepository.saveAll(flags);
    }

    public void updateFlag(Flag flag) {
        flagRepository.save(flag);
    }

    public Flag findFlagById(Integer id) {
        return flagRepository.findFlagByFlagId(id);
    }

    public List<Flag> findAllFlags() {
        return flagRepository.findAll();
    }

    public List<Flag> findAllByActivatedPromo(boolean isActivatedPromoCode) {
        return flagRepository.findAllByIsActivatedPromoCode(isActivatedPromoCode);
    }

    public void saveAllFlags(List<Flag> flagList) {
        flagRepository.saveAll(flagList);
    }

}
