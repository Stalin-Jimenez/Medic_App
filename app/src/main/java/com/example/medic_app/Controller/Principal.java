package com.example.medic_app.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.medic_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Principal extends AppCompatActivity {

    Inicio inicio = new Inicio();
    Recetas recetas = new Recetas();
    CitasM citasM = new CitasM();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BottomNavigationView navigation = findViewById(R.id.Bnavegation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSalectedListener);
        loadFragment(inicio);


    }

    public String Id(){
        Bundle extras=getIntent().getExtras();
        String idusuarios=extras.getString("idusuarios");
        return idusuarios;
    }


    protected final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSalectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.firstFragment:
                    loadFragment(inicio);
                    return true;
                case R.id.seconFragment:
                    loadFragment(recetas);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(citasM);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fContainer, fragment);
        transaction.commit();
    }



    public void Notificar(View view) {


        ChanelNotificacion chanelNotificacion=new ChanelNotificacion(this);
        chanelNotificacion.createChannels();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),ChanelNotificacion.CHANNEL_SERVICE_ID)
                .setSmallIcon(R.drawable.medicamento)
                .setContentTitle("Hora de Tomar la Medicina")
                .setContentText("Que tenga Buen dia")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }

    public void EliminarN(View view) {
    }

    public void AgendarC(View view) {
        String Numero = "593982609486";
        String Mensaje = "Hola! muy buenas me gustaria reservar una cita medica";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone=" + Numero + "&text=" + Mensaje;
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }
}