package com.example.kithi.kplc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText txtemail;
    private EditText txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtemail=(EditText)findViewById(R.id.editTextemail);
        txtpassword=(EditText)findViewById(R.id.editTextPassword) ;
        firebaseAuth=FirebaseAuth.getInstance();

    }
    public void btnRegistrationUser_click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(Register.this,"please wait...","progressing...",true);
        (firebaseAuth.createUserWithEmailAndPassword(txtemail.getText().toString(),txtpassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "registration successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",task.getException().toString() );
                }
            }
        });

    }

    }


