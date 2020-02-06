package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText namadepan;
    private EditText namabelakang;
    private EditText nomorwa;
    private EditText umur;
    private EditText pekerjaan;
    private Button lanjut;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(!namadepan.getText().toString().isEmpty()&&!namabelakang.getText().toString().isEmpty()&&!nomorwa.getText().toString().isEmpty()){
                lanjut.setEnabled(true);
            }
            else{
                lanjut.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_daftar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        namadepan=findViewById(R.id.namadepan);
        namabelakang=findViewById(R.id.namabelakang);
        nomorwa=findViewById(R.id.nomorwa);
        umur=findViewById(R.id.umur);
        pekerjaan=findViewById(R.id.pekerjaan);
        lanjut=findViewById(R.id.button);

        namadepan.addTextChangedListener(textWatcher);
        namabelakang.addTextChangedListener(textWatcher);
        nomorwa.addTextChangedListener(textWatcher);
        umur.addTextChangedListener(textWatcher);
        pekerjaan.addTextChangedListener(textWatcher);


        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain=new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(pindahmain);
            }
        });
    }
}
