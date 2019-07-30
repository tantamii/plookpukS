package com.example.plookpuks;

import android.app.Activity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MysqlConnect {

    private final Activity main;
    private List<String> list;
    public  String url;

    public MysqlConnect(Activity main) {
        this.main = main;
    }

    public List<String> getData()
    {
        url = "http://b28da766.ngrok.io/get_post.php?status=1";
        RequestQueue queue = Volley.newRequestQueue(main);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
                Toast.makeText(main, list.get(0), Toast.LENGTH_LONG).show();
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(main, "Error", Toast.LENGTH_LONG).show();

                        //Toast.makeText(main, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }


        );
        RequestQueue requestQueue= Volley.newRequestQueue(main.getApplicationContext());
        requestQueue.add(stringRequest);

        return list;
    }


    private void showJSON(String response)
    {
        String comment = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            for(int i=0;i<result.length();i++)
            {
                JSONObject callData = result.getJSONObject(i);
                comment = callData.getString("comment");
                list.add(comment);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
