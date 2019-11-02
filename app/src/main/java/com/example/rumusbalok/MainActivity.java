package com.example.rumusbalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edt_height,edt_length,edt_width;
    private Button btn_calculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";
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

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calculate){
            String inputLength = edt_length.getText().toString().trim();
            String inputWidth  = edt_width.getText().toString().trim();
            String inputHeight = edt_height.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edt_length.setError("Inputan tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edt_height.setError("Inputan tidak boleh kosong");
            }

            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edt_width.setError("Inputan tidak boleh kosong");
            }

            Double length = toDouble(inputLength);
            Double width  = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if(length == null){
                isInvalidDouble = true;
                edt_length.setError("Inputan ini harus berupa nomor yg valid");
            }

            if(width == null){
                isInvalidDouble = true;
                edt_width.setError("Inputan ini harus berupa nomor yg valid");
            }

            if(height == null){
                isInvalidDouble = true;
                edt_height.setError("Inputan ini harus berupa nomor yg valid");
            }

            if(!isEmptyFields && !isInvalidDouble){
                double volume = height * width * length;

                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }


}
