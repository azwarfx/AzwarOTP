package com.project.azwarazuhri.azwarotp.request;

        import android.os.Build;
        import android.support.annotation.RequiresApi;

        import com.project.azwarazuhri.azwarotp.model.Users;

        import org.greenrobot.eventbus.EventBus;
        import org.json.JSONObject;

        import java.io.IOException;
        import okhttp3.FormBody;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;
        import okhttp3.ResponseBody;

/**
 * Created by azwarazuhri on 12/8/17.
 */

public class PostForm {

    public void run() throws Exception {
         OkHttpClient client = new OkHttpClient();
        //Users users = new Users();
        RequestBody formBody = new FormBody.Builder()
                .add("msisdn", "083873013113")
                .add("username", "azwarazuhri")
                .add("email", "azwarannas_95@yahoo.com")
                .add("password", "warrior95")
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.4.106:8080/OtpAndroidService/RegUsersServlet?")
                .post(formBody)
                .build();


        Response response = client.newCall(request).execute();
        final int code = response.code(); // can be any value
        if (code == 200) {
           // final ResponseBody body = response.body(); // body exists, I have to close it
            String str = response.body().string();
            JSONObject jsonObject = new JSONObject(str);
            Users users = new Users();
            users.setMsisdn(jsonObject.getString("username"));
            users.setUsername(jsonObject.getString("otpPassword"));
            users.setPasword(jsonObject.getString("msisdn"));
            EventBus.getDefault().post(users);
            response.body().close();
        }

    }
}
