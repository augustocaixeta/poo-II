package com.github.augustocaixeta.util;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManipulaData {
    public Date parseStringToDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Date dataSaida = Date.valueOf(LocalDate.parse(data, formatter));
        return dataSaida;
    }
    
    public String parseDateToString(String data) {
        String dataFormatada = "";
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
            dataFormatada = formatoSaida.format(formatoEntrada.parse(data));
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return dataFormatada;
    }
}
