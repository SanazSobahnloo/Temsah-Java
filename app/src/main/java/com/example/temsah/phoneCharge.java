package com.example.temsah;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.temsah.databinding.ActivityPhoneChargeBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class phoneCharge extends AppCompatActivity {
    ActivityPhoneChargeBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient Client=new OkHttpClient();

    private static final int RESULT_PICK_CONTACT =1;
    Integer price;
    Integer finalprice;
    Integer maliat=300;
    Integer operator=0;
String URL
        ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_charge);
        binding=ActivityPhoneChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String num=binding.phoneNumber.getText().toString();


        binding.infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentabout = new Intent(phoneCharge.this, aboutUs.class);
                startActivity(intentabout);

            }
        });
        binding.contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcontact = new Intent(phoneCharge.this, contactUs.class);
                startActivity(intentcontact);
            }
        });
        binding.appIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmain = new Intent(phoneCharge.this, MainActivity2.class);
                startActivity(intentmain);
            }
        });
        binding.phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                  if (charSequence.toString().startsWith("0937")){binding.button2.setBackgroundColor(Color.parseColor("#febe10"));


                    binding.bwIrancel.setVisibility(View.INVISIBLE);
                    binding.irancel.setVisibility(View.VISIBLE);
                    binding.rightel.setVisibility(View.INVISIBLE);
                    binding.bwRightel.setVisibility(View.VISIBLE);
                    binding.hamrahAval.setVisibility(View.INVISIBLE);
                    binding.bwHamrahAval.setVisibility(View.VISIBLE);

                    operator=2;
                    binding.textView3.setText(operator);


                } else if (charSequence.toString().startsWith("0912")) {
                    binding.button2.setBackgroundColor(Color.parseColor("#54c5d0"));
                    binding.bwHamrahAval.setVisibility(View.INVISIBLE);
                    binding.hamrahAval.setVisibility(View.VISIBLE);
                    binding.irancel.setVisibility(View.INVISIBLE);
                    binding.bwIrancel.setVisibility(View.VISIBLE);
                    binding.rightel.setVisibility(View.INVISIBLE);
                    binding.bwRightel.setVisibility(View.VISIBLE);
                    operator=1;
                    binding.textView3.setText(operator);
                } else if (charSequence.toString().startsWith("0921")) {
                    binding.button2.setBackgroundColor(Color.parseColor("#941063"));
                    binding.bwRightel.setVisibility(View.INVISIBLE);
                    binding.rightel.setVisibility(View.VISIBLE);
                    binding.irancel.setVisibility(View.INVISIBLE);
                    binding.bwIrancel.setVisibility(View.VISIBLE);
                    binding.hamrahAval.setVisibility(View.INVISIBLE);
                    binding.bwHamrahAval.setVisibility(View.VISIBLE);

                    operator=3;
                    binding.textView3.setText(operator);
                }
                else {binding.button2.setBackgroundColor(Color.parseColor("#ffffff"));
                    binding.bwRightel.setVisibility(View.VISIBLE);
                    binding.rightel.setVisibility(View.INVISIBLE);
                    binding.irancel.setVisibility(View.INVISIBLE);
                    binding.bwIrancel.setVisibility(View.VISIBLE);
                    binding.hamrahAval.setVisibility(View.INVISIBLE);
                    binding.bwHamrahAval.setVisibility(View.VISIBLE);
                    }
                binding.textView2.setText(binding.phoneNumber.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

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

                operator=1;

                binding.textView3.setText(operator.toString());


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

                operator=2;
                binding.textView3.setText(operator.toString());

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

                operator=3;
                binding.textView3.setText(operator.toString());


            }
        });
        binding.p10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.priceBtn.setText("10000");
                price=Integer.parseInt(binding.priceBtn.getText().toString());
                finalprice=(price+maliat);
                binding.showCharge.setText(finalprice.toString());
                binding.textView4.setText(binding.priceBtn.getText());
            }
        });
         binding.p20000.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                   binding.priceBtn.setText("20000");
                   price=Integer.parseInt(binding.priceBtn.getText().toString());
                   finalprice=(price+maliat);
                   binding.showCharge.setText(finalprice.toString());
                   binding.textView4.setText(binding.priceBtn.getText());
                }
         });
         binding.p50000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("50000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());
                 finalprice=(price+maliat);
                 binding.showCharge.setText(finalprice.toString());
                 binding.textView4.setText(binding.priceBtn.getText());

             }
         });
         binding.p100000.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 binding.priceBtn.setText("100000");
                 price=Integer.parseInt(binding.priceBtn.getText().toString());
                 finalprice=(price+maliat);
                 binding.showCharge.setText(finalprice.toString());
                 binding.textView4.setText(binding.priceBtn.getText());
             }
         });
         binding.buyBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(binding.phoneNumber.length()==11) {

                     callAPI(binding.textView2.getText().toString(), binding.textView3.getText().toString(), binding.textView4.getText().toString());
                 }
                 else{Toast.makeText(phoneCharge.this,"invalid number",Toast.LENGTH_SHORT).show();}
                 }
         });


    }

    private void callAPI(String number,String operat,String amount) {
        JSONObject object=new JSONObject();
        try {
            object.put("MobileNo",number);
            object.put("OperatorType",operat);
            object.put("AmountPure",amount);
            object.put("mid","0");
        }
        catch (Exception e){
            Toast.makeText(phoneCharge.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        RequestBody requestBody=RequestBody.create(object.toString(),JSON);
        Request request=new Request.Builder().url("https://topup.pec.ir/")

                .post(requestBody)
                .build();

        Client.newCall(request).enqueue(new Callback() {
    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        Toast.makeText(phoneCharge.this,"failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        try {
            JSONObject jsonObject = new JSONObject(response.body().string());
            URL = jsonObject.getString("url");
            Intent intentp=new Intent(Intent.ACTION_VIEW,Uri.parse(URL));
            startActivity(intentp);
        } catch (JSONException e) {
            Toast.makeText(phoneCharge.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
});

    }


}