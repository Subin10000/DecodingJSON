package com.example.decodingjson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

public class DecodingJSON extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decodeJson();
    }

    private void decodeJson() {
        try{
            String json_data="{\"data\"=>array(array(\"sid\"=>6,\"Name\"=>\"Ram\",\"address\"=>\"Btm\"),array(\"sid\"=>7,\"Name\"=>\"Hari\",\"address\"=>\"ktm\"}";
            JSONObject result=new JSONObject(json_data);
            JSONArray data=result.getJSONArray("data");
            for (int i=0;i< data.length();i++){
                JSONObject student=data.getJSONObject(i);
                int sid=student.getInt("sid");
                String name=student.getString("Name");
                String address=student.getString("address");
                Log.d("Row"+i,sid+""+name+"address");

            }
        }
        catch (Exception ex){
            Log.d("exception",ex.toString());
        }
    }
}
