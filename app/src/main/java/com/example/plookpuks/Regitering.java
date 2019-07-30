package com.example.plookpuks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Regitering extends AppCompatActivity implements View.OnClickListener {

    private Button acept;
    private FirebaseAuth regit;
    private EditText password,email;
    private String emailString,passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitering);

        acept = (Button) findViewById(R.id.aceptRe);
        regit = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editEmailRe);
        password = (EditText) findViewById(R.id.PasseditText);






    }

    private void createAcount(String email,String password) {

        regit.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = regit.getCurrentUser();
                            sendEmailVerification();
                            Toast.makeText(Regitering.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            Intent Intent = new Intent(Regitering.this,MainActivity.class);
                            startActivity(Intent);

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Regitering.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View view) {
        ClickAceptRe(view);
    }

    public void ClickAceptRe(View view) {

        emailString= email.getText().toString();
        passwordString= password.getText().toString();
       createAcount(emailString,passwordString);
    }


    private void sendEmailVerification()
    {
        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = regit.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        // Re-enable button

                        Log.v( "กรุณายืนยันตัวตน", String.valueOf(user.isEmailVerified()));

                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
    }

}
