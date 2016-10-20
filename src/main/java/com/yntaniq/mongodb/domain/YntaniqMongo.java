package com.yntaniq.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "yntaniq")
public class YntaniqMongo {

    @Id
    private String id;

    @Field
    private long id_mysql;

    @Field
    private String anun;

    @Field
    private String azganun;

    @Field
    private Date tsnund;

    @Field
    private String ser;

    public YntaniqMongo(){
    }

    public YntaniqMongo(Long id_mysql, String anun, String azganun, Date tsnund, String ser) {
        this.id_mysql = id_mysql;
        this.anun = anun;
        this.azganun = azganun;
        this.tsnund = tsnund;
        this.ser = ser;
    }

    public void mofify(YntaniqMongo yntaniqMongo){
        this.anun = yntaniqMongo.anun;
        this.azganun = yntaniqMongo.azganun;
        this.tsnund = yntaniqMongo.tsnund;
        this.ser = yntaniqMongo.ser;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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

    public long getId_mysql() {
        return id_mysql;
    }

    public void setId_mysql(long id_mysql) {
        this.id_mysql = id_mysql;
    }

    @Override
    public String toString() {
        return "YntaniqMongo {" +
                "id=" + id +
                ", anun='" + anun + '\'' +
                ", azganun='" + azganun + '\'' +
                ", tsnund='" + tsnund + '\'' +
                ", ser=" + ser +
                '}';
    }


}