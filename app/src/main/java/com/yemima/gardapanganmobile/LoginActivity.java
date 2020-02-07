package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button masuk;

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(!email.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()){
                if(String.format(email.getText().toString())){
                    masuk.setEnabled(true);
                }
            }
            else{
                masuk.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_masuk);

        email=findViewById(R.id.editText);
        password=findViewById(R.id.editPasswd);
        masuk=findViewById(R.id.button);

        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("golduser@gmail.com")){
                    Intent pindahmain=new Intent(LoginActivity.this, MainGoldActivity.class);
                    startActivity(pindahmain);
                }
                else{
                Intent pindahmain=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(pindahmain);
                }
            }
        });
        TextView daftar=findViewById(R.id.textView3);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahrr=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(pindahrr);
            }
        });
    }

    public void pindahregis(View view){
        Intent pindahrr=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(pindahrr);
    }
}
