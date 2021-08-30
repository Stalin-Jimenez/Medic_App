package com.example.medic_app.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.medic_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

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

}