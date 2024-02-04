package com.example.temperatureconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import com.example.temperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText fahrenheit_edit;
    EditText celsius_edit;

    float fahrenheit;
    float celsius;


    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        fahrenheit_edit = binding.fahrenheitEdit;
        celsius_edit = binding.celsiusEdit;

        binding.convertBtn.setOnClickListener(v -> {
            convert_temp();
        });
    }

    public void convert_temp() {
        fahrenheit = 0.0F;
        celsius = 0.0F;
        try {
            if (!fahrenheit_edit.getText().toString().isEmpty()) {
                fahrenheit = Float.parseFloat(fahrenheit_edit.getText().toString());

                celsius = ((fahrenheit - 32) * 5) / 9;
                celsius_edit.setText(String.format("%.2f", celsius));

            } else if (!celsius_edit.getText().toString().isEmpty()) {
                celsius = Float.parseFloat(celsius_edit.getText().toString());

                fahrenheit = ((celsius * 9) / 5) + 32;
                fahrenheit_edit.setText(String.format("%.2f", fahrenheit));
            }
        } catch (Exception e) {}
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("fahrenheit", String.valueOf(fahrenheit));
        outState.putString("celsius", String.valueOf(celsius));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fahrenheit_edit.setText(savedInstanceState.getString("fahrenheit"));
        celsius_edit.setText(savedInstanceState.getString("celsius"));

    }
}