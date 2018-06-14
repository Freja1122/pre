package com.huhu.webserver.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: webserver
 * @description:
 * @author: Annntn
 * @create: 2018-06-10 17:44
 **/
@Entity
public class Password extends Entitys implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,unique = true)
    private String fromName;
    @Column(nullable = true)
    private int allNumber;
    @Column(nullable = true)
    private String toName;
    @Column(nullable = true)
    private int okNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public int getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(int allNumber) {
        this.allNumber = allNumber;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getOkNumber() {
        return okNumber;
    }

    public void setOkNumber(int okNumber) {
        this.okNumber = okNumber;
    }
}
