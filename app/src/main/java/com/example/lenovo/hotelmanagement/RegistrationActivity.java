package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
 EditText userName;
    EditText password;
    EditText phone;
    EditText confirmPassword;
    Button register;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new DatabaseHelper(this);
        userName = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        phone = findViewById(R.id.phone);
//        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        register = (Button) findViewById(R.id.create);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               db.addUser(userName.getText().toString(),password.getText().toString(),phone.getText().toString());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
