package com.alsc.net.api;

import com.alsc.net.bean.entity.NoticeResultEntity;
import com.alsc.net.bean.entity.RegisterResultEntity;
import com.alsc.net.bean.request.RegisterRequest;
import com.alsc.net.retrofit.api.BaseApi;
import com.alsc.net.retrofit.listener.HttpOnNextListener;
import com.alsc.net.util.HttpService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * 注册
 *
 | 字段  | 类型   | 是否可选 | 描述  |
 | ----- | ------ | -------- | ----- |
 | pay_pass | String | 否       | 支付密码 |
 | email | String | 否       | 邮箱 |
 | pwd | String | 否       | 密码 |
 | code | String | 否       | 图片验证码 |
 | invite_code | String | 否       | 邀请码 |
 | captcha | String | 否       | 邮箱验证码 |

 */

public class RegisterApi extends BaseApi {

    private RegisterRequest registerRequest;

    public RegisterApi(HttpOnNextListener<RegisterResultEntity> listener, RxAppCompatActivity rxAppCompatActivity, RegisterRequest registerRequest) {
        super(listener, rxAppCompatActivity);
        this.registerRequest = registerRequest;
        setShowProgress(true);
        setCancel(true);
        setCache(false);
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24*60*60);
    }

    @Override
    public Observable getObservable(HttpService methods) {
        JSONObject result = new JSONObject();
        try {
            result.put("username", registerRequest.getUsername());
            result.put("email", registerRequest.getEmail());
            result.put("phone", registerRequest.getPhone());
            result.put("pwd", registerRequest.getPwd());
            result.put("pwd2", registerRequest.getPwd2());
            result.put("pic_code", registerRequest.getPic_code());
            result.put("invite_code", registerRequest.getInvite_code());
            result.put("captcha", registerRequest.getCaptcha());
            result.put("pay_pwd", registerRequest.getPay_pwd());
            result.put("pay_pwd2", registerRequest.getPay_pwd2());
            result.put("sid", registerRequest.getSid());
            result.put("phone_area", registerRequest.getPhone_area());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), result.toString());
        return methods.register(body);

    }
}
