package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText userName;
  EditText password;
  Button login;
  Button register;
  DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
         db = new DatabaseHelper(this);

        // Will be Implemented
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Boolean isMatched = db.checkUser(userName.getText().toString(),password.getText().toString());
               if (isMatched)
               {
                  Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                  startActivity(intent);
               }
               else {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "This is a message displayed in a Toast",
                           Toast.LENGTH_SHORT);

                   toast.show();
               }

            }
        });

        // Will Be Implemented
        register.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);


            }
        }));
    }

}
