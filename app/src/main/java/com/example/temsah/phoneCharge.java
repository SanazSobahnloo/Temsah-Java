package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.temsah.databinding.ActivityAboutUsBinding;
import com.example.temsah.databinding.ActivityPhoneChargeBinding;

public class phoneCharge extends AppCompatActivity {
    ActivityPhoneChargeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_charge);
        binding= ActivityPhoneChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}