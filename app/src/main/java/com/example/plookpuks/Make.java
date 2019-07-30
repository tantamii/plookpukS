package com.example.plookpuks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Make extends AppCompatActivity {

    private Button aceptMake;
    private EditText nameMake;
    private FirebaseDatabase database ;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String makeName;
    private FirebaseUser user;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        aceptMake = (Button) findViewById(R.id.buttonAceptMake);
        nameMake = (EditText)  findViewById(R.id.editMake);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

         user = firebaseAuth.getCurrentUser();
       // String userId = user.getUid();
        //nameMake.getText();


        //databaseReference.child(user.getUid()).child("tel").setValue("08359");

        aceptMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAcepts();
            }
        });

    }


    void ClickAcept ()
    {
        Intent make = new Intent(Make.this,Home.class);
            makeName = nameMake.getText().toString();
            databaseReference.child(user.getUid()).child("name").child("id").setValue(makeName);

                    //databaseReference.child(user.getUid()).child("name"+).setValue(makeName);

        startActivity(make);
    }

    void ClickAcepts ()
    {
        Intent make = new Intent(Make.this,Home.class);
        makeName = nameMake.getText().toString();
        Map<String, Object> farms = new HashMap<>();
        farms.put("name", makeName);


        db.collection("farms").add(farms);
        Toast.makeText(this,"สร้างฟาร์มของคุณเรียบร้อยแล้ว",Toast.LENGTH_LONG).show();

        //databaseReference.child(user.getUid()).child("name"+).setValue(makeName);

        startActivity(make);
    }



}
