package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SOPActivity extends AppCompatActivity {
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sop);
    }
}
