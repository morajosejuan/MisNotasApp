package com.zzc.misnotasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotayCursoActivity extends AppCompatActivity {
    //Declaración de variables
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notay_curso);
        inicializarBD();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_notasycursos,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void inicializarBD(){
        //LLamado de la bd
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        Toast.makeText(this, "Inizializando BD", Toast.LENGTH_SHORT).show();
    }
}