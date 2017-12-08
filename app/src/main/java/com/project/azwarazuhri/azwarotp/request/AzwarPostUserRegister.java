package com.project.azwarazuhri.azwarotp.request;

import android.util.Log;

import com.project.azwarazuhri.azwarotp.model.Users;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by azwarazuhri on 12/7/17.
 */

public class AzwarPostUserRegister {
      //Users users = new Users();
//
//    String url = "http://www.zoftino.com/api/saveFavorite";

    public void register() throws IOException {
        OkHttpClient httpClient = new OkHttpClient();

//            RequestBody formBody = new FormBody.
//                    Builder().
//                    add("msisdn", "083873013113").
//                    add("username", "azwarazuhri").
//                    add("email", "azwarannas_95@yahoo.com").
//                    add("passowrd", "warrior95")
//                    .build();
        FormBody.Builder formBuilder = new FormBody.Builder();
        formBuilder.add("msisdn", "083873013113");
        formBuilder.add("username", "azwarazuhri");
        formBuilder.add("email", "azwarannas_95@yahoo.com");
        formBuilder.add("password", "warrior95");

        RequestBody formBody = formBuilder.build();

            Request request = new Request.Builder().url("192.168.4.106:8080/AndroidService/RegUserServlet?")
                    .post(formBody)
                    .build();
            Response response = httpClient.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

//        if(!response.isSuccessful()){
//               // users.setMsisdn("failed");
//                Log.v("AzwarAzuhri","Dari !sussces");
//            }
//            Log.v("AzwarAzuhri","Dari !sussces");

           // users.setMsisdn("Sukses");
          //  EventBus.getDefault().post(users);
            //assertTrue(response.isSuccessful());

    }

}
