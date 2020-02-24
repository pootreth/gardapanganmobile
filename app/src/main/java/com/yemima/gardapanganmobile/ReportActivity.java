package com.yemima.gardapanganmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class ReportActivity extends AppCompatActivity {
    private Button send;
    private Bitmap bitmap;
    private ImageView profil;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //foto
        profil=findViewById(R.id.add_photo);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });

        send=findViewById(R.id.send_report);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //route ke joined event gold user
    public void back(View view){
        Intent back=  new Intent(ReportActivity.this, MainGoldActivity.class);
        startActivity(back);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == 50&& data != null && data.getData() != null )||requestCode==51 && resultCode == RESULT_OK)
        {
            try {
                if(requestCode==51){
                    bitmap = (Bitmap) data.getExtras().get("data");
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    }
                }
                else{
                    Uri filesertifj = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filesertifj);
                }
                profil.setImageBitmap(bitmap);
                profil.setVisibility(View.VISIBLE);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void alertDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(ReportActivity.this);
        builder.setTitle("Pilih metode");

        final String[] met={"Kamera", "Galeri"};
        builder.setItems(met, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(VerifActivity.this, met[which], Toast.LENGTH_SHORT).show();
                switch (which){
                    case 0:
                        chooseImageCamera();
                        break;
                    case 1:
                        chooseImageGalery();
                        break;
                }
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void chooseImageGalery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        int imgreq=50;
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), imgreq);
    }

    private void chooseImageCamera() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
        int imgreq=51;
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, imgreq);

    }
}
