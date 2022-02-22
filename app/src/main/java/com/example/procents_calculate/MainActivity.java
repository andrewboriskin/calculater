package com.example.procents_calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {

    EditText ET100, ETB, ETC, ETH;
    Button BTNclear100, BTNcalculate, BTNclearBCH;
    TextView TVB, TVC, TVH;
    float all100, b, c, h, resb, resc, resh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET100 = findViewById(R.id.ET100);
        ETB = findViewById(R.id.ETB);
        ETC = findViewById(R.id.ETC);
        ETH = findViewById(R.id.ETH);
        BTNclear100 = findViewById(R.id.btnClear100);
        BTNcalculate = findViewById(R.id.btnCalculate);
        BTNclearBCH = findViewById(R.id.btnClearBCH);
        TVB = findViewById(R.id.resB);
        TVC = findViewById(R.id.resC);
        TVH = findViewById(R.id.resH);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnClear100:
                        ET100.setText(null);
                        break;
                    case R.id.btnClearBCH:
                        ETB.setText(null);
                        ETC.setText(null);
                        ETH.setText(null);
                        TVB.setText(null);
                        TVC.setText(null);
                        TVH.setText(null);
                        break;
                    case R.id.btnCalculate:

                        try {
                            all100 = Integer.parseInt(ET100.getText().toString());
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Введи количество детей", Toast.LENGTH_SHORT).show();
                            break;
                        }

                        try {
                            b = Integer.parseInt(ETB.getText().toString());
                        } catch (Exception e) {
                            b = 0;
                        }
                        try {
                            c = Integer.parseInt(ETC.getText().toString());
                        } catch (Exception e) {
                            c = 0;
                        }
                        try {
                            h = Integer.parseInt(ETH.getText().toString());
                        } catch (Exception e) {
                            h = 0;
                        }

                        if ((b + c + h) != all100) {
                            Toast.makeText(MainActivity.this, "У тебя ошибка, перепроверь", Toast.LENGTH_SHORT).show();
                            break;
                        }

                        resb = (b * 100)/all100;
                        resc = (c * 100)/all100;
                        resh = (h * 100)/all100;


                        TVB.setText(new DecimalFormat("##.##").format(resb) + "%");
                        TVC.setText(new DecimalFormat("##.##").format(resc) + "%");
                        TVH.setText(new DecimalFormat("##.##").format(resh) + "%");
                        break;
                }
            }
        };

        BTNclearBCH.setOnClickListener(onClickListener);
        BTNclear100.setOnClickListener(onClickListener);
        BTNcalculate.setOnClickListener(onClickListener);

    }
}
