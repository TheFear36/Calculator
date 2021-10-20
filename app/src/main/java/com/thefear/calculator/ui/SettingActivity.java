package com.thefear.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thefear.calculator.R;
import com.thefear.calculator.Storage.ThemeStorage;
import com.thefear.calculator.logic.Theme;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    public static final String ARG_THEME = "ARG_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeStorage storage = new ThemeStorage(this);

        setTheme(storage.getTheme().getTheme());

        setContentView(R.layout.activity_setting);

        Intent launchIntent = getIntent();

        Theme launchTheme = (Theme) launchIntent.getSerializableExtra(ARG_THEME);

        LinearLayout container = findViewById(R.id.theme_container);

        for (Theme theme : Theme.values()) {
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, container, false);

            ImageView img = itemView.findViewById(R.id.img);
            ImageView check = itemView.findViewById(R.id.check);
            TextView txt = itemView.findViewById(R.id.theme_txt);

            img.setImageResource(theme.getImg());

            String txtValue = getString(theme.getTitle());
            txt.setText(txtValue);

            int visibility = View.GONE;

            if (theme.equals(launchTheme)) {
                visibility = View.VISIBLE;
            }

            check.setVisibility(visibility);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent data = new Intent();
                    data.putExtra(ARG_THEME, theme);

                    setResult(Activity.RESULT_OK, data);

                    finish();
                }
            });

            container.addView(itemView);
        }
    }
}