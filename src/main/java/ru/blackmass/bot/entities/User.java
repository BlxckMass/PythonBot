package ru.blackmass.bot.entities;

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

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance")
    private int balance;

    @Column(name = "bank")
    private int bank;

    @Column(name = "lvl")
    private int lvl;

    @Column(name = "exp")
    private int exp;

    @Column(name = "exp_boost")
    private int expBoost = 1;

    @Column(name = "max_exp")
    private int maxExp = 250;

    @Column(name = "click_power")
    private int clickPower = 5;

    @Column(name = "clicks_count")
    private int clicksCount;

    @Column(name = "promo_codes_count")
    private int promoCodesCount;

    @Column(name = "max_withdraw")
    private int maxWithdraw = 3000;

    @Column(name = "withdrawn")
    private int withdrawn;

    @Column(name = "points")
    private int points;

    @Column(name = "referrals_count")
    private int referralsCount;

    @Column(name = "current_bet")
    private int currentBet;

    @Column(name = "open_chests")
    private int openChests;

    @Column(name = "open_gold_chests")
    private int openGoldChests;

    @Column(name = "open_magic_chests")
    private int openMagicChests;

    @Column(name = "open_epic_chests")
    private int openEpicChests;

    @Column(name = "open_legendary_chests")
    private int openLegendaryChests;

    @Column(name = "open_python_chests")
    private int openPythonChests;

}
