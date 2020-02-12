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
}
