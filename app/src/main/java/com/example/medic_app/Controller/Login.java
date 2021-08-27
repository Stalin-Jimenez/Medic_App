package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.medic_app.R;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText correo;
    private TextInputEditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.correo=findViewById(R.id.TxtCorreo_L);
        this.clave=findViewById(R.id.TxtClave_L);
    }

    public void Iniciar(View view) {

    }

    public void Resgistrar(View view) {
        Intent registrar= new Intent(Login.this, Register.class);
        startActivity(registrar);
    }
}