package com.alsc.net.api;

import com.alsc.net.bean.entity.NoticeResultEntity;
import com.alsc.net.bean.entity.PicCodeResultEntity;
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
 * 获取图片验证码
 *
 */

public class PicCodeApi extends BaseApi {

    public PicCodeApi(HttpOnNextListener<PicCodeResultEntity> listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setShowProgress(true);
        setCancel(true);
        setCache(false);
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24*60*60);
    }

    @Override
    public Observable getObservable(HttpService methods) {
        JSONObject result = new JSONObject();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), result.toString());
        return methods.getPicCode();

    }
}
