package com.example.laundrykudus.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.laundrykudus.R;

public class UbahActivity extends AppCompatActivity {
    private int xId;
    private String xNama, xAlamat, xTelepon;
    private EditText etNama, etAlamat, etTelepon;
    private Button btnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent terima = getIntent();
        xId = terima.getIntExtra("xId",-1);
        xNama = terima.getStringExtra("xNama");
        xAlamat = terima.getStringExtra("xAlamat");
        xTelepon = terima.getStringExtra("xTelepon");

        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etTelepon = findViewById(R.id.et_telepon);
        btnUbah = findViewById(R.id.btn_ubah);

        etNama.setText(xNama);
        etAlamat.setText(xAlamat);
        etTelepon.setText(xTelepon);


    }
}