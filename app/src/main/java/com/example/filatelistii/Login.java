package com.example.filatelistii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    DBHelp DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnlogin = findViewById(R.id.btnsignin1);
        DB = new DBHelp(this);

        btnlogin.setOnClickListener(view -> {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("")||pass.equals(""))
                Toast.makeText(Login.this, "Introduceti toate datele", Toast.LENGTH_SHORT).show();
            else{
                Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                if(checkuserpass){
                    Toast.makeText(Login.this, "Logare cu succes", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Date invalide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}