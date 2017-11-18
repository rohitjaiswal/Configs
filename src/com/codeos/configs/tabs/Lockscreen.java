/*
 * Copyright (C) 2017 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeos.configs.tabs;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.PreferenceFragment;
import android.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.applications.LayoutPreference;

import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.du.Utils;

public class Lockscreen extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String FINGERPRINT_PREFS_CATEGORY = "fingerprint_prefs_category";
    private static final String LOCKSCREEN_ITEMS_CATEGORY = "lockscreen_items_category";

    private LayoutPreference mFingerprintPrefs;
    private LayoutPreference mLockscreenItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.lockscreen);

        mFingerprintPrefs = (LayoutPreference) findPreference(FINGERPRINT_PREFS_CATEGORY);
        mFingerprintPrefs.setTitle(R.string.fingerprint_prefs_title);

        if (!Utils.hasFingerprintSupport(getContext())) {
            getPreferenceScreen().removePreference(mFingerprintPrefs);
        }

        mLockscreenItems = (LayoutPreference) findPreference(LOCKSCREEN_ITEMS_CATEGORY);
        mLockscreenItems.setTitle(R.string.lockscreen_items_title);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return false;
    }


    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CODEOSCONFIGS;
    }
}
