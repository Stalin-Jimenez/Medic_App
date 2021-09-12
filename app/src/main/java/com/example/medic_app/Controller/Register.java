package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medic_app.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private TextInputEditText Nombres;
    private TextInputEditText Apellidos;
    private TextInputEditText Usuario;
    private TextInputEditText Edad;
    private TextInputEditText Altura;
    private TextInputEditText Peso;
    private TextInputEditText Ncedula;
    private TextInputEditText Correo;
    private TextInputEditText Clave;

    RequestQueue requestQueue;
    private static final String URL = "http://192.168.31.54/Proyecto_PIS/Register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.Nombres = findViewById(R.id.TxtNombres);
        this.Apellidos = findViewById(R.id.TxtApellidos);
        this.Usuario = findViewById(R.id.TxtUsuario);
        this.Edad = findViewById(R.id.TxtEdad);
        this.Altura = findViewById(R.id.TxtAltura);
        this.Peso = findViewById(R.id.TxtPeso);
        this.Ncedula = findViewById(R.id.TxtNcedula);
        this.Correo = findViewById(R.id.TxtCorreo);
        this.Clave = findViewById(R.id.TxtClave);

        requestQueue = Volley.newRequestQueue(this);

    }

    public void Registrar(View view) {

        if (view.getId() == R.id.Btn_registrar) {

            String nombres = Nombres.getText().toString().trim();
            String apellidos = Apellidos.getText().toString().trim();
            String usuario = Usuario.getText().toString().trim();
            String edad = Edad.getText().toString().trim();
            String altura = Altura.getText().toString().trim();
            String peso = Peso.getText().toString().trim();
            String ncedula = Ncedula.getText().toString().trim();
            String correo = Correo.getText().toString().trim();
            String clave = Clave.getText().toString().trim();

            CrearUsuario(nombres, apellidos, usuario, edad, altura, peso, ncedula, correo, clave);


        }


    }

    private void CrearUsuario(final String nombres, final String apellidos, final String usuario, final String edad, final String altura, final String peso, final String ncedula, final String correo, final String clave) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Register.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(Register.this, Login.class);
                        startActivity(login);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Register.this, "No se Pudo Registrar el Usuario", Toast.LENGTH_SHORT).show();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombres", nombres);
                params.put("apellidos", apellidos);
                params.put("usuario", usuario);
                params.put("edad", edad);
                params.put("altura", altura);
                params.put("peso", peso);
                params.put("ncedula", ncedula);
                params.put("correo", correo);
                params.put("clave", clave);
                return params;
            }
        };

        requestQueue.add(stringRequest);

    }

}