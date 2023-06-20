package com.example.temsah;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
    Integer maliat=300;
    Integer operator=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_charge);
        binding=ActivityPhoneChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=binding.phoneNumber.getText().toString();
                Integer amount=Integer.parseInt( binding.priceBtn.getText().toString());
                callAPI(number);
            }
        });
        binding.bwHamrahAval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwHamrahAval.setVisibility(View.INVISIBLE);
                binding.hamrahAval.setVisibility(View.VISIBLE);
                binding.irancel.setVisibility(View.INVISIBLE);
                binding.bwIrancel.setVisibility(View.VISIBLE);
                binding.rightel.setVisibility(View.INVISIBLE);
                binding.bwRightel.setVisibility(View.VISIBLE);
                binding.phoneNumber.setBackgroundColor(Color.parseColor("#54c5d0"));
                operator=1;

            }
        });
        binding.bwIrancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwIrancel.setVisibility(View.INVISIBLE);
                binding.irancel.setVisibility(View.VISIBLE);
                binding.rightel.setVisibility(View.INVISIBLE);
                binding.bwRightel.setVisibility(View.VISIBLE);
                binding.hamrahAval.setVisibility(View.INVISIBLE);
                binding.bwHamrahAval.setVisibility(View.VISIBLE);
                binding.phoneNumber.setBackgroundColor(Color.parseColor("#febe10"));
                operator=2;
            }
        });
        binding.bwRightel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bwRightel.setVisibility(View.INVISIBLE);
                binding.rightel.setVisibility(View.VISIBLE);
                binding.irancel.setVisibility(View.INVISIBLE);
                binding.bwIrancel.setVisibility(View.VISIBLE);
                binding.hamrahAval.setVisibility(View.INVISIBLE);
                binding.bwHamrahAval.setVisibility(View.VISIBLE);
                binding.phoneNumber.setBackgroundColor(Color.parseColor("#941063"));
                operator=3;

            }
        });
        binding.p10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.priceBtn.setText("1000");
                price=Integer.parseInt(binding.priceBtn.getText().toString());
                finalprice=(price+maliat);
                binding.showCharge.setText(finalprice.toString());
            }
        });
         binding.p20000.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                   binding.priceBtn.setText("2000");
                   price=Integer.parseInt(binding.priceBtn.getText().toString());
                   finalprice=(price+maliat);
                   binding.showCharge.setText(finalprice.toString());
                }
         });
         binding.p50000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("5000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());
                 finalprice=(price+maliat);
                 binding.showCharge.setText(finalprice.toString());

             }
         });
         binding.p100000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("10000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());
                 finalprice=(price+maliat);
                 binding.showCharge.setText(finalprice.toString());
             }
         });

    }

    private void callAPI(String number) {
    }
}