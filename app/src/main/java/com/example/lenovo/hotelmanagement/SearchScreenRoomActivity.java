package com.example.lenovo.hotelmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchScreenRoomActivity extends AppCompatActivity {
    Button value,price,star,all,two,three,four,allCustomer,seventy,eighty,nighty,search,distance;
    int list[];
    List<Integer> finalList;
    List <String> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen_room);

        finalList = new ArrayList<>();
        roomList = new ArrayList<>();
         final int lowToHigh[] = {103,201,204,302,305,102,105,203,301,304,101,104,202,205,303};
         final int HighToLow[] = {303,205,202,104,101,304,301,203,105,102,305,302,204,201,103};
         final int valueLowToHigh[] ={101,102,103,104,105,201,202,203,204,205,301,302,303,304,305};
         final int valueHighToLow[] = {305,304,303,302,301,205,204,203,202,201,105,104,103,102,101};
         value = findViewById(R.id.value);
        price = findViewById(R.id.price);
        star = findViewById(R.id.star);
        all = findViewById(R.id.all);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        search = findViewById(R.id.search);
        allCustomer = findViewById(R.id.allCustomer);
        seventy = findViewById(R.id.seventy);
        eighty = findViewById(R.id.eighty);
        nighty = findViewById(R.id.nighty);
        distance = findViewById(R.id.distance);
        sortBy();
        customerRating();
        starRating();

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = HighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(HighToLow[i]);
                }
                sortBy();
                price.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = valueHighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(valueHighToLow[i]);
                }
                sortBy();
                value.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 2) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                starRating();
                two.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 3) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                starRating();
                three.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 4 || valueLowToHigh[i]%10 == 1) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                starRating();
                four.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        seventy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 2) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                customerRating();
                seventy.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        nighty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 1 && valueLowToHigh[i]%10 == 4) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                customerRating();
                nighty.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });
        eighty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = lowToHigh;
                List<Integer> twoStar =  new ArrayList<Integer>();
                for(int i =0; i < valueLowToHigh.length ;i++) {
                    if(valueLowToHigh[i]%10 == 3) {
                        twoStar.add(valueLowToHigh[i]);
                    }
                }
                finalList = twoStar;
                customerRating();
                eighty.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = HighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(HighToLow[i]);
                }
                starRating();
                all.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });

        allCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = HighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(HighToLow[i]);
                }
                customerRating();
                allCustomer.setBackgroundColor(Color.parseColor("#2572e6"));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<finalList.size();i++)
                {
                    roomList.add("Room Number" + " " + finalList.get(i));
                }
                Intent it = new Intent(getApplicationContext(),AssignRoomActivity.class);
                it.putIntegerArrayListExtra("test", (ArrayList<Integer>) finalList);
                it.putStringArrayListExtra("room", (ArrayList<String>) roomList);
                startActivity(it);
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = HighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(HighToLow[i]);
                }
                sortBy();
                star.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });
        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalList.clear();
                list = HighToLow;
                for (int i=0 ;i<valueHighToLow.length;i++)
                {
                    finalList.add(HighToLow[i]);
                }
                sortBy();
                distance.setBackgroundColor(Color.parseColor("#2572e6"));

            }
        });

    }
    public void sortBy()
    {
        price.setBackgroundColor(Color.WHITE);
        star.setBackgroundColor(Color.WHITE);
        value.setBackgroundColor(Color.WHITE);
        distance.setBackgroundColor(Color.WHITE);
    }
    public void starRating()
    {
        all.setBackgroundColor(Color.WHITE);
        two.setBackgroundColor(Color.WHITE);
        three.setBackgroundColor(Color.WHITE);
        four.setBackgroundColor(Color.WHITE);
    }
    public void customerRating()
    {
        allCustomer.setBackgroundColor(Color.WHITE);
        seventy.setBackgroundColor(Color.WHITE);
        eighty.setBackgroundColor(Color.WHITE);
        nighty.setBackgroundColor(Color.WHITE);
    }
}
