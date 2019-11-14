package com.example.volleypicassolistviewsample.WithJsonArrayRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleypicassolistviewsample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();
    ListView listView;
    CustomListAdapter customAdapter;
    ArrayList<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        dataList = new ArrayList<>();
        customAdapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(customAdapter);

        fetchData();
    }

    /*
     *https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/androidweb.php
     *
     * [{"id":"1","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/1.jpeg","views":"43","download":"16"},
     * {"id":"2","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/2.jpeg","views":"37","download":"11"},
     * {"id":"3","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/3.jpeg","views":"36","download":"7"},
     * {"id":"6","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/6.jpeg","views":"31","download":"0"},
     * {"id":"7","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/7.jpeg","views":"23","download":"0"},
     * {"id":"8","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/8.jpeg","views":"23","download":"0"},
     * {"id":"9","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/9.jpeg","views":"30","download":"0"},
     * {"id":"10","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/10.jpeg","views":"27","download":"0"},
     * {"id":"11","imageurl":"https:\/\/uniqueandrocode.000webhostapp.com\/hiren\/androidtutorial\/images\/11.jpeg","views":"20","download":"0"}]
     * * */
    private void fetchData(){
        String url = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/androidweb.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.d(TAG, response.toString());

                        for(int i=0; i< response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String downloadCount = jsonObject.getString("download");
                                String imageUrl = jsonObject.getString("imageurl");
                                String viewCount = jsonObject.getString("views");

                                Data data = new Data(imageUrl, downloadCount, viewCount);
                                dataList.add(data);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        customAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    /*
    * **********Object Request sample***************
    *
 -----------------------------------------
    * {
    "name" : "Ravi Tamada",
    "email" : "ravi8x@gmail.com",
    "phone" : {
        "home" : "08947 000000",
        "mobile" : "9999999999"
    }
}
--------------------------------------
    *
    * private void makeJsonObjectRequest() {

    showpDialog();

    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
            urlJsonObj, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    try {
                        // Parsing json object response
                        // response will be a json object
                        String name = response.getString("name");
                        String email = response.getString("email");
                        JSONObject phone = response.getJSONObject("phone");
                        String home = phone.getString("home");
                        String mobile = phone.getString("mobile");

                        jsonResponse = "";
                        jsonResponse += "Name: " + name + "\n\n";
                        jsonResponse += "Email: " + email + "\n\n";
                        jsonResponse += "Home: " + home + "\n\n";
                        jsonResponse += "Mobile: " + mobile + "\n\n";

                        txtResponse.setText(jsonResponse);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
    *
    *
    * */

}
