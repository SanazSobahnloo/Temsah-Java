package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

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
            }
        });
        binding.female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                binding.maleIcon.setVisibility(View.INVISIBLE);
                binding.femaleIcon.setVisibility(View.VISIBLE);
            }
        });
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmain = new Intent(login.this, MainActivity2.class);
                intentmain.putExtra("name",binding.name.getText().toString());


                startActivity(intentmain);
            }
        });
    }
}