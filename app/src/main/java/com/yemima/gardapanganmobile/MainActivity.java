package com.yemima.gardapanganmobile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton photo;

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

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner=findViewById(R.id.spinner);
        final List<String> profile=new ArrayList<>();
        profile.add("Profil");
        profile.add("Badges");
        profile.add("S.O.P.");
        profile.add("Bantuan");
        profile.add("Keluar");

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,profile){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                Typeface typeface = ResourcesCompat.getFont(MainActivity.this, R.font.googlesans_regular);
                tv.setTypeface(typeface);

                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
                }
                else {
                    tv.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                return view;
            }
        };

        dataadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(dataadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photo=parent.getItemAtPosition(photo).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        photo=findViewById(R.id.profile);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(MainActivity.this, ProfileActivity.class);
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
