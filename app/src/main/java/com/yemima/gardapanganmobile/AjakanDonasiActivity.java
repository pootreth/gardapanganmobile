package com.yemima.gardapanganmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AjakanDonasiActivity extends AppCompatActivity{
    private View ajakdonasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajak_donasi);
        Toolbar toolbar = findViewById(R.id.toolbargold);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

        ajakdonasi=findViewById(R.id.send);
        ajakdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahrr=new Intent(AjakanDonasiActivity.this, MainGoldActivity.class);
                startActivity(pindahrr);
            }
        });
    }
}
