package com.example.user_pc.iotapp.helper;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormated {

    public  static String setDate(String oldDate){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(oldDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("dd MMMM yyyy HH:mm").format(date);
    }

    public static String setPretty(String oldDate){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(oldDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String prettyString;
        PrettyTime prettyTime = new PrettyTime();
        prettyString = prettyTime.format(date);
        return prettyString;
    }

}
