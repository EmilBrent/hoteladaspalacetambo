package com.example.alumno.hoteladaspalace.Models;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.alumno.hoteladaspalace.MenuActivity;
import com.example.alumno.hoteladaspalace.helpers.QueueUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Queue;

public class Category {
    public int id;
    public  String name;
    public Category(int _id,String _name){
        this.id= _id;
        this.name= _name;
    }

    public void sync(QueueUtils.QueueObject o,final MenuActivity _interface ){
        String url="http://i1620750.alwaysdata.net/users.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray categories = response.getJSONArray("data");
                            _interface.showNCategories.length();
                        } catch (Exception e){

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
    }

}
