package com.miempresa.mevoydeviaje;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnInformacion;
    private RadioGroup rgDestino, rgTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las vistas
        btnInformacion = findViewById(R.id.btnInformacion);
        rgDestino = findViewById(R.id.rgDestino);
        rgTransporte = findViewById(R.id.rgTransporte);

        // Configuramos los eventos lambda tanto para los RadioGroup como para el botón para realizar en un metodo a parte
        btnInformacion.setOnClickListener(v -> mostrarInformacion());
    }

    // Metodo para mostrar informacion
    private void mostrarInformacion() {
        String destino = obtenerTextoSeleccionado(rgDestino);
        String transporte = obtenerTextoSeleccionado(rgTransporte);

        Toast.makeText(this, " Me voy a " + destino + " en " + transporte, Toast.LENGTH_LONG).show();
    }

    // Metodo para obtener el texto seleccionado de un RadioGroup
    private String obtenerTextoSeleccionado(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }


}