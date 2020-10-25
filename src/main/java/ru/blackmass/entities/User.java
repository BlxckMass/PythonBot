package ru.blackmass.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @OneToOne
    @JoinColumn(name = "flag_id", referencedColumnName = "flag_id")
    private Flag flag;

    @Id
    private Integer id;

    private String nickName;
    private String name;
    private String lastName;

    private int balance;
    private int bank;
    private int lvl;
    private int exp;
    private int expBoost;
    private int maxExp;
    private int clickPower;
    private int countClick;
    private int maxWithdraw;
    private int wins;

}
