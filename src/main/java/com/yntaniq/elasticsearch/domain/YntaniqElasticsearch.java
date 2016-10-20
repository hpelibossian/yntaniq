package com.yntaniq.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document ;

import java.util.Date;

@Document(indexName = "das", type = "yntaniq")

public class YntaniqElasticsearch {

    @Id
    private String id;

    private String anun;

    private String azganun;

    private Date tsnund;

    private String ser;

    public YntaniqElasticsearch(){
    }

    public YntaniqElasticsearch(Long id_mysql, String anun, String azganun, Date tsnund, String ser) {
        this.anun = anun;
        this.azganun = azganun;
        this.tsnund = tsnund;
        this.ser = ser;
    }

    public void mofify(YntaniqElasticsearch yntaniqElasticsearch){
        this.anun = yntaniqElasticsearch.anun;
        this.azganun = yntaniqElasticsearch.azganun;
        this.tsnund = yntaniqElasticsearch.tsnund;
        this.ser = yntaniqElasticsearch.ser;
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

    @Override
    public String toString() {
        return "YntaniqElasticsearch {" +
                "id=" + id +
                ", anun='" + anun + '\'' +
                ", azganun='" + azganun + '\'' +
                ", tsnund='" + tsnund + '\'' +
                ", ser=" + ser +
                '}';
    }


}