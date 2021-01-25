package ru.blackmass.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blackmass.bot.entities.Flag;

import java.util.List;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Integer> {

    Flag findFlagByFlagId(Integer flagId);
    List<Flag> findAllByIsActivatedPromoCode(boolean isActivatedPromoCode);

}
