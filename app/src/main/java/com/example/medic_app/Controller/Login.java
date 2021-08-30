package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.medic_app.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private TextInputEditText correo;
    private TextInputEditText clave;

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.correo = findViewById(R.id.TxtCorreo_L);
        this.clave = findViewById(R.id.TxtClave_L);

        requestQueue = Volley.newRequestQueue(this);

    }


    public void Iniciar(View view) {

        if (view.getId() == R.id.BtnIniciar_L) {


            String URL = "http://192.168.1.106/prueba/Login.php?correo=" + correo.getText().toString() + "&clave=" + clave.getText().toString();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    URL,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                if (response.getString("correo").equals(correo.getText().toString()) &&
                                        response.getString("clave").equals(clave.getText().toString())) {

                                    Toast.makeText(Login.this, "Logueo Exitoso", Toast.LENGTH_SHORT).show();
                                    Intent principal = new Intent(Login.this, Principal.class);
                                    startActivity(principal);

                                } else {
                                    Toast.makeText(Login.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                System.out.println(e);
                            }

                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(Login.this, "Error En la Conexion", Toast.LENGTH_SHORT).show();

                        }
                    }

            );

            requestQueue.add(jsonObjectRequest);

        }

    }

    public void Resgistrar(View view) {
        Intent registrar = new Intent(Login.this, Register.class);
        startActivity(registrar);
    }
}