package com.jotasantos.springbootcrud.springbootcrud.utils;

import java.time.LocalDateTime;

public class DataUtil {

    public static String getDataAtualDMYHMS() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateFormats.DMYHMS);
    }


}
