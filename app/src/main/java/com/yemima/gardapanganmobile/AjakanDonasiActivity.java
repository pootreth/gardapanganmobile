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
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.ajak_donasi);

        ajakdonasi=findViewById(R.id.send);
        ajakdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahrr=new Intent(AjakanDonasiActivity.this, MainGoldActivity.class);
                pindahrr.putExtra("namadepan", "0");
                pindahrr.putExtra("namabelakang","0");
                pindahrr.putExtra("nomorwa", "0");
                pindahrr.putExtra("umur","0");
                pindahrr.putExtra("pekerjaan","0");
                startActivity(pindahrr);
            }
        });
    }
}
