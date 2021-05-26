package com.android1.hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private CheckBox checkBox;
    private SwitchCompat switchCompat;
    private ToggleButton toggleButton;
    public String value;
    public String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.edit_text);

        switchCompat = findViewById(R.id.switch_compact);

        checkBox = findViewById(R.id.check_box);

        toggleButton = findViewById(R.id.toggle_button);

        Button button = findViewById(R.id.button);

        Button nextButton = findViewById(R.id.button_next);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationFormActivity.class));
                
            }
        });
    }

    public void showResult() {
        value = editText.getText().toString();
        if (checkBox.isChecked()) {
            SpannableString spannableString = new SpannableString(value);
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            textView.setText(spannableString);
        } else {
            textView.setText(value);
        }
        if (toggleButton.isChecked()) {
            textView.setAllCaps(true);
        } else {
            textView.setAllCaps(false);
        }
        if (switchCompat.isChecked()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            textView.setTypeface(Typeface.DEFAULT);
        }


    }

}