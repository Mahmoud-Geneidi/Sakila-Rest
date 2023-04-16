package com.gov.iti.sakila.Services;

import com.gov.iti.sakila.presentation.dto.LanguageDto;
import com.gov.iti.sakila.persistence.dao.LanguageDao;
import com.gov.iti.sakila.persistence.entities.Language;

import java.util.List;
import java.util.Optional;

public class LanguageServices {
    private LanguageDao languageDao = new LanguageDao();

    public Optional<LanguageDto> getLanguageById(short id) {
        return languageDao.getLanguageById(id);
    }

    public List<LanguageDto> getAllLanguages() {
        return languageDao.getAllLanguages();
    }

    public List<LanguageDto> getAllLanguagesByLimit(int start, int limit) {
        return languageDao.getAllLanguagesByLimit(start, limit);
    }

    public void saveLanguage(LanguageDto languageDto) {
        languageDao.save(languageDto);
    }

    public void deleteLanguage(LanguageDto languageDto) {
        languageDao.delete(languageDto);
    }

    public void deleteLanguageById(int id) {
        languageDao.deleteById(id);
    }

    public void updateLanguage(LanguageDto languageDto) {
        languageDao.update(languageDto);
    }
}
