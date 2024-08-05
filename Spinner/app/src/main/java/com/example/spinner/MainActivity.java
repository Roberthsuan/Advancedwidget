package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    }
    public void buttonClick(View view){
        Spinner spinner=(Spinner) findViewById(R.id.spinner);

        String[] fruit=getResources().getStringArray(R.array.fruit);
        int index = spinner.getSelectedItemPosition();

        TextView result =(TextView) findViewById(R.id.tv_result);
        result.setText("您選的是"+fruit[index]);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] fruit=getResources().getStringArray(R.array.fruit);

        TextView result =(TextView) findViewById(R.id.tv_result);
        result.setText("您選的是"+fruit[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}