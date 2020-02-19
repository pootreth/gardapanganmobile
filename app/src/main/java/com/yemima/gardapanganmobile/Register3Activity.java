package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register3Activity extends AppCompatActivity {
    private Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //copas
        Bundle bundle=getIntent().getExtras();
        final String namadepan=bundle.getString("namadepan");
        final String namabelakang=bundle.getString("namabelakang");
        final String nomorwa=bundle.getString("nomorwa");
        final String pekerjaan=bundle.getString("pekerjaan");
        final String umur=bundle.getString("umur");
        //ilangin header
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_register3);

        lanjut=findViewById(R.id.lanjut);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(Register3Activity.this, RegisterEndActivity.class);
                //copas
                pindahmain.putExtra("namadepan", namadepan);
                pindahmain.putExtra("namabelakang",namabelakang);
                pindahmain.putExtra("nomorwa", nomorwa);
                pindahmain.putExtra("umur",umur);
                pindahmain.putExtra("pekerjaan",pekerjaan);
                startActivity(pindahmain);
            }

        });

    }

}
