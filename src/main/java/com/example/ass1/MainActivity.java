package com.example.ass1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SeekBar seekBarFontSize;
    private Spinner spinnerFontFamily;
    private Button btnColorRed, btnColorGreen, btnColorBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textView = findViewById(R.id.textView);
        seekBarFontSize = findViewById(R.id.seekBarFontSize);
        spinnerFontFamily = findViewById(R.id.spinnerFontFamily);
        btnColorRed = findViewById(R.id.btnColorRed);
        btnColorGreen = findViewById(R.id.btnColorGreen);
        btnColorBlue = findViewById(R.id.btnColorBlue);

        // Font Size Adjustment with SeekBar
        seekBarFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Set the text size dynamically
                textView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Color Change (Red, Green, Blue)
        btnColorRed.setOnClickListener(v -> textView.setTextColor(Color.RED));
        btnColorGreen.setOnClickListener(v -> textView.setTextColor(Color.GREEN));
        btnColorBlue.setOnClickListener(v -> textView.setTextColor(Color.BLUE));

        // Font Family Change via Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.font_families, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFontFamily.setAdapter(adapter);

        spinnerFontFamily.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedFontFamily = parentView.getItemAtPosition(position).toString();
                textView.setTypeface(android.graphics.Typeface.create(selectedFontFamily, android.graphics.Typeface.NORMAL));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });
    }
}
