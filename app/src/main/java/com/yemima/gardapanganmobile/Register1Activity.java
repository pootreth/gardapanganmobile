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

public class Register1Activity extends AppCompatActivity {
    private EditText email;
    private EditText newpasswd;
    private EditText confirmpasswd;
    private Button daftar;

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
            if(!email.getText().toString().isEmpty()&&!newpasswd.getText().toString().isEmpty()&&!confirmpasswd.getText().toString().isEmpty()){
                if(newpasswd.getText().toString().equals(confirmpasswd.getText().toString())) {
                    daftar.setEnabled(true);
                }
                else {
                    daftar.setEnabled(false);
                }
            }
            else{
                daftar.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        //copas
        Bundle bundle=getIntent().getExtras();
        final String namadepan=bundle.getString("namadepan");
        final String namabelakang=bundle.getString("namabelakang");
        final String nomorwa=bundle.getString("nomorwa");
        final String pekerjaan=bundle.getString("pekerjaan");
        final String umur=bundle.getString("umur");

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_daftar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        email=findViewById(R.id.email);
        newpasswd=findViewById(R.id.newpasswd);
        confirmpasswd=findViewById(R.id.confirmpasswd);
        daftar=findViewById(R.id.daftar);

        email.addTextChangedListener(textWatcher);
        newpasswd.addTextChangedListener(textWatcher);
        confirmpasswd.addTextChangedListener(textWatcher);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain=new Intent(Register1Activity.this, Register2Activity.class);
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
