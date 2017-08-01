package com.fjw.myapp.network;

import com.fjw.myapp.model.LoginModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 范佳伟 on 2017/7/25.
 */

public interface RequestServices {
    /**
     * 登录接口
     * @return
     */
    @GET("basil2style")
    Call<LoginModel> loginRequest();

    /**
     * 注册接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> registerRequest();

    /**
     * 短信接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> sendSMSRequest();

    /**
     * 相框故事接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> farmeStoryRequest();

    /**
     * 最新图片接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> newPicRequest();

    /**
     * 精选图片接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> choicePicRequest();

    /**
     * 热门搜索图片接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> hotSearchPicRequest();

    /**
     * 搜索图片接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> searchPicRequest();

    /**
     * 话题列表接口
     * @return
     */
    @GET("basil2style")
    Call<ResponseBody> topicListRequest();



    @GET("basil2style")
    Call<ResponseBody> addDeviceRequest();
}
