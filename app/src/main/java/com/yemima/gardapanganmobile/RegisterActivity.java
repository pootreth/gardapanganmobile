package com.yemima.gardapanganmobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText namadepan;
    private EditText namabelakang;
    private EditText nomorwa;
    private EditText umur;
    private Button lanjut;
    private String job;

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
            if(!namadepan.getText().toString().isEmpty()&&!namabelakang.getText().toString().isEmpty()&&!nomorwa.getText().toString().isEmpty()&&!umur.getText().toString().isEmpty()){
                if(nomorwa.length()>9 && umur.length()==2) {
                    lanjut.setEnabled(true);
                }
                else{
                    lanjut.setEnabled(false);
                }
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

        namadepan=findViewById(R.id.fname);
        namabelakang=findViewById(R.id.namabelakang);
        nomorwa=findViewById(R.id.nomorwa);
        umur=findViewById(R.id.umur);
        lanjut=findViewById(R.id.button2);

        Spinner spinner=findViewById(R.id.spinner);
        final List<String> pekerjaan=new ArrayList<>();
        pekerjaan.add("Pekerjaan");
        pekerjaan.add("Pelajar");
        pekerjaan.add("Mahasiswa");
        pekerjaan.add("Lain-lain");

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,pekerjaan){
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
                Typeface typeface = ResourcesCompat.getFont(RegisterActivity.this, R.font.googlesans_regular);
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
                job=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

    }
});

        namadepan.addTextChangedListener(textWatcher);
        namabelakang.addTextChangedListener(textWatcher);
        nomorwa.addTextChangedListener(textWatcher);
        umur.addTextChangedListener(textWatcher);


        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain=new Intent(RegisterActivity.this, Register1Activity.class);
                pindahmain.putExtra("namadepan", namadepan.getText().toString());
                pindahmain.putExtra("namabelakang",namabelakang.getText().toString());
                pindahmain.putExtra("nomorwa", nomorwa.getText().toString());
                pindahmain.putExtra("umur",umur.getText().toString());
                pindahmain.putExtra("pekerjaan",job);
                startActivity(pindahmain);
            }
        });
    }
}
