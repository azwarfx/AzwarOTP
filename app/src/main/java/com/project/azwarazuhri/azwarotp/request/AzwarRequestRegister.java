package com.project.azwarazuhri.azwarotp.request;

import com.project.azwarazuhri.azwarotp.model.Users;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by azwarazuhri on 12/7/17.
 */

public class AzwarRequestRegister {


    public void tesData(){
        Users users = new Users();
        users.setMsisdn("12345678");
        users.setUsername("azwarazuhri");
        users.setPasword("warrior95");
        EventBus.getDefault().post(users);
    }
}
