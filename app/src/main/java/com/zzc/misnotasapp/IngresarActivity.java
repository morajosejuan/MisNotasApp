package com.zzc.misnotasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zzc.misnotasapp.model.Ingresar;

import java.util.ArrayList;
import java.util.List;

public class IngresarActivity extends AppCompatActivity {

    //Declaración de variables
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText usuario;
    private EditText password;
    private ListView listaview_usuario;

    private final List<Ingresar> listusuario = new ArrayList<>();
    ArrayAdapter<Ingresar> arrayAdapterEstudiante;
    Ingresar usuarioselecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        password = (EditText) findViewById(R.id.txtPassword);
        listaview_usuario = (ListView) findViewById(R.id.listvUsuario);
        inicializarBD();
        listarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ingresar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void inicializarBD(){
        //LLamado de la bd
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        Toast.makeText(this, "Inizializando BD", Toast.LENGTH_SHORT).show();
    }
    public void listarDatos() {
        databaseReference.child("ingreso").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaview_usuario.clear();
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Ingresar e = objSnapshot.getValue(Ingresar.class);
                    listusuario.add(e);
                    arrayAdapterEstudiante = new ArrayAdapter<Ingresar>(IngresarActivity.this, android.R.layout.simple_list_item_1,
                            listusuario);
                    listaview_usuario.setAdapter(arrayAdapterEstudiante);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}