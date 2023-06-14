package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.temsah.databinding.ActivityAboutUsBinding;
import com.example.temsah.databinding.ActivityMain2Binding;
import com.example.temsah.databinding.ActivityMainBinding;


public class aboutUs extends AppCompatActivity {
    ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        binding= ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}