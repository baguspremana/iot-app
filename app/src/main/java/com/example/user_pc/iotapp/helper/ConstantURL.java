package com.example.user_pc.iotapp.helper;

public class ConstantURL {
//    public static final String BASE_URL = "http://192.168.1.8:8000/";
//    public static final String BASE_URL = "http://192.168.43.168:8000/";
//    public static final String BASE_URL = "http://10.164.247.30:8000/";
//    public static final String BASE_URL = "http://192.168.42.86:8000/";
    public static final String BASE_URL = "http://smartbin.itcc-udayana.com/";

    public static class Permission{
        public static final int USER = 0;
        public static final int ADMIN = 1;
    }

    public static class URL{
        public static String api(){
            return BASE_URL+"api/";
        }
    }
}
