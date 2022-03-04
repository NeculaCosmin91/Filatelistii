package com.example.filatelistii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup, signin;
    DBHelp DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = findViewById(R.id.btnsignup);
        signin = findViewById(R.id.btnsignin);
        DB = new DBHelp(this);

        signup.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(Register.this, "Completati toate datele", Toast.LENGTH_SHORT).show();
            else{
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checkusername(user);
                    if(!checkuser){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert){
                            Toast.makeText(Register.this, "Inregistrare cu succes", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this, "Eroare la Inregistrare", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "Utilizatorul exista deja!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Parola nu se potriveste", Toast.LENGTH_SHORT).show();
                }
            } });

        signin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        });
    }
}
