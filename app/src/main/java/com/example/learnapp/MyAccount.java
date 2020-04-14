package com.example.learnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity {
    TextView tvusername, tvemail, tvcountry, tvcounty, tvprofession, tvpassword;
    String username, email, country, county, profession , password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);


        tvusername = findViewById(R.id.tvUsername);
        tvemail = findViewById(R.id.tvUserEmail);
        tvcountry = findViewById(R.id.tvUserCountry);
        tvcounty = findViewById(R.id.tvUserCounty);
        tvprofession = findViewById(R.id.tvUserProfession);

//        grab data from the ProfileActivity

        username = getIntent().getExtras().getString("username");
        email = getIntent().getExtras().getString("email");
        country = getIntent().getExtras().getString("country");
        county = getIntent().getExtras().getString("county");
        profession = getIntent().getExtras().getString("profession");

//        Set the data to the TextViews
        tvusername.setText(username);
        tvemail.setText(email);
        tvcountry.setText(country);
        tvcounty.setText(county);
        tvprofession.setText(profession);
    }
}
