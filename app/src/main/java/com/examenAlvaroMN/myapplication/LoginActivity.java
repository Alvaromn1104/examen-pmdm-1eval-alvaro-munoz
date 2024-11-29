package com.examenAlvaroMN.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout nombreTIL =findViewById(R.id.registerUserTextInputLayout);
        TextInputLayout contraseñaTIL =findViewById(R.id.registerPasswordTextInputLayout);

        Button btnInicioSesio =findViewById(R.id.botonIniciarSesion);

        btnInicioSesio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = String.valueOf(nombreTIL.getEditText().getText()).trim();
                String contraseña = String.valueOf(contraseñaTIL.getEditText().getText()).trim();
                String contraValida = "examenpmdm";
                boolean isValid =true;

                if(nombre.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese un nombre de usuario o correo", Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
                if(contraseña.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
                if(isValid ) {
                    if(contraseña.equals(contraValida)) {
                        SharedPreferences sp = getSharedPreferences("nombre", MODE_PRIVATE);
                        SharedPreferences.Editor spe = sp.edit();
                        spe.putString("nombre", nombre);
                        spe.apply();
                        Toast.makeText(getApplicationContext(), "Contraseña correcta", Toast.LENGTH_SHORT).show();
                        launchMain();
                    }else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


    public void launchMain(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}