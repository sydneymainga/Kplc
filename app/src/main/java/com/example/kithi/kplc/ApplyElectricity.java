package com.example.kithi.kplc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplyElectricity extends AppCompatActivity {

    private Button submit;
    private DatabaseReference databaseReference;
    private EditText txtlocation,txtphone,txtname;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_electricity);
        submit=(Button)findViewById(R.id.btn_submit);
        firebaseAuth=FirebaseAuth.getInstance();
      // if(FirebaseAuth.getCurrentUser()==null){
           // finish();
            //Intent i=new Intent(getApplicationContext(),Login.class);
            //startActivity(i);

       // }
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txtlocation=(EditText)findViewById(R.id.editTextlocation);
        txtname=(EditText) findViewById(R.id.editTextname);
        txtphone=(EditText)findViewById(R.id.editTextphone) ;
        //FirebaseUser user= FirebaseAuth.getCurrentUser();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });
    }

        private void saveUserInfo(){
        String name=txtname.getText().toString().trim();
        String phone=txtphone.getText().toString().trim();
        String location=txtlocation.getText().toString().trim();

            UserInformation userInformation=new UserInformation(location,name,phone);
            //FirebaseUser user = FirebaseAuth.getCurrentUser();
           // databaseReference.child(user.getUid()).setValue(userInformation);
            Toast.makeText(ApplyElectricity.this,"information saved...",Toast.LENGTH_SHORT).show();


    }
}
