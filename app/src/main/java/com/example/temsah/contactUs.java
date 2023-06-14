package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.temsah.databinding.ActivityContactUsBinding;
import com.example.temsah.databinding.ActivityMainBinding;

public class contactUs extends AppCompatActivity {
    ActivityContactUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        binding=ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}