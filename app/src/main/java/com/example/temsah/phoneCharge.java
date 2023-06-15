package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.temsah.databinding.ActivityPhoneChargeBinding;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class phoneCharge extends AppCompatActivity {
    ActivityPhoneChargeBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client=new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_charge);
        binding=ActivityPhoneChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}