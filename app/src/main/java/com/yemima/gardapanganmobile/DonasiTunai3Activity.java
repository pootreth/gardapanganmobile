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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DonasiTunai3Activity extends AppCompatActivity {
    private View animate;
    private View finishdonasi;
    private EditText tgltf;
    private EditText jumlah;
    private String bank;
    private Spinner spinner;
    private String text;

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
            if(!tgltf.getText().toString().isEmpty()&&!jumlah.getText().toString().isEmpty()){
                text = spinner.getSelectedItem().toString();
                if (text.equals("Bank")){
                    finishdonasi.setEnabled(false);
                }
                else{
                    finishdonasi.setEnabled(true);
                }
            }
            else{
                finishdonasi.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_tunai3);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_donasi_tunai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tgltf=findViewById(R.id.tgltransfer);
        jumlah=findViewById(R.id.jumlahtransfer);
        finishdonasi=findViewById(R.id.sendconfirm);

        spinner=findViewById(R.id.spinnerbank);
        final List<String> bankk=new ArrayList<>();
        bankk.add("Bank");
        bankk.add("BRI");
        bankk.add("BNI");
        bankk.add("Mandiri");
        bankk.add("Lain-lain");

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,bankk){
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
                Typeface typeface = ResourcesCompat.getFont(DonasiTunai3Activity.this, R.font.googlesans_regular);
                tv.setTypeface(typeface);

                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(getResources().getColor(R.color.colorPrimaryOpacity));
                }
                else {
                    finishdonasi.setEnabled(true);
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
                bank=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tgltf.addTextChangedListener(textWatcher);
        jumlah.addTextChangedListener(textWatcher);

        finishdonasi=findViewById(R.id.send);
        finishdonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(DonasiTunai3Activity.this, ThankyouActivity.class);
                startActivity(pindahmain);
                finish();
            }
        });
    }
}
