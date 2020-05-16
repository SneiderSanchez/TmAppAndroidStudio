package com.example.taller2tercercorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateAlarmActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Station Spinner props
        Spinner stationSpinner = findViewById(R.id.stationSpinner);
        ArrayAdapter<CharSequence> stationAdapter = ArrayAdapter.createFromResource(this,
                R.array.station, android.R.layout.simple_spinner_item);
        stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stationSpinner.setAdapter(stationAdapter);
        stationSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //Wagon Spinner props
        Spinner wagonSpinner = findViewById(R.id.wagonSpinner);
        ArrayAdapter<CharSequence> wagonAdapter = ArrayAdapter.createFromResource(this,
                R.array.wagon, android.R.layout.simple_spinner_item);
        wagonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wagonSpinner.setAdapter(wagonAdapter);
        wagonSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        button = findViewById(R.id.toAlarmCreated);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAlarmActivity.this,AlarmCreated.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
