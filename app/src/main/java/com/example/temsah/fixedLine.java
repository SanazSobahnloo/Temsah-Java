package com.example.temsah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.temsah.databinding.ActivityContactUsBinding;
import com.example.temsah.databinding.ActivityFixedLineBinding;
import com.example.temsah.databinding.ActivityMainBinding;

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
import retrofit2.Retrofit;

public class fixedLine extends AppCompatActivity {

    ActivityFixedLineBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client=new OkHttpClient();
    

    String re1,re2,re3,re4,re5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_line);
        binding= ActivityFixedLineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                binding.copy.setText(binding.phone.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                callAPI(binding.copy.getText());

            }
        });
        binding.infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentabout = new Intent(fixedLine.this, aboutUs.class);
                startActivity(intentabout);
            }
        });
        binding.contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcontact = new Intent(fixedLine.this, contactUs.class);
                startActivity(intentcontact);
            }
        });
        binding.appIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmain = new Intent(fixedLine.this, MainActivity2.class);
                startActivity(intentmain);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(fixedLine.this,"toast",Toast.LENGTH_SHORT).show();
                binding.textView9.setText(re1);
            }
        });
    }

    private void callAPI(CharSequence text) {
        JSONObject object=new JSONObject();
        try {
            object.put("FixedLineNumber",text);
        }
        catch (Exception e) {
           Toast.makeText(fixedLine.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        RequestBody requestBody=RequestBody.create(object.toString(),JSON);
        Request request=new Request.Builder().url("https://charge.sep.ir/Inquiry/FixedLineBillInquiry")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //Toast.makeText(fixedLine.this,"failed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            try {
                   JSONObject jsonObject=new JSONObject(response.body().string());

                 re5=object.getJSONObject("data").getJSONObject("MidTerm").getString("BillID");
                 re1=object.getJSONObject("data").getJSONObject("MidTerm").getString("Amount");
                 re2=object.getJSONObject("data").getJSONObject("MidTerm").getString("PaymentID");
                 re3=object.getJSONObject("data").getJSONObject("FinalTerm").getString("Amount");
                 re4=object.getJSONObject("data").getJSONObject("FinalTerm").getString("PaymentID");

                }
            catch (JSONException e){
                Toast.makeText(fixedLine.this,e.getMessage(), Toast.LENGTH_SHORT).show();

            }
            }
        });

    }
}