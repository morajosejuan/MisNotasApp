package com.zzc.misnotasapp;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
import com.zzc.misnotasapp.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteActivity extends AppCompatActivity {
    //Declaración de variables
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText documento;
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText telefono;
    private ListView listaview_estudiante;

    private final List<Estudiante> listEstudiante = new ArrayList<>();
    ArrayAdapter<Estudiante> arrayAdapterEstudiante;
    Estudiante estudianteselecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);
        documento = (EditText) findViewById(R.id.txtDocumento);
        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        direccion = (EditText) findViewById(R.id.txtDireccion);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        listaview_estudiante = (ListView) findViewById(R.id.lvdatosEstudiantes);
        inicializarBD();
        listaview_estudiante.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                estudianteselecionado = (Estudiante) parent.getItemAtPosition(position);
                documento.setText(estudianteselecionado.getDocumento());
                nombre.setText(estudianteselecionado.getNombre());
                apellido.setText(estudianteselecionado.getApellido());
                direccion.setText(estudianteselecionado.getDireccion());
                telefono.setText(estudianteselecionado.getTelefono());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_estudiante,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void inicializarBD(){
        //LLamado de la bd
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        Toast.makeText(this, "Inizializando BD", Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {

        String varDocumento = documento.getText().toString();
        String varNombre = nombre.getText().toString();
        String varApellido = apellido.getText().toString();
        String varDireccion = direccion.getText().toString();
        String varTelefono = telefono.getText().toString();

        /*Integer varTelefono = Integer.parseInt(telefono.getText().toString());*/
        switch (item.getItemId()) {
            case R.id.icono_guardar:
                if (varNombre.isEmpty() || varApellido.isEmpty() || varDireccion.isEmpty() || varTelefono.isEmpty()) {
                    validacion();
                } else {
                    Estudiante objEstudiante = new Estudiante();
                    objEstudiante.setDocumento(varDocumento);
                    objEstudiante.setNombre(varNombre);
                    objEstudiante.setApellido(varApellido);
                    objEstudiante.setDireccion(varDireccion);
                    objEstudiante.setDireccion(varTelefono);


                    databaseReference.child("estudiante").child(objEstudiante.getApellido()).setValue(objEstudiante);
                    Toast.makeText(this, "Registro Guardado Correctamente", Toast.LENGTH_SHORT).show();
                    limpiarCajas();

                }
                break;
            case R.id.icono_ingresar:
                Toast.makeText(this, "Se presiono actualziar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icono_eliminar:
                Toast.makeText(this, "Se presiono Eliminar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icono_regresar:
                Toast.makeText(this, "Index", Toast.LENGTH_SHORT).show();
                Intent btnEstudiante = new Intent(this, MainActivity.class);
                startActivity(btnEstudiante);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void limpiarCajas() {
        documento.setText("");
        nombre.setText("");
        apellido.setText("");
        direccion.setText("");
        telefono.setText("");
    }

    public void listarDatos() {
        databaseReference.child("estudiante").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listEstudiante.clear();
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Estudiante e = objSnapshot.getValue(Estudiante.class);
                    listEstudiante.add(e);
                    arrayAdapterEstudiante = new ArrayAdapter<Estudiante>(EstudianteActivity.this, android.R.layout.simple_list_item_1,
                            listEstudiante);
                    listaview_estudiante.setAdapter(arrayAdapterEstudiante);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void validacion() {
        String varDocumento = documento.getText().toString();
        String varNombre = nombre.getText().toString();
        String varApellido = apellido.getText().toString();
        String varDireccion = direccion.getText().toString();
        String varTelefono = direccion.getText().toString();

        if (varApellido.isEmpty()) {
            apellido.setError("Requerido");
        } else if (varDocumento.isEmpty()) {
            documento.setError("Requerido");

        } else if (varNombre.isEmpty()) {
            nombre.setError("Requerido");
        } else if (varDireccion.isEmpty()) {
            direccion.setError("Requerido");
        } else {
            telefono.setError("Requerido");
        }

    }
}