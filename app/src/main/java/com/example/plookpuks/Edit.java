package com.example.plookpuks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.plookpuks.Model.Farm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Edit extends AppCompatActivity {

    private Button  choose;
    private Activity root;

    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayList<Farm> farms = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        choose = (Button ) findViewById(R.id.buttonFarm);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FarmsAdapter adapter = new FarmsAdapter(farms);
        recyclerView.setAdapter(adapter);



        // myListView = (ListView) findViewById(R.id.);
//        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item);
//
//        choose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClickFarm();
//            }
//        });
        click();
    }

    void ClickFarm() {

        Intent edit = new Intent(Edit.this, Main_Edit.class);
        startActivity(edit);
    }
/*
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    testapp = database.getReference();
    testapp.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });*/

   // Map map = (Map)dataSnapshot.getValue();
   // String username = String.valueOf(map.get("username"));
    //   // choose.setText(username);
    //
    //
    //
    //   // Map map = (Map) dataSnapshot.child("farms").getValue();
    //    //String ms = String.valueOf(map.get("1"));


  void click() {

      db.collection("farms")
              .get()
              .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                  @Override
                  public void onComplete(@NonNull Task<QuerySnapshot> task) {
                      if (task.isSuccessful()) {
                          for (QueryDocumentSnapshot document : task.getResult()) {
                              Farm farm = document.toObject(Farm.class);
                              farms.add(farm);

                              FarmsAdapter adapter = new FarmsAdapter(farms);
                              recyclerView.setAdapter(adapter);

                              //System.out.println("sasas");
                           //   for (int i = 0; i < myArrList.size(); i++) {

                           //   }
                          }
                      } else {

                      }
                  }
              });


               /* .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(choose, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(choose, "Error getting documents.", task.getException());
                        }
                    }
                });
    }*/

  }



}

