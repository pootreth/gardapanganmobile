package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DonasiMakananActivity extends AppCompatActivity {
    private ImageView mulai1;
    private ImageView mulai2;
    private ImageView mulai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_donasi_makanan);

        mulai1=findViewById(R.id.mulai1);
        mulai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(DonasiMakananActivity.this, DonasiIndividuActivity.class);
                startActivity(donasi);
            }
        });

        mulai2=findViewById(R.id.mulai2);
        mulai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(DonasiMakananActivity.this, DonasiRestoranActivity.class);
                startActivity(donasi);
            }
        });

        mulai3=findViewById(R.id.mulai3);
        mulai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(DonasiMakananActivity.this, DonasiEventActivity.class);
                startActivity(donasi);
            }
        });

    }
}
