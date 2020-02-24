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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

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
    private Bitmap bitmap;
    private ImageView profil;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

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

        //foto
        profil=findViewById(R.id.add_photo);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });

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
        AlertDialog.Builder builder= new AlertDialog.Builder(RequestPenjemputanActivity.this);
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
