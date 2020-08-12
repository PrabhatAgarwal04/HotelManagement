package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckInActivity extends AppCompatActivity {
 Button checkIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        checkIn = (Button)findViewById(R.id.checkInButton);
        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),SearchScreenRoomActivity.class);
                startActivity(it);
            }
        });
    }
}
