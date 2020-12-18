package com.example.day03_2.utils.net;

import android.annotation.SuppressLint;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements NetWorkInterface{

    private final ApiService apiService;

    public RetrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLContract.BASEURL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);
    }

    private static RetrofitUtils retrofitUtils;

    public static RetrofitUtils getInstance() {
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;


    }

    @Override
    public <T> void get(String url, ResultCallback<T> callback) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //获取参数化类型
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            //获取参数化类型的实际类型
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, t);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, ResultCallback<T> callback) {
        apiService.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //获取参数化类型
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            //获取参数化类型的实际类型
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, t);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, ResultCallback<T> callback) {
        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //获取参数化类型
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            //获取参数化类型的实际类型
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, t);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
