package ru.blackmass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blackmass.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
    List<User> findTop10ByOrderByBalanceDesc();
    List<User> findTop10ByOrderByCountClickDesc();
    List<User> findTop10ByOrderByLvlDescExpDesc();

}
