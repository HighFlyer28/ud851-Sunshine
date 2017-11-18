package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by Vlad on 11/18/2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_screen);
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int NoOfPrefs = preferenceScreen.getPreferenceCount();
        for (int i = 0; i < NoOfPrefs; i++){
            Preference pref = preferenceScreen.getPreference(i);
            if (!(pref instanceof CheckBoxPreference)){
                setPreferenceSummary(pref, sharedPreferences.getString(pref.getKey(), ""));
            }
        }

    }

    public void setPreferenceSummary(Preference preference, Object object){
        if (preference instanceof ListPreference){
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(object.toString());
            listPreference.setSummary(listPreference.getEntries()[prefIndex]);
        }
        else {
            preference.setSummary(object.toString());
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference preference = findPreference(s);
        if (preference != null){
            if (!(preference instanceof CheckBoxPreference)){
                setPreferenceSummary(preference, sharedPreferences.getString(s,""));
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
