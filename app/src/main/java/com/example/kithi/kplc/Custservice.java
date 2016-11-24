package com.example.kithi.kplc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Custservice extends AppCompatActivity {

   private Button apply,buytokens,alerts,calc,sambaza,logout;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custservice);
        apply=(Button)findViewById(R.id.btn_apply);
        buytokens=(Button)findViewById(R.id.btn_buy_tokens);
        alerts=(Button)findViewById(R.id.btn_alerts);
        calc=(Button)findViewById(R.id.btn_calc);
        sambaza=(Button)findViewById(R.id.btn_sambaza);
        logout=(Button)findViewById(R.id.btnsign_out);
        firebaseAuth=FirebaseAuth.getInstance();

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ApplyElectricity.class);
                startActivity(intent);

            }
        });
        buytokens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BuyTokens.class);
                startActivity(intent);

            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KplcAlerts.class);
                startActivity(intent);

            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TokenCalculator.class);
                startActivity(intent);

            }
        });
        sambaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sambaza.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                    finish();
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });

    }
}
