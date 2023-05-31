package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

//import com.example.temsah.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    // ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



    }
}