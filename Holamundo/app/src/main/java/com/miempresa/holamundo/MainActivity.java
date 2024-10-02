package com.miempresa.holamundo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView lblInfo;
    EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblInfo = findViewById(R.id.lbliInfo);
        txtNombre = findViewById(R.id.txtNombre);


        // Forma recomendada
        Button btnUno = findViewById(R.id.btnUno);
        btnUno.setOnClickListener(v -> mostrarMensaje(1));

        Button btnDos = findViewById(R.id.btnDos);
        btnDos.setOnClickListener(v -> mostrarMensaje(2));

        Button btnTres = findViewById(R.id.btnTres);
        btnTres.setOnClickListener(v -> mostrarMensaje(3));
        }

    private void mostrarMensaje(int m) {
        String str = "";
        switch (m) {
            case 1:
                str = "UNO";
                break;
            case 2:
                str = txtNombre.getText().toString();
                if (str.isEmpty()) {
                    str = lblInfo.getText().toString();
                }
                break;
            case 3:
                str = "TRES";
                break;
        }
        lblInfo.setText(str);
    }
}