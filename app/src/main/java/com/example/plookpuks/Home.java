package com.example.plookpuks;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {


    private ImageView edit;
    private FirebaseAuth homeAuth;
    private ImageView make;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        make = (ImageView) findViewById(R.id.make);
        edit = (ImageView) findViewById(R.id.edit);

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMake();
            }
        });
        edit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                ClickEdit();
            }
        });

    }



        void ClickEdit ()
        {

            Intent edit = new Intent(Home.this,Edit.class);
            startActivity(edit);
        }


    void ClickMake() {

        Intent make = new Intent(Home.this, Make.class);
        startActivity(make);
    }

    public void ClickLogout(View view) {

        homeAuth.signOut();
        Toast.makeText(this, "Logout succsec.",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Home.this,MainActivity.class);
        startActivity(intent);

        finish();
    }

    @Override
    public void onClick(View view) {
        ClickLogout(view);
    }
}