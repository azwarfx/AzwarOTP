package com.project.azwarazuhri.azwarotp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.azwarazuhri.azwarotp.Service.AzwarService;
import com.project.azwarazuhri.azwarotp.model.Users;
import com.project.azwarazuhri.azwarotp.request.AzwarPostUserRegister;
import com.project.azwarazuhri.azwarotp.request.AzwarRequestRegister;
import com.project.azwarazuhri.azwarotp.request.AzwarRequestRegisterResult;
import com.project.azwarazuhri.azwarotp.request.PostForm;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnDftar;
    EditText txtPassword,txtUsername,txtPhonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        btnDftar=findViewById(R.id.btn_dftar);
        txtUsername=findViewById(R.id.txt_username);
        txtPassword=findViewById(R.id.txt_password);
        txtPhonenumber=findViewById(R.id.txt_phonenumber);

        btnDftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readStaticJSON();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void readStaticJSON() throws Exception {
//        AzwarRequestRegisterResult azwarRequestRegisterResult = new AzwarRequestRegisterResult();
//        azwarRequestRegisterResult.daftar();
        PostForm postForm = new PostForm();
        postForm.run();
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Users users) {
        Toast.makeText(this,"tessss",Toast.LENGTH_LONG).show();
       // String useername=users.getUsername();
        Log.d("azwarazuhri", "Event received");

        String str = users.getUsername();
        txtUsername.setText(str);
        txtPhonenumber.setText(users.getMsisdn());
        txtPassword.setText(users.getPasword());
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

}
