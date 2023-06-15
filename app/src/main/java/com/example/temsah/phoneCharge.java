package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.temsah.databinding.ActivityPhoneChargeBinding;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class phoneCharge extends AppCompatActivity {
    ActivityPhoneChargeBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client=new OkHttpClient();
    //Boolean state=Boolean.FALSE;
    Integer price;
    Integer finalprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_charge);
        binding=ActivityPhoneChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bwHamrahAval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwHamrahAval.setVisibility(View.INVISIBLE);
                binding.hamrahAval.setVisibility(View.VISIBLE);
            }
        });
        binding.bwIrancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwIrancel.setVisibility(View.INVISIBLE);
                binding.irancel.setVisibility(View.VISIBLE);

            }
        });
        binding.bwRightel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwRightel.setVisibility(View.INVISIBLE);
                binding.rightel.setVisibility(View.VISIBLE);
            }
        });
        binding.p10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.priceBtn.setText("1000");
                price=Integer.parseInt(binding.priceBtn.getText().toString());
                finalprice=(price+200);
                binding.showCharge.append(finalprice.toString());
            }
        });
         binding.p20000.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                   binding.priceBtn.setText("2000");
                   price=Integer.parseInt(binding.priceBtn.getText().toString());
                }
         });
         binding.p10000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("5000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());

             }
         });
         binding.p100000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("10000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());
             }
         });
    }
}