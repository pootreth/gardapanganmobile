package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonasiTunai1Activity extends AppCompatActivity {
    private View animate;
    private View animate2;
    private View finishdonasi;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_tunai1);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_donasi_tunai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        animate=findViewById(R.id.transferbankdetail);
//        animate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pindahmain = new Intent(DonasiTunai1Activity.this, DonasiTunaiActivity.class);
//                startActivity(pindahmain);
//            }
//        });

        animate2=findViewById(R.id.online_payment);
        animate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunai1Activity.this, DonasiTunai2Activity.class);
                startActivity(pindahmain);
            }
        });

        finishdonasi=findViewById(R.id.finishbutton);
        finishdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunai1Activity.this, DonasiTunai3Activity.class);
                startActivity(pindahmain);
            }
        });
    }
}
