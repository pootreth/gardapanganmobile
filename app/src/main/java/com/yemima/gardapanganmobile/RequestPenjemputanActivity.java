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
import android.widget.ImageView;
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
    private ImageView kurang;
    private ImageView kurang2;
    private ImageView kurang3;
    private ImageView tambah;
    private ImageView tambah2;
    private ImageView tambah3;
    private TextView angka;
    private TextView angka2;
    private TextView angka3;
    private int jumlah=0;
    private int jumlah2=0;
    private int jumlah3=0;

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

        kurang=findViewById(R.id.kurang);
        kurang2=findViewById(R.id.kurang2);
        kurang3=findViewById(R.id.kurang3);
        tambah=findViewById(R.id.tambah);
        tambah2=findViewById(R.id.tambah2);
        tambah3 =findViewById(R.id.tambah3);
        angka=findViewById(R.id.angka);
        angka2=findViewById(R.id.angka2);
        angka3=findViewById(R.id.angka3);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah++;
                if(jumlah>0){
                    kurang.setBackgroundResource(R.drawable.kurangg);
                }
                angka.setText(Integer.toString(jumlah));
            }
        });
        tambah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah2++;
                if(jumlah2>0){
                    kurang2.setBackgroundResource(R.drawable.kurangg);
                }
                angka2.setText(Integer.toString(jumlah2));
            }
        });
        tambah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah3++;
                if(jumlah3>0){
                    kurang3.setBackgroundResource(R.drawable.kurangg);
                }
                angka3.setText(Integer.toString(jumlah3));
            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlah>0){
                    jumlah--;
                    angka.setText(Integer.toString(jumlah));
                    if(jumlah<=0){
                        kurang.setBackgroundResource(R.drawable.kurang);
                    }
                }
            }
        });
        kurang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlah2>0){
                    jumlah2--;
                    angka2.setText(Integer.toString(jumlah2));
                    if(jumlah2<=0){
                        kurang2.setBackgroundResource(R.drawable.kurang);
                    }
                }
            }
        });
        kurang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlah3>0){
                    jumlah3--;
                    angka3.setText(Integer.toString(jumlah3));
                    if(jumlah3<=0){
                        kurang3.setBackgroundResource(R.drawable.kurang);
                    }
                }
            }
        });

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
