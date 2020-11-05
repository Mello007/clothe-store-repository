package com.bot.analyze.dto;

public enum LocalizationEnum {
    RU("ru"), EN("en"), DE("de");

    private final String localization;

    LocalizationEnum(String localization) {
        this.localization = localization;
    }

    public String getLocalization(){
        return localization;
    }
}
