package com.example.weearthapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    EditText title;
    EditText location;
    EditText desc;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        title = findViewById(R.id.etTitle);
        location = findViewById(R.id.etLocation);
        desc = findViewById(R.id.etDesc);
        addEvent = findViewById(R.id.btnAdd);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !desc.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, desc.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                    if (intent.resolveActivity(getPackageManager()) !=null) {
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(CalendarActivity.this,"There is no app that can support this action",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CalendarActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
                }
            }

        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_diary:
                                Intent intentDiary = new Intent(CalendarActivity.this, DiaryActivity.class);
                                startActivity(intentDiary);
                                break;
                            case R.id.action_location:
                                Intent intentLocation = new Intent(CalendarActivity.this, MapsActivity.class);
                                startActivity(intentLocation);
                                break;
                            case R.id.action_home:
                                Intent intentHome = new Intent(CalendarActivity.this, HomeActivity.class);
                                startActivity(intentHome);
                                break;
                            case R.id.action_calendar:
                                Intent intentCalendar = new Intent(CalendarActivity.this, CalendarActivity.class);
                                startActivity(intentCalendar);
                                break;
                            case R.id.action_profile:
                                Intent intentProfile = new Intent(CalendarActivity.this, ProfileActivity.class);
                                startActivity(intentProfile);
                                break;
                        }
                        return true;
                    }
                });
    }
}
