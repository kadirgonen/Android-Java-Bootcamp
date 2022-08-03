package com.example.volleyjsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;
    Button button_parse;
    RequestQueue mQueue;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        button_parse = findViewById(R.id.button_parse);
        mQueue = Volley.newRequestQueue(context);
        button_parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    public void jsonParse(){
        String url = "https://reqres.in/api/users";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject contacts = jsonArray.getJSONObject(i);
                                String email = contacts.getString("email");
                                String name = contacts.getString("first_name");
                                String surname = contacts.getString("last_name");
                                String avatar = contacts.getString("avatar");
                                textViewResult.append(email+ "," + name+ ","+surname+ ","+avatar+"\n\n");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Hata", Toast.LENGTH_LONG).show();
            }
        });
        mQueue.add(request);
    }


}