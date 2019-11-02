package com.example.rumusbalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt_height,edt_length,edt_width;
    Button btn_calculate;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_height = findViewById(R.id.edt_height);
        edt_length = findViewById(R.id.edt_length);
        edt_width = findViewById(R.id.edt_width);
        btn_calculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btn_calculate.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//
//    }
}
