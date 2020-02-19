package com.yemima.gardapanganmobile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String namadepan;
    private String namabelakang;
    private String nomorwa;
    private String pekerjaan;
    private String umur;
    private ImageView mulaidonasi1;
    private ImageView mulaidonasi2;
    private ImageView mulaidonasi3;

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

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mulaidonasi1=findViewById(R.id.buttonmulai1);
        mulaidonasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainActivity.this, DonasiMakananActivity.class);
                startActivity(donasi);
            }
        });

        mulaidonasi2=findViewById(R.id.buttonmulai2);
        mulaidonasi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainActivity.this, DonasiTunaiActivity.class);
                startActivity(donasi);
            }
        });

        mulaidonasi3=findViewById(R.id.buttonmulai3);
        mulaidonasi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donasi=  new Intent(MainActivity.this, UsulPenerimaActivity.class);
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
            Intent pindahmain= new Intent(MainActivity.this, ProfileActivity.class);
            pindahmain.putExtra("namadepan", namadepan);
            pindahmain.putExtra("namabelakang",namabelakang);
            pindahmain.putExtra("nomorwa", nomorwa);
            pindahmain.putExtra("umur",umur);
            pindahmain.putExtra("pekerjaan",pekerjaan);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_badges){
            Intent pindahmain= new Intent(MainActivity.this, BadgesPagesActivity.class);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_sop){
            Intent pindahmain= new Intent(MainActivity.this, SOPActivity.class);
            startActivity(pindahmain);
        }
        else if(id == R.id.action_keluar){
            Intent pindahmain = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(pindahmain);
        }

        return super.onOptionsItemSelected(item);
    }

    //route ke event
    public void event1(View view){
        Intent event1 =  new Intent(MainActivity.this, Event1Activity.class);
        startActivity(event1);
        //adanya loe finish(); bikin balik ke halam
    }

    public void event2(View view){
        Intent event2 =  new Intent(MainActivity.this, Event2Activity.class);
        startActivity(event2);
    }

    public void event3(View view){
        Intent event3 =  new Intent(MainActivity.this, Event3Activity.class);
        startActivity(event3);
    }
}
