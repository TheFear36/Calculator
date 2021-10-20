package com.thefear.calculator.logic;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.thefear.calculator.R;

public enum Theme {

    THEME_PURPLE(R.string.purple_theme, R.drawable.ic_purple_theme, R.style.Theme_Calculator_Purple, "purple"),
    THEME_BLUE(R.string.blue_theme, R.drawable.ic_blue_theme, R.style.Theme_Calculator_Blue, "blue"),
    THEME_LIGHT(R.string.light_theme, R.drawable.ic_light_theme, R.style.Theme_Calculator, "light"),
    THEME_DARK(R.string.dark_theme, R.drawable.ic_dark_theme, R.style.Theme_Calculator_Dark, "dark");

    @StringRes
    private final int title;
    @DrawableRes
    private final int img;
    @StyleRes
    private final int theme;

    private final String key;

    Theme(int title, int img, int theme, String key) {
        this.title = title;
        this.img = img;
        this.theme = theme;
        this.key = key;
    }

    public int getTheme() {
        return theme;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }
}


