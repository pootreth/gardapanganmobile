package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonasiTunaiActivity extends AppCompatActivity {
    private View animate;
    private View animate2;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_tunai);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_donasi_tunai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        animate=findViewById(R.id.transfer);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunaiActivity.this, DonasiTunai1Activity.class);
                startActivity(pindahmain);
            }
        });

        animate2=findViewById(R.id.online_payment);
        animate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunaiActivity.this, DonasiTunai2Activity.class);
                startActivity(pindahmain);
            }
        });
    }
}
