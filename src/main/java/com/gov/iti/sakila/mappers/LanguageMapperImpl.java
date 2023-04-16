package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.LanguageDto;
import com.gov.iti.sakila.persistence.entities.Language;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T19:19:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDto languageToLanguageDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setLanguageId( language.getLanguageId() );
        languageDto.setName( language.getName() );
        languageDto.setLastUpdate( language.getLastUpdate() );

        return languageDto;
    }

    @Override
      public Language languageDtoToLanguage(LanguageDto language) {
        if ( language == null ) {
            return null;
        }

        Language language1 = new Language();

        language1.setLanguageId( language.getLanguageId() );
        language1.setName( language.getName() );
        language1.setLastUpdate( language.getLastUpdate() );

        return language1;
    }
}
