package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DonasiRestoranActivity extends AppCompatActivity {
    private String donasi;
    //private Button send;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_restoran);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_donasi_restoran);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Spinner spinner=findViewById(R.id.spinner);
        final List<String> jenisdonasi=new ArrayList<>();
        jenisdonasi.add("Jenis Donasi");
        jenisdonasi.add("Sekali");
        jenisdonasi.add("Rutin/Berulang");

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,jenisdonasi){
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
                Typeface typeface = ResourcesCompat.getFont(DonasiRestoranActivity.this, R.font.googlesans_regular);
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
                donasi = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        send = findViewById(R.id.send);
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}
