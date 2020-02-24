package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterEndActivity extends AppCompatActivity {
    private View animate;

    @Override
    public void onBackPressed() {
    }

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
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_register_end);

        animate=findViewById(R.id.tap);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(RegisterEndActivity.this, MainActivity.class);
                //copas
                pindahmain.putExtra("namadepan", namadepan);
                pindahmain.putExtra("namabelakang",namabelakang);
                pindahmain.putExtra("nomorwa", nomorwa);
                pindahmain.putExtra("umur",umur);
                pindahmain.putExtra("pekerjaan",pekerjaan);
                pindahmain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindahmain);
            }
        });
    }
}