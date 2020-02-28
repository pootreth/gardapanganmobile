package com.yemima.gardapanganmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class RateActivity extends AppCompatActivity{
    private View ajakdonasi;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView starf1;
    private ImageView starf2;
    private ImageView starf3;
    private ImageView starf4;
    private ImageView starf5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.popupwindows2);

        star1=findViewById(R.id.star1);
        star2=findViewById(R.id.star2);
        star3=findViewById(R.id.star3);
        star4=findViewById(R.id.star4);
        star5=findViewById(R.id.star5);
        starf1=findViewById(R.id.starf1);
        starf2=findViewById(R.id.starf2);
        starf3=findViewById(R.id.starf3);
        starf4=findViewById(R.id.starf4);
        starf5=findViewById(R.id.starf5);
        ajakdonasi=findViewById(R.id.send);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                starf2.setVisibility(View.INVISIBLE);
                star3.setVisibility(View.VISIBLE);
                starf3.setVisibility(View.INVISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.VISIBLE);
                starf3.setVisibility(View.INVISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.INVISIBLE);
                starf4.setVisibility(View.VISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.INVISIBLE);
                starf4.setVisibility(View.VISIBLE);
                star5.setVisibility(View.INVISIBLE);
                starf5.setVisibility(View.VISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        starf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                starf2.setVisibility(View.INVISIBLE);
                star3.setVisibility(View.VISIBLE);
                starf3.setVisibility(View.INVISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        starf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.VISIBLE);
                starf3.setVisibility(View.INVISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        starf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.VISIBLE);
                starf4.setVisibility(View.INVISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        starf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.INVISIBLE);
                starf4.setVisibility(View.VISIBLE);
                star5.setVisibility(View.VISIBLE);
                starf5.setVisibility(View.INVISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });

        starf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setVisibility(View.INVISIBLE);
                starf1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.INVISIBLE);
                starf2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.INVISIBLE);
                starf3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.INVISIBLE);
                starf4.setVisibility(View.VISIBLE);
                star5.setVisibility(View.INVISIBLE);
                starf5.setVisibility(View.VISIBLE);
                ajakdonasi.setEnabled(true);
            }
        });


        ajakdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahrr=new Intent(RateActivity.this, AjakanDonasiActivity.class);
                startActivity(pindahrr);
            }
        });
    }
}
