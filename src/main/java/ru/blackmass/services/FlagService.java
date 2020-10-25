package ru.blackmass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blackmass.entities.Flag;
import ru.blackmass.repositories.FlagRepository;

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

}
