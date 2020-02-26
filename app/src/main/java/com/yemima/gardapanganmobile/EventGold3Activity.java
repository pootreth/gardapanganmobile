package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class EventGold3Activity extends AppCompatActivity {
    private ScrollView view1;
    private LinearLayout view2;
    private ImageView report;
    private ImageView chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_gold3);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //beda
        view1=findViewById(R.id.contenteventgold1);
        view2=findViewById(R.id.contentsplitgold1);

        final ImageView daftar=findViewById(R.id.daftar1);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout chat=findViewById(R.id.buttonbawah1);
                chat.setVisibility(View.VISIBLE);
                LinearLayout tbs=findViewById(R.id.buttonbawah);
                tbs.setVisibility(View.INVISIBLE);
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                ImageView pesertaafter = findViewById(R.id.pesertab);
                pesertaafter.setImageResource(R.drawable.pesertaaftergold);
            }
        });
        ImageView tidakbisa=findViewById(R.id.tidakbisa1);
        tidakbisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout tbss=findViewById(R.id.buttonbawahh1);
                tbss.setVisibility(View.VISIBLE);
                LinearLayout tbs=findViewById(R.id.buttonbawah);
                tbs.setVisibility(View.INVISIBLE);
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
            }
        });
        chat=findViewById(R.id.chatgold);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(EventGold3Activity.this, ChatActivity.class);
                startActivity(pindahmain);
            }
        });
        report=findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(EventGold3Activity.this, ReportActivity.class);
                startActivity(pindahmain);
            }
        });
    }
}
