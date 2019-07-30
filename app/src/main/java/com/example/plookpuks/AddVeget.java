package com.example.plookpuks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AddVeget extends AppCompatActivity {

    private Button acept;
    private String add;
    private EditText nameMake;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseDatabase database;
    private FirebaseAuth firebaseAuth;
    private String[] items;
    private ArrayList<String> listItem;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private ListView editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_vegetable);

        acept = (Button) findViewById(R.id.aceptbutton);
        nameMake = (EditText) findViewById(R.id.editMake);
//        listView = (ListView) findViewById(R.id.listview);
       /* list();
        nameMake.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(s.toString().equals("")){

                    list();
                }
                else{
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        public void searchItem(String textToSearch)
        {
            for(String item:items)
            {
                if(!item.contains(textTosearch))
                {
                    l
                }

            }
        }

        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAcept();
            }
        });
    }

    public  void list()
    {
        items=new String[]
                {
                        "พรืก","แตงกวา","หัวหอม","ข้าวโพด","มะเขือเทศ","ผักกาดขาว","กระเพรา"
                };
        listItem= new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this, R.layout.listitems,R.id.listview,listItem);
        listView.setAdapter(adapter);
    }


    void ClickAcept ()
    {

        Intent acept = new Intent(AddVeget.this,Main_Edit.class);
        startActivity(acept);
    }

    /*
    // Create a new user with a first and last name
Map<String, Object> user = new HashMap<>();
user.put("first", "Ada");
user.put("last", "Lovelace");
user.put("born", 1815);

// Add a new document with a generated ID
db.collection("users")
        .add(user)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });*/
    }
}

