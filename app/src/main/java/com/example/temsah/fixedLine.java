package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.temsah.databinding.ActivityContactUsBinding;
import com.example.temsah.databinding.ActivityFixedLineBinding;
import com.example.temsah.databinding.ActivityMainBinding;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class fixedLine extends AppCompatActivity {
    ActivityFixedLineBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client=new OkHttpClient();
    
    
    String mid;
    String fin;
      
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_line);
        binding= ActivityFixedLineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.estelamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=binding.phone.getText().toString();
                callAPI(number);
            }
        });

    }

    private void callAPI(String number) {
        JSONObject object=new JSONObject();

    }
}