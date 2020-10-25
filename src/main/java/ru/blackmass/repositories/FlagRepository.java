package ru.blackmass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.blackmass.entities.Flag;

public interface FlagRepository extends JpaRepository<Flag, Integer> {

    Flag findFlagByFlagId(Integer flagId);

}
