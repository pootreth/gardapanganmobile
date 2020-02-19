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
import android.widget.TextView;

public class RequestPenjemputanActivity extends AppCompatActivity {
    private EditText jenismakanan;
    private EditText jumlahporsi;
    private EditText tglkadaluarsa;
    private EditText sumbermakanan;
    private EditText partner;
    private EditText meetingpoint;
    private EditText tambahan;
    private Button send;

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
//            if(!jenismakanan.getText().toString().isEmpty()&&!jumlahporsi.getText().toString().isEmpty()&&!tglkadaluarsa.getText().toString().isEmpty()&&!sumbermakanan.getText().toString().isEmpty()&&!partner.getText().toString().isEmpty()&&!meetingpoint.getText().toString().isEmpty()){
                send.setEnabled(true);
//            }
//            else{
//                kirim.setEnabled(false);
//            }
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_penjemputan);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_request_penjemputan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //route ke home
    public void back(View view){
        Intent back=  new Intent(RequestPenjemputanActivity.this, MainGoldActivity.class);
        startActivity(back);
        finish();
    }
}
