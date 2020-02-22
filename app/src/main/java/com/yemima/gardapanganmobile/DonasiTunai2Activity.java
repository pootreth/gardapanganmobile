package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonasiTunai2Activity extends AppCompatActivity {
    private View animate;
    private View finishdonasi;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_tunai2);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_donasi_tunai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        animate=findViewById(R.id.transferbankdetail);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunai2Activity.this, DonasiTunai1Activity.class);
                startActivity(pindahmain);
                finish();
            }
        });

        finishdonasi=findViewById(R.id.finishbutton);
        finishdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunai2Activity.this, DonasiTunai4Activity.class);
                startActivity(pindahmain);
                finish();
            }
        });
    }
}
