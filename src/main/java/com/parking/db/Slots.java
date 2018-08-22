package com.parking.db;


import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;



@Entity

public class Slots {



    @Id
    @Column(name = "carnumber")

    private String carnumber;

    @Column(name = "slotnumber")

    private Integer slotnumber;

    @Column(name = "intime")

    private Long intime;


    public Slots() {

    }



    public String getCarnumber() {

        return carnumber;

    }



    public void setCarnumber(String carnumber	) {

        this.carnumber = carnumber;

    }



    public Integer getSlotnumber() {

        return slotnumber;

    }



    public void setSlotnumber(Integer slotnumber) {

        this.slotnumber = slotnumber;

    }



    public Long getIntime() {

        return intime;

    }



    public void setIntime(Long intime) {

        this.intime = intime;

    }



}

