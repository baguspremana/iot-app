package com.example.user_pc.iotapp.helper;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormated {

    public static String toRupiah(int number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double)number);
    }
}
