package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register2Activity extends AppCompatActivity {
    private Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ilangin header
        try
            {
                this.getSupportActionBar().hide();
            }
            catch(NullPointerException e){}
        setContentView(R.layout.activity_register2);

        lanjut=findViewById(R.id.lanjut);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(Register2Activity.this, Register3Activity.class);
                startActivity(pindahmain);
            }

        });

    }

}
