package ru.blackmass.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blackmass.bot.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
    List<User> findTop10ByOrderByBalanceDesc();
    List<User> findTop10ByOrderByClicksCountDesc();
    List<User> findTop10ByOrderByLvlDescExpDesc();
    List<User> findTop10ByOrderByPromoCodesCountDesc();
    List<User> findTop10ByOrderByReferralsCountDesc();
    List<User> findTop10ByOrderByPointsDesc();

}
