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

public class Login extends AppCompatActivity {
    private EditText txtemail,txtpassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtemail=(EditText)findViewById(R.id.editTextemaill);
        txtpassword=(EditText)findViewById(R.id.editTextpasswordd);
        firebaseAuth =FirebaseAuth.getInstance();
    }
    public void btnLoginUser_click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(Login.this,"please wait...","processing...",true);
        ( firebaseAuth.signInWithEmailAndPassword(txtemail.getText().toString(),txtpassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "login successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Custservice.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",task.getException().toString() );
                }

            }
        });

    }
}
