package com.project.azwarazuhri.azwarotp.Service;


import android.util.Log;
import android.widget.Toast;

import com.project.azwarazuhri.azwarotp.MainActivity;
import com.project.azwarazuhri.azwarotp.model.Users;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by azwarazuhri on 12/7/17.
 */

public class AzwarService {
    //JSON https://api.myjson.com/bins/19lo1z
    private final String url="https://api.myjson.com/bins/19lo1z";

    /**
     *    private String username;
     private String pasword;
     private String msisdn;
     */
    public  void daftar(){
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("sampe sini","sampe failureeeeeeee");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try{
                    String str = response.body().string();
                    JSONObject jsonObject = new JSONObject(str);
                    Users users = new Users();
                    users.setMsisdn(jsonObject.getString("status"));
                    users.setUsername(jsonObject.getString("msisdn"));
                    users.setPasword(jsonObject.getString("otpPassword"));
                    EventBus.getDefault().post(users);
                }catch(JSONException e){
                    EventBus.getDefault().post(new Users());
                }
            }
        });
    }
}
