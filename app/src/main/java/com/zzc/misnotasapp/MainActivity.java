package com.zzc.misnotasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ingreso(View view){
        Intent ingresar = new Intent(MainActivity.this, IngresarActivity.class);
            startActivity(ingresar);
        }

    public void nota(View view){
        Intent notasycurso = new Intent(MainActivity.this, NotayCursoActivity.class);
        startActivity(notasycurso);
    }

    public void horario(View view){
        Intent horarioytareas = new Intent(MainActivity.this, HorarioyTareasActivity.class);
        startActivity(horarioytareas);
    }

    public void estudiante(View view){
        Intent estudiantes = new Intent(MainActivity.this, EstudianteActivity.class);
        startActivity(estudiantes);
    }

    public void promedio(View view){
        Intent calcularpromedio = new Intent(MainActivity.this, CalcularPromedioActivity.class);
        startActivity(calcularpromedio);
    }

}