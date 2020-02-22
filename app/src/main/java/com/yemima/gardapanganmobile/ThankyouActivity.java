package com.yemima.gardapanganmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThankyouActivity extends AppCompatActivity {
    private View animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_thankyou);

        animate=findViewById(R.id.endofdonasi);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahmain = new Intent(ThankyouActivity.this, DonasiTunaiActivity.class);
                pindahmain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindahmain);
                finish();
            }
        });
    }
}
