package com.domain.entities.enums;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public enum EnumDateFormat {

    DDMM(DateTimeFormatter.ofPattern("dd/MM")),
    DDMMYY(DateTimeFormatter.ofPattern("dd/MM/yy")),
    DDMMYYYY(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
    DDMMYYHHMM(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")),
    DDMMYYYYHHMM(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
    DDMMYYYYHHMMSS(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
    YYYYMMDD(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    YYYYMMDDHHMMSS(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
    YYYYMMDDTHHMM(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")),
    YYYYMMDDTHHMMSS(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
    YYYYMMDDTHHMMZ(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")),
    ISO8601(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")),
    ISO8601Z(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.'SSSSSSS'Z'")),
    MMYY(DateTimeFormatter.ofPattern("MM/yy")),
    MMYYYY(DateTimeFormatter.ofPattern("MM/yyyy")),
    EXTENSO(DateTimeFormatter.ofPattern("dd 'de' MMMMM 'de' yyyy")),
    FULLEXTENSO(DateTimeFormatter.ofPattern("EEEE',' dd 'de' MMMMM 'de' yyyy 'as' HH:mm:ss")),
    EXTENSODIAMES(DateTimeFormatter.ofPattern("dd 'de' MMMMM")),
    MMMDYYYYHHMMSSAAAEN_US(DateTimeFormatter.ofPattern("MMM d',' yyyy hh:mm:ss a", Locale.ENGLISH)),
    MMMDDYYYYHHMMSSAAAEN_US(DateTimeFormatter.ofPattern("MMM dd',' yyyy hh:mm:ss a", Locale.ENGLISH)),
    HHMM(DateTimeFormatter.ofPattern("HH:mm")),
    HHMMSS(DateTimeFormatter.ofPattern("HH:mm:ss"));

    private final DateTimeFormatter dateFormat;

    private EnumDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DateTimeFormatter getFormat() {
        return dateFormat;
    }

    public final String format(LocalDate date) {
        return dateFormat.format(date);
    }

    public LocalDate parse(String source) throws ParseException {
        return LocalDate.parse(source);
    }
}