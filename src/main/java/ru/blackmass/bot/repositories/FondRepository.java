package ru.blackmass.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blackmass.bot.entities.Fond;

@Repository
public interface FondRepository extends JpaRepository<Fond, Integer> {

    Fond findFondById(Integer id);

}
