package com.yemima.gardapanganmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileEditActivity extends AppCompatActivity {
    private TextView firstname;
    private TextView lastname;
    private TextView age;
    private String job;
    private TextView wa;
//    private Bitmap bitmap;
//    private ImageView profil;
//    private static final int MY_CAMERA_PERMISSION_CODE = 100;
//    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_profile_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        profil=findViewById(R.id.profile_editdp);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog();
//            }
//        });

        firstname=findViewById(R.id.fname);
        lastname=findViewById(R.id.lname);
        wa=findViewById(R.id.nowa);
        age=findViewById(R.id.age);

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
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                Typeface typeface = ResourcesCompat.getFont(ProfileEditActivity.this, R.font.googlesans_regular);
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
                job = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //route ke profileeditactivity
    public void save(View view){
        Intent simpan=  new Intent(ProfileEditActivity.this, ProfileActivity.class);
        simpan.putExtra("namadepan", firstname.getText().toString());
        simpan.putExtra("namabelakang",lastname.getText().toString());
        simpan.putExtra("nomorwa", wa.getText().toString());
        simpan.putExtra("umur",age.getText().toString());
        simpan.putExtra("pekerjaan",job);
        startActivity(simpan);
        finish();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if((requestCode == 50&& data != null && data.getData() != null )||requestCode==51 && resultCode == RESULT_OK)
//        {
//            try {
//                if(requestCode==51){
//                    bitmap = (Bitmap) data.getExtras().get("data");
//                    if (ContextCompat.checkSelfPermission(this,
//                            Manifest.permission.READ_EXTERNAL_STORAGE)
//                            != PackageManager.PERMISSION_GRANTED) {
//
//                        ActivityCompat.requestPermissions(this,
//                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
//                    }
//                }
//                else{
//                    Uri filesertifj = data.getData();
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filesertifj);
//                }
//                profil.setImageBitmap(bitmap);
//                profil.setVisibility(View.VISIBLE);
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void alertDialog(){
//        AlertDialog.Builder builder= new AlertDialog.Builder(ProfileEditActivity.this);
//        builder.setTitle("Pilih metode");
//
//        final String[] met={"Kamera", "Galeri"};
//        builder.setItems(met, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                        Toast.makeText(VerifActivity.this, met[which], Toast.LENGTH_SHORT).show();
//                switch (which){
//                    case 0:
//                        chooseImageCamera();
//                        break;
//                    case 1:
//                        chooseImageGalery();
//                        break;
//                }
//            }
//        });
//        AlertDialog dialog=builder.create();
//        dialog.show();
//    }
//
//    private void chooseImageGalery() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        int imgreq=50;
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), imgreq);
//    }
//
//    private void chooseImageCamera() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
//        int imgreq=51;
//        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, imgreq);
//    }

}
