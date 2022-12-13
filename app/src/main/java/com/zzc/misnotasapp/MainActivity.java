package com.zzc.misnotasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    /* Declaración de variables */
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Llamado de las conexión*/
        inicializarBD();
    }
    public  void inicializarBD(){
    /*Llamado de la bd*/
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(this, "Inicializando BD", Toast.LENGTH_SHORT).show();
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