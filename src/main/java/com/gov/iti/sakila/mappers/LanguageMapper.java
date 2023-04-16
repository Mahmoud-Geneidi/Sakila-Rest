package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.LanguageDto;
import com.gov.iti.sakila.persistence.entities.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LanguageMapper {

        @Mapping(source = "languageId",target = "languageId")
        @Mapping(source = "name",target = "name")
        @Mapping(source = "lastUpdate",target = "lastUpdate")

        LanguageDto languageToLanguageDto(Language language);

    @Mapping(source = "languageId",target = "languageId")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "lastUpdate",target = "lastUpdate")
    Language languageDtoToLanguage(LanguageDto language);
}

