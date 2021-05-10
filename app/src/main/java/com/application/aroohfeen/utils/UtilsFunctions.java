package com.application.aroohfeen.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsFunctions {

    public static String convertToBirthDate(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd");
        return format.format(date);
    }
}
