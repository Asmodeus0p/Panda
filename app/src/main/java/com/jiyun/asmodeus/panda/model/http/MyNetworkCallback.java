package com.jiyun.asmodeus.panda.model.http;

public interface MyNetworkCallback <T>{
    void onError(String Message);
    void onSuccess(T data);
}
