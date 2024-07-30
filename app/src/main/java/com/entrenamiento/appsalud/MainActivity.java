package com.entrenamiento.appsalud;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.entrenamiento.appsalud.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    //aqui es donde estoy llamando el binding
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InicioFragment());

        binding.bottomNavigationView.setOnItemSelectedListener  (item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                replaceFragment(new InicioFragment());
            } else if (id == R.id.info) {
                replaceFragment(new InfoFragment());
            } else if (id == R.id.contact) {
                replaceFragment(new ContactoFragment());
            }
            return true;
        });

        }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

    public void AbrirCamara (){

    }
}