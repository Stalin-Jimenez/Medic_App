package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.medic_app.R;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity{

    private TextInputEditText Nombres;
    private TextInputEditText Apellidos;
    private TextInputEditText Usuario;
    private TextInputEditText Ncedula;
    private TextInputEditText Correo;
    private TextInputEditText Calve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.Nombres=findViewById(R.id.TxtNombres);
        this.Apellidos=findViewById(R.id.TxtApellidos);
        this.Usuario=findViewById(R.id.TxtUsuario);
        this.Ncedula=findViewById(R.id.TxtNcedula);
        this.Correo=findViewById(R.id.TxtCorreo);
        this.Calve=findViewById(R.id.TxtClave);

    }

    public void Registrar(View view) {

    }

}