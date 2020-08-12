package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoomBookActivity extends AppCompatActivity {
    TextView roomNo,rate;
    Button bookingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_book);
        roomNo = findViewById(R.id.roomNo);
        rate = findViewById(R.id.rate);
        bookingButton = findViewById(R.id.book);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("key");
            roomNo.setText(Integer.toString(value));
            //The key argument here must match that used in the other activity
        }
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),SendVerificatioCodeActivity.class);
                startActivity(it);
            }
        });
    }
}
