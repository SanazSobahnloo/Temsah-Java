package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.temsah.databinding.ActivityMain2Binding;
import androidx.databinding.DataBindingUtil;
public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//c
        Intent intentAboutUs = new Intent(this, aboutUs.class);
        Intent intentContactUs = new Intent(this, contactUs.class);
        Intent intentLogin = new Intent(this, login.class);
        Intent intentFixedLine = new Intent(this, fixedLine.class);
        Intent intentPhoneCharge = new Intent(this, phoneCharge.class);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String phone=intent.getStringExtra("phone");
        binding.aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAboutUs);
            }
        });

        binding.contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentContactUs);
            }
        });
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentLogin);
            }
        });
        binding.estelamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentFixedLine);
            }
        });

        binding.chargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPhoneCharge);
            }
        });

        binding.aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAboutUs);
            }
        });



    }

}