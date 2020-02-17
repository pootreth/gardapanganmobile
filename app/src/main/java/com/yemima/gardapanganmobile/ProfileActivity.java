package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView firstname;
    private TextView lastname;
    private TextView age;
    private TextView job;
    private TextView wa;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        firstname=findViewById(R.id.fname);
        lastname=findViewById(R.id.lname);
        wa=findViewById(R.id.nowa);
        age=findViewById(R.id.age);
        job=findViewById(R.id.job);

        //copas
        Bundle bundle=getIntent().getExtras();
        final String namadepan=bundle.getString("namadepan");
        final String namabelakang=bundle.getString("namabelakang");
        final String nomorwa=bundle.getString("nomorwa");
        final String pekerjaan=bundle.getString("pekerjaan");
        final String umur=bundle.getString("umur");

        firstname.setText(namadepan);
        lastname.setText(namabelakang);
        wa.setText(nomorwa);
        job.setText(pekerjaan);
        age.setText(umur);
    }

    //route ke profileeditactivity
    public void editt(View view){
        Intent edit=  new Intent(ProfileActivity.this, ProfileEditActivity.class);
        startActivity(edit);
        finish();
    }
}
