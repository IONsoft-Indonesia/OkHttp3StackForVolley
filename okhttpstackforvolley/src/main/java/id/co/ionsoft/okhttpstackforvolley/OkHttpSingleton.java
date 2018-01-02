package id.co.ionsoft.okhttpstackforvolley;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpSingleton {

    private OkHttpClient mOkHttpClient;

    private static OkHttpSingleton sInstance;

    public static OkHttpSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new OkHttpSingleton();
        }
        return sInstance;
    }

    private OkHttpSingleton() {
        OkHttpClient.Builder builderOkHttp = new OkHttpClient.Builder();
        builderOkHttp.connectTimeout(20, TimeUnit.SECONDS);
        builderOkHttp.readTimeout(15, TimeUnit.SECONDS);
        builderOkHttp.writeTimeout(15, TimeUnit.SECONDS);
        builderOkHttp.addInterceptor(getInterceptor());
        mOkHttpClient = builderOkHttp.build();
        setOkHttpClient(mOkHttpClient);
    }

    private Interceptor getInterceptor() {
        return chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .build();
            return chain.proceed(newRequest);
        };
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }
}