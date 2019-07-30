package com.example.plookpuks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1beta1.FirestoreGrpc;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBot;
    private EditText userLogin;
    private EditText passwordLogin;
    private TextView RegisterBotton;
    private List<String> listVeget ;
    private ListView dataView;
    private MysqlConnect mysqlConnect;
    private FirebaseAuth login;
    private String emailString,passwordString;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBot = (Button) findViewById(R.id.buttonLogin);
        userLogin = (EditText) findViewById(R.id.editUserLogin);
        passwordLogin = (EditText) findViewById(R.id.editPaswordLogin);
        RegisterBotton = (TextView) findViewById(R.id.register);
        login = FirebaseAuth.getInstance();


    }




    void init()
    {

    }

    private void signIn(String email,String password)
    {
        login.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "SignInWithEmail:success",
                                    Toast.LENGTH_SHORT).show();
                              FirebaseUser user = login.getCurrentUser();
                              if(user.isEmailVerified())
                              {
                                  Intent intent = new Intent(MainActivity.this,Home.class);
                                  startActivity(intent);
                                  Toast.makeText(MainActivity.this,"ลอกอินเรียบร้อย",Toast.LENGTH_LONG).show();
                              }
                              else
                              {
                                  Toast.makeText(MainActivity.this,"โปรดยืนยันอีเมล",Toast.LENGTH_LONG).show();
                              }

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "รหัสไม่ถูกต้อง",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }




    public void ClickRegister(View view) {

        Intent make = new Intent(MainActivity.this,Regitering.class);
        startActivity(make);
        Toast.makeText(this,"Go to register.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        ClickRegister( view);
    }

    public void ClickLogin(View view)
    {
        emailString = userLogin.getText().toString();
        passwordString= passwordLogin.getText().toString();
        signIn(emailString,passwordString);
    }




}
