package ru.blackmass.bot.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "flags")
@Getter
@Setter
public class Flag {

    @Id
    @Column(name = "flag_id")
    private Integer flagId;

    @OneToOne(mappedBy = "flag")
    private User user;

    @Column(name = "vip")
    private boolean vip = false;

    @Column(name = "premium")
    private boolean premium = false;

    @Column(name = "daily_flip")
    private boolean dailyFlip = false;

    @Column(name = "withdraw")
    private boolean withdraw = false;

    @Column(name = "is_activated_promo_code")
    private boolean isActivatedPromoCode = false;

    @Column(name = "is_referral")
    private boolean isReferral = false;

    @Column(name = "is_open_thimbles")
    private boolean isOpenThimbles = false;

    @Column(name = "is_open_more_or_less")
    private boolean isOpenMoreOrLess = false;

    @Column(name = "is_open_thimbles_choice")
    private boolean isOpenThimblesChoice = false;

    @Column(name = "is_open_more_or_less_choice")
    private boolean isOpenMoreOrLessChoice = false;

    @Column(name = "gold_keys")
    private int goldKeys;

    @Column(name = "magic_keys")
    private int magicKeys;

    @Column(name = "epic_keys")
    private int epicKeys;

    @Column(name = "legendary_keys")
    private int legendaryKeys;

    @Column(name = "python_keys")
    private int pythonKeys;

}
