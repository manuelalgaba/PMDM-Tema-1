package com.miempresa.a3numeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nmr1, nmr2, nmr3;
    private TextView txtnmr1, txtnmr2, txtnmr3, txtresultado1, txtresultado2, txtresultado3;
    private Button btnMenor, btnMayor, btnOrdAsc, btnOrdDesc, btnBorrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las vistas
        nmr1 = findViewById(R.id.nmr1);
        nmr2 = findViewById(R.id.nmr2);
        nmr3 = findViewById(R.id.nmr3);
        txtnmr1 = findViewById(R.id.txtnmr1);
        txtnmr2 = findViewById(R.id.txtnmr2);
        txtnmr3 = findViewById(R.id.txtnmr3);
        btnMayor = findViewById(R.id.btnMayor);
        btnMenor = findViewById(R.id.btnMenor);
        btnOrdAsc = findViewById(R.id.btnOrdAsc);
        btnOrdDesc = findViewById(R.id.btnOrdDesc);
        btnBorrar = findViewById(R.id.btnBorrar);
        txtresultado1 = findViewById(R.id.txtresultado1);
        txtresultado2 = findViewById(R.id.txtresultado2);
        txtresultado3 = findViewById(R.id.txtresultado3);

        // Configuramos los eventos lambda para los botones
        btnMenor.setOnClickListener(v -> calcularMenor());
        btnMayor.setOnClickListener(v -> calcularMayor());
        btnOrdAsc.setOnClickListener(v -> ordenarAsc());
        btnOrdDesc.setOnClickListener(v -> ordenarDesc());
        btnBorrar.setOnClickListener(v -> borrarTodo());
    }

    // Primero realizamos un metodo para verificar que los campos tienen contenido
    private boolean camposVacios() {
        return nmr1.getText().toString().isEmpty() || nmr2.getText().toString().isEmpty() || nmr3.getText().toString().isEmpty();
    }

    // Método para mostrar mensaje de error
    private void mostrarError() {
        Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
    }

    // Método para calcular el menor
    private void calcularMenor() {
        if (camposVacios()) {
            mostrarError();
            return;
        } else {
            int num1 = Integer.parseInt(nmr1.getText().toString());
            int num2 = Integer.parseInt(nmr2.getText().toString());
            int num3 = Integer.parseInt(nmr3.getText().toString());

            int menor = Math.min(Math.min(num1, num2), num3);
            txtresultado2.setText(String.valueOf(menor));
            txtresultado1.setText("");
            txtresultado3.setText("");
        }
    }

    // Método para calcular el mayor
    private void calcularMayor() {
        if (camposVacios()) {
            mostrarError();
            return;
        } else {
            int num1 = Integer.parseInt(nmr1.getText().toString());
            int num2 = Integer.parseInt(nmr2.getText().toString());
            int num3 = Integer.parseInt(nmr3.getText().toString());
            int mayor = Math.max(Math.max(num1, num2), num3);
            txtresultado1.setText("");
            txtresultado2.setText(String.valueOf(mayor));
            txtresultado3.setText("");
        }
    }

    // Método para ordenar de forma ascendente
    private void ordenarAsc() {
        if (camposVacios()) {
            mostrarError();
            return;
        } else {
            int num1 = Integer.parseInt(nmr1.getText().toString());
            int num2 = Integer.parseInt(nmr2.getText().toString());
            int num3 = Integer.parseInt(nmr3.getText().toString());
            int[] numeros = {num1, num2, num3};
            java.util.Arrays.sort(numeros); // Ordenamos el array de números ascendentemente

            txtresultado1.setText(String.valueOf(numeros[0]));
            txtresultado2.setText(String.valueOf(numeros[1]));
            txtresultado3.setText(String.valueOf(numeros[2]));
        }
    }

    // Método para ordenar de forma descendente
    private void ordenarDesc() {
        if (camposVacios()) {
            mostrarError();
            return;
        } else {
            int num1 = Integer.parseInt(nmr1.getText().toString());
            int num2 = Integer.parseInt(nmr2.getText().toString());
            int num3 = Integer.parseInt(nmr3.getText().toString());
            int[] numeros = {num1, num2, num3};
            java.util.Arrays.sort(numeros);

            txtresultado1.setText(String.valueOf(numeros[2]));
            txtresultado2.setText(String.valueOf(numeros[1]));
            txtresultado3.setText(String.valueOf(numeros[0]));
        }
    }

    // Método para borrar todo
    private void borrarTodo() {
        nmr1.setText("");
        nmr2.setText("");
        nmr3.setText("");
        txtresultado1.setText("");
        txtresultado2.setText("");
        txtresultado3.setText("");
    }

}