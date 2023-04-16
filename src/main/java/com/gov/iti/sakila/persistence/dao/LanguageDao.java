package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.presentation.dto.LanguageDto;

import com.gov.iti.sakila.mappers.LanguageMapper;
import com.gov.iti.sakila.persistence.Database;

import com.gov.iti.sakila.persistence.entities.Language;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LanguageDao extends GenericDao {

    private LanguageMapper languageMapper = Mappers.getMapper(LanguageMapper.class);

    public LanguageDao() {
        super(Language.class);
    }


    public Optional<LanguageDto> getLanguageById(int id) {
        Optional<Language> languageOptional = super.getById(id);
        return languageOptional.map(languageMapper::languageToLanguageDto);
    }


    public List<LanguageDto> getAllLanguages() {
        List<Language> languages = getAll();
        return languages.stream().map(languageMapper::languageToLanguageDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public void save(LanguageDto language) {
        super.save(languageMapper.languageDtoToLanguage(language));
    }


    public void update(Object entity) {
        super.update(entity);
    }


    public void delete(LanguageDto language) {
        super.delete(languageMapper.languageDtoToLanguage(language));
    }

    public List<LanguageDto> getAllLanguagesByLimit(int start, int limit) {
        List<Language> languages = getAll();
        int endIndex = Math.min(start + limit, languages.size());
        return languages.subList(start, endIndex).stream()
                .map(languageMapper::languageToLanguageDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteById(int id) {
        Optional<Language> languageOptional = getById(id);
        languageOptional.ifPresent(language -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(language) ? language : entityManager.merge(language));
        }));
    }
}
