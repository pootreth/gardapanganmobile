package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainGoldActivity extends AppCompatActivity {
    private String namadepan;
    private String namabelakang;
    private String nomorwa;
    private String pekerjaan;
    private String umur;
    private ImageView mulaidonasi1;
    private ImageView mulaidonasi2;
    private ImageView mulaidonasi3;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //copas
        Bundle bundle=getIntent().getExtras();
        namadepan=bundle.getString("namadepan");
        namabelakang=bundle.getString("namabelakang");
        nomorwa=bundle.getString("nomorwa");
        pekerjaan=bundle.getString("pekerjaan");
        umur=bundle.getString("umur");

        setContentView(R.layout.activity_main_gold);
        Toolbar toolbar = findViewById(R.id.toolbargold);
        setSupportActionBar(toolbar);

        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent request =  new Intent(MainGoldActivity.this, RequestPenjemputanActivity.class);
                startActivity(request);
            }
        });

        mulaidonasi1=findViewById(R.id.buttonmulai1);
        mulaidonasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainGoldActivity.this, DonasiMakananActivity.class);
                startActivity(donasi);
            }
        });

        mulaidonasi2=findViewById(R.id.buttonmulai2);
        mulaidonasi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainGoldActivity.this, DonasiTunaiActivity.class);
                startActivity(donasi);
            }
        });

        mulaidonasi3=findViewById(R.id.buttonmulai3);
        mulaidonasi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainGoldActivity.this, UsulPenerimaActivity.class);
                startActivity(donasi);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent pindahmain= new Intent(MainGoldActivity.this, ProfileActivity.class);
            pindahmain.putExtra("namadepan", namadepan);
            pindahmain.putExtra("namabelakang",namabelakang);
            pindahmain.putExtra("nomorwa", nomorwa);
            pindahmain.putExtra("umur",umur);
            pindahmain.putExtra("pekerjaan",pekerjaan);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_badges){
            Intent pindahmain= new Intent(MainGoldActivity.this, BadgesPagesActivity.class);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_sop){
            Intent pindahmain= new Intent(MainGoldActivity.this, SOPActivity.class);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_keluar){
            Intent pindahmain = new Intent(MainGoldActivity.this, LoginActivity.class);
            startActivity(pindahmain);
        }

        return super.onOptionsItemSelected(item);
    }

    //route ke event
    public void event1(View view){
        Intent event1 =  new Intent(MainGoldActivity.this, EventGold1Activity.class);
        startActivity(event1);
    }

    public void event2(View view){
        Intent event2 =  new Intent(MainGoldActivity.this, EventGold2Activity.class);
        startActivity(event2);
    }

    public void event3(View view){
        Intent event3 =  new Intent(MainGoldActivity.this, EventGold3Activity.class);
        startActivity(event3);
    }
    //route ke request penjemputan
    public void request(View view){
        Intent request =  new Intent(MainGoldActivity.this, RequestPenjemputanActivity.class);
        startActivity(request);
    }
}
