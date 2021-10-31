package com.thefear.calculator.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.thefear.calculator.logic.Theme;

public class ThemeStorage {
    private static final String ARG_THEME = "ARG_THEME";

    private final SharedPreferences sharedPreferences;

    public ThemeStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("theme", Context.MODE_PRIVATE);
    }

    public Theme getTheme() {
        String key = sharedPreferences.getString(ARG_THEME, Theme.THEME_LIGHT.getKey());

        for (Theme theme : Theme.values()) {
            if (theme.getKey().equals(key)) {
                return theme;
            }
        }

        return Theme.THEME_LIGHT;
    }

    public void setTheme(Theme theme) {
        sharedPreferences.edit().putString(ARG_THEME, theme.getKey()).apply();
    }
}
