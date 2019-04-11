package zlh.com.myapplication.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class Okhttputil {
    OkHttpClient okHttpClient;

    public static Okhttputil okhttputil;
    //构造方法私有化
    private Okhttputil(){
        okHttpClient=new OkHttpClient();
        okHttpClient.newBuilder().addInterceptor(new MyInterceptor()).build();
    }
    public static Okhttputil getIntener(){
        if (okhttputil==null){
            okhttputil=new Okhttputil();
        }
        return okhttputil;
    }
    //doget请求
    public void doget(String url, Map<String,String>map, final int type, final Handler handler){
        if (map!=null&&map.size()>0){
            String str="";
            StringBuilder builder=new StringBuilder();
            for(String key:map.keySet()){
                String pkey=key;
                String value=map.get(pkey);
                builder.append(pkey)
                        .append("=")
                        .append(value)
                        .append("&");
            }
            int index=str.lastIndexOf("&");
            str=str.substring(0,index);
            url=url+"?"+str;
        }
        Request request=new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
                String json=response.body().string();
                Message message=new Message();
                message.obj=json;
                message.arg1=type;
                handler.sendMessage(message);
            }
        });
    }


    public class MyInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Log.e("tag","request="+request.url());
            return response;
        }
    }
}
