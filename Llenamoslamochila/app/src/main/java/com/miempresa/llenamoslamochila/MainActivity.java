package com.miempresa.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkBoxGorras, chkBoxBañadores, chkBoxCamisetas, chkBoxZapatos, chkBoxPantalones, chkBoxLibros;
    private TextView txtPeso;
    private Button btnVaciarMochila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos las variables
        chkBoxGorras = findViewById(R.id.chkBoxGorras);
        chkBoxBañadores = findViewById(R.id.chkBoxBañadores);
        chkBoxCamisetas = findViewById(R.id.chkBoxCamisetas);
        chkBoxZapatos = findViewById(R.id.chkBoxZapatos);
        chkBoxPantalones = findViewById(R.id.chkBoxPantalones);
        chkBoxLibros = findViewById(R.id.chkBoxLibros);
        txtPeso = findViewById(R.id.txtPeso);
        btnVaciarMochila = findViewById(R.id.btnVaciarMochila);

        // Configuramos los eventos lambda para los botones
        chkBoxGorras.setOnClickListener(v -> añadirMochila(chkBoxGorras.isChecked()));
        chkBoxCamisetas.setOnClickListener(v -> añadirMochila(chkBoxCamisetas.isChecked()));
        chkBoxBañadores.setOnClickListener(v -> añadirMochila(chkBoxBañadores.isChecked()));
        chkBoxZapatos.setOnClickListener(v -> añadirMochila(chkBoxZapatos.isChecked()));
        chkBoxPantalones.setOnClickListener(v -> añadirMochila(chkBoxPantalones.isChecked()));
        chkBoxLibros.setOnClickListener(v -> añadirMochila(chkBoxLibros.isChecked()));
        btnVaciarMochila.setOnClickListener(v -> { vaciarMochila(); });

        }

    private void vaciarMochila() {
        txtPeso.setText("Peso: 0 kg");
        chkBoxGorras.setChecked(false);
        chkBoxBañadores.setChecked(false);
        chkBoxCamisetas.setChecked(false);
        chkBoxZapatos.setChecked(false);
        chkBoxPantalones.setChecked(false);
        chkBoxLibros.setChecked(false);
        txtPeso.setTextColor(Color.BLACK);
    }

    private void añadirMochila(boolean isChecked) {
        int peso = 0;
        if (chkBoxGorras.isChecked()) {
            peso += 3;
        }
        if(chkBoxBañadores.isChecked()) {
            peso += 6;
            }
        if(chkBoxCamisetas.isChecked()) {
            peso += 6;
        }
        if(chkBoxZapatos.isChecked()) {
            peso += 8;
            }
        if(chkBoxPantalones.isChecked()) {
            peso += 5;
        }
        if(chkBoxLibros.isChecked()) {
            peso += 12;
        }
        txtPeso.setText("Peso: " + peso + " kg");

        // Cambiar color texto según el peso
        if (peso > 20) {
            txtPeso.setTextColor(Color.RED);
        } else {
            txtPeso.setTextColor(Color.BLACK);
        }
    }
}