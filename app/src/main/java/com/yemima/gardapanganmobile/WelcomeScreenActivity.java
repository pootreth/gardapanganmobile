package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreenActivity extends AppCompatActivity {
    private View animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}

        animate=findViewById(R.id.tap);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(WelcomeScreenActivity.this, LoginActivity.class);
                startActivity(pindahmain);
            }
        });
    }
}
