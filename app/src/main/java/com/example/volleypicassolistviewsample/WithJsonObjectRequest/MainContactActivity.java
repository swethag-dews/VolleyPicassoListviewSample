package com.example.volleypicassolistviewsample.WithJsonObjectRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleypicassolistviewsample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainContactActivity extends AppCompatActivity {

    ListView contactListView;
    CustomContactAdapter adapter;
    ArrayList<ContactInfo> contactInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_main);

        contactInfoArrayList = new ArrayList<>();
        contactListView = findViewById(R.id.contact_list_view);
        adapter = new CustomContactAdapter(this, contactInfoArrayList);
        contactListView.setAdapter(adapter);

        fetchData();
    }

    /*
    *{
  "contactlist": [
    {
      "email": "ravi@gmail.com",
      "phno": 89320113487,
      "id": "id1",
      "name": "Ravi Tamada"
    },
    {
      "email": "swethalathagoli@gmail.com",
      "phno": 893231413487,
      "id": "id2",
      "name": "Swetha Latha Goli"
    },
    {
      "email": "vijji.a@gmail.com",
      "phno": 97210112417,
      "id": "id3",
      "name": "Vijaya Latha Angadala"
    },
    {
      "email": "ratnaharika@gmail.com",
      "phno": 9603640092,
      "id": "id4",
      "name": "Ratna Harika Bathina"
    }
  ]
}
    * */
    private void fetchData(){
        String url = "http://www.json-generator.com/api/json/get/ceiEatWjjC?indent=2";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("contactlist");
                            for (int i = 0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String id = jsonObject.getString("id");
                                String emailId = jsonObject.getString("email");
                                String mobile = jsonObject.getString("phno");

                                ContactInfo contactInfo = new ContactInfo(id, name, emailId, mobile);
                                contactInfoArrayList.add(contactInfo);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
