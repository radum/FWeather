/*
 * Copyright 2014 Sebastiano Poggi and Francesco Pontillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.frakbot.FWeather.fragments;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import net.frakbot.FWeather.R;
import net.frakbot.FWeather.activity.SettingsActivity;
import org.jraf.android.backport.switchwidget.SwitchPreference;

/**
 * This fragment shows advanced settings only. It is used when the activity
 * is showing a two-pane settings UI.
 */
@SuppressLint("ValidFragment")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AdvancedPreferencesFragment extends BackupPreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_advanced);

        if (getActivity() instanceof SettingsActivity) {
            ((SettingsActivity)getActivity()).setupAnalyticsOnChangeListener(
                (SwitchPreference) findPreference(getString(R.string.pref_key_analytics)));

            ((SettingsActivity)getActivity()).bindPreferenceSummaryToValue(
                findPreference(getString(R.string.pref_key_weather_location)));
        }
    }
}
