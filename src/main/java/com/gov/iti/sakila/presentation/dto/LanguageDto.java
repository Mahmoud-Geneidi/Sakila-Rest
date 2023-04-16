package com.gov.iti.sakila.presentation.dto;

import java.io.Serializable;
import java.util.Date;

public class LanguageDto implements Serializable {
    private Short languageId;
    private String name;
    private Date lastUpdate;

    public LanguageDto(Short languageId, String name, Date lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public LanguageDto() {
    }

    public LanguageDto(String name, Date lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "LanguageDto{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
