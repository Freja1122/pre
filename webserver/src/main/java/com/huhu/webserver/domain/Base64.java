package com.huhu.webserver.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: webserver
 * @description:
 * @author: Annntn
 * @create: 2018-06-10 17:44
 **/
@Entity
public class Base64 extends Entitys implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private String baseData;
    @Column(nullable = true)
    private String toName;
    @Column(nullable = false)
    private String fromName;
    @Column(nullable = true)
    private String createTime;
    @Column(nullable = true)
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseData() {
        return baseData;
    }

    public void setBaseData(String baseData) {
        this.baseData = baseData;
    }


    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
