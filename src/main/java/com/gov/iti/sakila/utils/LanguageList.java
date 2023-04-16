package com.gov.iti.sakila.utils;

import com.gov.iti.sakila.presentation.dto.LanguageDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class LanguageList {


    private ArrayList<LanguageDto> languages;


    public LanguageList(ArrayList<LanguageDto> languages) {
        this.languages = languages;
    }

    public LanguageList() {
    }

    @XmlElement(name = "language")
    public ArrayList<LanguageDto> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<LanguageDto> languages) {
        this.languages = languages;
    }
}


