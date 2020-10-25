package ru.blackmass.entities;

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

    @Column(columnDefinition = "boolean default false")
    private boolean vip;

    @Column(columnDefinition = "boolean default false")
    private boolean premium;

    @Column(columnDefinition = "boolean default false")
    private boolean dailyFlip;

    @Column(columnDefinition = "boolean default false")
    private boolean withdraw;

//    @Column(columnDefinition = "boolean default false")
//    private boolean isOpenCups;
//
//    @Column(columnDefinition = "boolean default false")
//    private boolean isOpenMoreOrLess;
//
//    @Column(columnDefinition = "boolean default false")
//    private boolean isOpenCupsChoice;
//
//    @Column(columnDefinition = "boolean default false")
//    private boolean isOpenMoreOrLessChoice;
//

}
