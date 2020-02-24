package com.hexagon.parcodriver.constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AppConstants {

    public static final String BASE_URL ="http://backend.foodclubapp.com/";

    public static final String LOGIN_URL = BASE_URL + "api/v1/user/login";
    public static final String LOGOUT_URL = BASE_URL + "api/v1/logout";
    public static final String GUEST_URL = BASE_URL + "api/v1/guest/token";
    public static final String SIGNUP_URL = BASE_URL + "/api/v1/user/validate";
    public static final String FORGET_URL = BASE_URL + "api/v1/user/password/reset";
    public static final String CATEGORY_URL = BASE_URL + "api/v1/restaurant/menu/category/list";
    public static final String MENULIST_URL = BASE_URL + "api/v1/restaurant/menu/list";
    public static final String UPDATE_PROFILE_URL = BASE_URL + "api/v1/update/profile";


    public static final String IS_KIOSKMODE = "IS_KIOSKMODE";
    public static final String IS_LOGIN = "islogin";
    public static final String SESSION_ID = "SESSION_ID";
    public static final String USER_ID = "USERID";
    public static final String GCM_TOKEN = "gcm_token";
    public static final String PHONE = "PHONE";
    public static final String USER_NAME = "USER_NAME";
    public static final String NAME = "NAME";
    public static final String EMAIL = "email";
    public static final String COUNTRY_CODE = "country_code";
    public static final String PROFILE_PIC = "profile_pic";
    public static final String LATITUDE = "latitude";
    public static final String LOGITUDE = "logitude";
    public static final String STATUS = "status";
    public static final String CPR_NUMBER = "cpr_number";
    public static final String REFERAL = "referral";
    public static final String LANGUAGE = "language";
    public static final String AMOUNT = "amount";
    public static final String IS_ASSIGNED = "is_assigned";
    public static final String API_KEY = "api_key";
    public static final String GUEST_TOKEN = "guest_token";

    public static final String IS_FIRST_TIME_GUEST = "IsFirstTimeGuest";





    public static String comileDates(String startDate, String endDate) {

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            java.util.Date date1 = simpleDateFormat.parse(startDate);
            java.util.Date date2 = simpleDateFormat.parse(endDate);

            return printDifference(date1, date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "00:00:00";

    }


    public static String printDifference(java.util.Date startDate, java.util.Date endDate) {

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;

        long hoursVal = elapsedDays * 24;


        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;

        String hours = (hoursVal + elapsedHours) + " Hours," + elapsedMinutes + "Min";
        return hours;
    }


    public static String getCurrentDateTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());

        return formattedDate;
    }


    public static String getDayName(String dateInString) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date convertedCurrentDate;
        try {
            convertedCurrentDate = date.parse(dateInString);

            SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMM y h:m a");
            return simpledateformat.format(convertedCurrentDate).toString().toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String getDate(String dateInString) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date convertedCurrentDate;
        try {
            convertedCurrentDate = date.parse(dateInString);

            SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMM y");
            return simpledateformat.format(convertedCurrentDate).toString().toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String getDateVal(String dateInString) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date convertedCurrentDate;
        try {
            convertedCurrentDate = date.parse(dateInString);

            SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMM y");
            return simpledateformat.format(convertedCurrentDate).toString().toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String getHoursMiute(String dateInString) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date convertedCurrentDate;
        try {
            convertedCurrentDate = date.parse(dateInString);

            SimpleDateFormat simpledateformat = new SimpleDateFormat("h:m a");
            return simpledateformat.format(convertedCurrentDate).toString().toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
