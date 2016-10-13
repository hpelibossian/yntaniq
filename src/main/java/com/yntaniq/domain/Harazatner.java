package com.yntaniq.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "harazatner")
public class Harazatner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String anun;

    @Column()
    private String azganun;

    @Column()
    private Date tsnund;

    @Column()
    private String ser;

    public Harazatner(){
    }

    public Harazatner(String anun, String azganun, Date tsnund, String ser) {
        this.anun = anun;
        this.azganun = azganun;
        this.tsnund = tsnund;
        this.ser = ser;
    }

    public void mofify(Harazatner yntaniq){
        this.anun = yntaniq.anun;
        this.azganun = yntaniq.azganun;
        this.tsnund = yntaniq.tsnund;
        this.ser = yntaniq.ser;
    }
    // for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAnun() {
        return anun;
    }

    public void setAnun(String anun) {
        this.anun = anun;
    }

    public String getAzganun() {
        return azganun;
    }

    public void setAzganun(String azganun) {
        this.azganun = azganun;
    }

    public Date getTsnund() {
        return tsnund;
    }

    public void setTsnund(Date tsnund) {
        this.tsnund = tsnund;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    @Override
    public String toString() {
        return "Yntaniq {" +
                "id=" + id +
                ", anun='" + anun + '\'' +
                ", azganun='" + azganun + '\'' +
                ", tsnund='" + tsnund + '\'' +
                ", ser=" + ser +
                '}';
    }


}
