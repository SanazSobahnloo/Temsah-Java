package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.temsah.databinding.ActivityFixedLineBinding;
import com.example.temsah.databinding.ActivityLoginBinding;
import com.example.temsah.databinding.ActivityMainBinding;

public class login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                binding.maleIcon.setVisibility(View.VISIBLE);
                binding.femaleIcon.setVisibility(View.INVISIBLE);
                if(TextUtils.isEmpty(binding.name.getText()) && TextUtils.isEmpty(binding.phoneNumber.getText()))
                {
                    Toast.makeText(login.this,"please enter your name and number!", Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.saveBtn.setBackgroundColor(Color.parseColor("#4CD555"));}
            }
        });
        binding.female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                binding.maleIcon.setVisibility(View.INVISIBLE);
                binding.femaleIcon.setVisibility(View.VISIBLE);
                if(TextUtils.isEmpty(binding.name.getText()) && TextUtils.isEmpty(binding.phoneNumber.getText()))
                {
                    Toast.makeText(login.this,"please enter your name and number!", Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.saveBtn.setBackgroundColor(Color.parseColor("#4CD555"));}
            }
        });
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmain = new Intent(login.this, MainActivity2.class);
                intentmain.putExtra("name",binding.name.getText().toString());
                intentmain.putExtra("phone",binding.phoneNumber.getText().toString());
                startActivity(intentmain);
            }
        });
    }
}