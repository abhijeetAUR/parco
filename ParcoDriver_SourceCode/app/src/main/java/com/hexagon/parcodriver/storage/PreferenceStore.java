package com.hexagon.parcodriver.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.hexagon.parcodriver.ApplicationLoader;
import com.hexagon.parcodriver.constants.AppConstants;


public class PreferenceStore {

    private static PreferenceStore instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    private PreferenceStore(Context context) {
        if (context != null) {
            preferences = context.getSharedPreferences("SubCornerAppDetails", Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public static synchronized PreferenceStore getInstance() {
        instance = instance == null ? new PreferenceStore(ApplicationLoader.applicationContext) : instance;
        return instance;
    }

    public synchronized void setIsLogin(boolean isLogin) {
        editor.putBoolean(AppConstants.IS_LOGIN, isLogin);
        editor.commit();
    }

    public synchronized boolean getIsLogin() {
        return preferences.getBoolean(AppConstants.IS_LOGIN, false);
    }

    public synchronized void setFirstTimeGuest(boolean isFirstTime) {
        editor.putBoolean(AppConstants.IS_FIRST_TIME_GUEST, isFirstTime);
        editor.commit();
    }

    public synchronized boolean isFirstTimeGuest() {
        return this.preferences.getBoolean(AppConstants.IS_FIRST_TIME_GUEST, false);
    }


    public synchronized String getId() {
        return preferences.getString(AppConstants.USER_ID, "");
    }

    public synchronized void setId(String id) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.USER_ID, id);
        editor.commit();
    }


    public synchronized String getSessionId() {
        return preferences.getString(AppConstants.SESSION_ID, "");
    }

    public synchronized void setSessionId(String sessionId) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.SESSION_ID, sessionId);
        editor.commit();
    }



    public synchronized void setGCMToken(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.GCM_TOKEN, token);
        editor.commit();
    }

    public synchronized String getGCMToken() {
        return preferences.getString(AppConstants.GCM_TOKEN, "");
    }




    public synchronized void setphone(String phone) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.PHONE, phone);
        editor.commit();
    }

    public synchronized String getPhone() {
        return preferences.getString(AppConstants.PHONE, "");
    }


    public synchronized void setusername(String username) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.USER_NAME, username);
        editor.commit();
    }

    public synchronized String getusername() {
        return preferences.getString(AppConstants.USER_NAME, "");
    }

    public synchronized void setname(String username) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.NAME, username);
        editor.commit();
    }

    public synchronized String getname() {
        return preferences.getString(AppConstants.NAME, "");
    }



    public synchronized void setEmail(String email) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.EMAIL, email);
        editor.commit();
    }

    public synchronized String getEmail() {
        return preferences.getString(AppConstants.EMAIL, "");
    }

    public synchronized void setCountryCode(String country_code) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.COUNTRY_CODE, country_code);
        editor.commit();
    }

    public synchronized String getCountryCode() {
        return preferences.getString(AppConstants.COUNTRY_CODE, "");
    }

    public synchronized void setProfilePic(String country_code) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.PROFILE_PIC, country_code);
        editor.commit();
    }

    public synchronized String getProfilePic() {
        return preferences.getString(AppConstants.PROFILE_PIC, "");
    }


    public synchronized void setCprNumber(String cpr_number) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.CPR_NUMBER, cpr_number);
        editor.commit();
    }


    public synchronized String getCprNumber() {
        return preferences.getString(AppConstants.CPR_NUMBER, "");
    }


    public synchronized void setReferalCode(String cpr_number) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.REFERAL, cpr_number);
        editor.commit();
    }

    public synchronized String getReferalCode() {
        return preferences.getString(AppConstants.REFERAL, "");
    }


    public synchronized String getLanguage() {
        return preferences.getString(AppConstants.LANGUAGE, "");
    }

    public synchronized void setLanguage(String cpr_number) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.LANGUAGE, cpr_number);
        editor.commit();
    }



    public synchronized String getAmount() {
        return preferences.getString(AppConstants.AMOUNT, "");
    }

    public synchronized void setAmount(String cpr_number) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.AMOUNT, cpr_number);
        editor.commit();
    }

    public synchronized String getGuest_token() {
        return preferences.getString(AppConstants.GUEST_TOKEN, "");
    }

    public synchronized void setGuest_token(String guest_token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.GUEST_TOKEN, guest_token);
        editor.commit();
    }



    public synchronized String getApiKey() {
        return preferences.getString(AppConstants.API_KEY, "");
    }

    public synchronized void setApiKey(String cpr_number) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.API_KEY, cpr_number);
        editor.commit();
    }

    public synchronized void setLatitude(String latitude) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.LATITUDE, latitude);
        editor.commit();
    }

    public synchronized String getLatitude() {
        return preferences.getString(AppConstants.LATITUDE, "");
    }

    public synchronized void setLongitude(String latitude) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.LOGITUDE, latitude);
        editor.commit();
    }

    public synchronized String getLongitude() {
        return preferences.getString(AppConstants.LOGITUDE, "");
    }


    public synchronized void setStatus(boolean isLogin) {
        editor.putBoolean(AppConstants.STATUS, isLogin);
        editor.commit();
    }

    public synchronized boolean getStatus() {
        return preferences.getBoolean(AppConstants.STATUS, false);
    }


    public void clear() {
        preferences.edit().clear().apply();
    }


    public synchronized void setKioskMode(boolean is_kioske) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(AppConstants.IS_KIOSKMODE, is_kioske);
        editor.commit();
    }

    public synchronized boolean is_kioskMode() {
        return preferences.getBoolean(AppConstants.IS_KIOSKMODE, false);
    }







}
