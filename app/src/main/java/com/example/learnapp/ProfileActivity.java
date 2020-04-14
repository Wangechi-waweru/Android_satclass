package com.example.learnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    TextView tvUsername,tvEmail,tvPassword;
    String username, email, password,country,county,profession;
    EditText edcountry,edcounty,edprofession;
    Button btnSave, btnBack;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnGoBack);


        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvEmail);
        tvPassword= findViewById(R.id.tvPassword);

//        grab data from the MainActivity

        username = getIntent().getExtras().getString("username");
        email = getIntent().getExtras().getString("email");
        password = getIntent().getExtras().getString("password");

        tvUsername.setText(username);
        tvEmail.setText(email);
        tvPassword.setText(password);

//        grab data from the ProfileActivity
        edcountry = findViewById(R.id.edCountry);
        edcounty = findViewById(R.id.edCounty);
        edprofession = findViewById(R.id.edProf);

//        saving
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(go);
                finish();
            }
        });

//        save to db
//        START BY CREATING A DATABSE AND THE TABLES
//        Db name = DemoDB
//        table name = users
//        table column names : username, email,country, county,profession,password
        db = openOrCreateDatabase("DemoDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (username VARCHAR, email VARCHAR, country VARCHAR,county VARCHAR,profession VARCHAR,password VARCHAR)");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(ProfileActivity.this, MyAccount.class);
                country = edcounty.getText().toString().trim();
                county = edcounty.getText().toString().trim();
                profession = edcounty.getText().toString().trim();

//
                if(country.isEmpty()){
                    edcountry.setError("Please fill in country");
                }else if(county.isEmpty()){
                    edcounty.setError("please fill in county");
                }else if(profession.isEmpty()){
                    edprofession.setError("Please fill in profession");
                }else{
//
//                    save data into the DemoDb
                    db.execSQL("INSERT INTO users  VALUES ('"+username+"', '"+email+"','"+country+"','"+county+"', '"+profession+"','"+password+"')");
                    Toast.makeText(ProfileActivity.this, "Data saved successfuly", Toast.LENGTH_SHORT).show();

                    go.putExtra("username",username);
                    go.putExtra("email",email);
                    go.putExtra("country",country);
                    go.putExtra("county",county);
                    go.putExtra("profession",profession);

                    startActivity(go);
                    finish();
                }

            }
        });






    }
}
