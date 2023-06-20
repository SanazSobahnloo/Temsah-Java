package com.example.temsah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class fixedLine extends AppCompatActivity {
    ActivityFixedLineBinding binding;
    public static final MediaType JSON
            = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client=new OkHttpClient();
    
    String MidTerm;
    String Finalterm;
      
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
        try {
            object.put("FixedLineNumber",number);
        }
        catch (Exception e){
            Toast.makeText(fixedLine.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        RequestBody requestBody=RequestBody.create(object.toString(),JSON);
        Request request=new Request.Builder().url("https://charge.sep.ir/Inquiry/FixedLineBillInquiry")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(fixedLine.this,"failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            try {
                   JSONObject jsonObject=new JSONObject(response.body().string());
                Finalterm=jsonObject.getJSONArray("data").getJSONObject(0).getString("FinalTerm");
                MidTerm=jsonObject.getJSONArray("data").getJSONObject(1).getString("MidTerm");
                binding.midbill.setText(MidTerm);
                binding.finbill.setText(Finalterm);
                }
            catch (JSONException e){
                Toast.makeText(fixedLine.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}