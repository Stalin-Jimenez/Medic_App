package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextInputEditText Ncedula;
    private TextInputEditText Correo;
    private TextInputEditText Clave;

    RequestQueue requestQueue;
    private static final String URL = "http://10.99.9.8/prueba/Register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.Nombres = findViewById(R.id.TxtNombres);
        this.Apellidos = findViewById(R.id.TxtApellidos);
        this.Usuario = findViewById(R.id.TxtUsuario);
        this.Ncedula = findViewById(R.id.TxtNcedula);
        this.Correo = findViewById(R.id.TxtCorreo);
        this.Clave = findViewById(R.id.TxtClave);

        requestQueue = Volley.newRequestQueue(this);

    }

    public void Registrar(View view) {

        String nombres = Nombres.getText().toString().trim();
        String apellidos = Apellidos.getText().toString().trim();
        String usuario = Usuario.getText().toString().trim();
        String ncedula = Ncedula.getText().toString().trim();
        String correo = Correo.getText().toString().trim();
        String clave = Clave.getText().toString().trim();

        CrearUsuario(nombres, apellidos, usuario, ncedula, correo, clave);

        if (view.getId() == R.id.Btn_registrar) {


        }


    }

    private void CrearUsuario(final String nombres, final String apellidos, final String usuario, final String ncedula, final String correo, final String clave) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Register.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombres", nombres);
                params.put("apellidos", apellidos);
                params.put("usuario", usuario);
                params.put("ncedula", ncedula);
                params.put("correo", correo);
                params.put("clave", clave);
                return params;
            }
        };

        requestQueue.add(stringRequest);

    }

}