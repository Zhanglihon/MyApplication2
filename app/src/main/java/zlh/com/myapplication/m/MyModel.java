package zlh.com.myapplication.m;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.util.Map;

import zlh.com.myapplication.MVP.MVPInterface;
import zlh.com.myapplication.bean.ShoppingBean;
import zlh.com.myapplication.util.Okhttputil;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class MyModel implements MVPInterface.MyModelInterface {
    MyCallBack myCallBack;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int type=msg.arg1;
            switch (type){
                case 1:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    ShoppingBean shoppingBean=gson.fromJson(json,ShoppingBean.class);
                    myCallBack.success(shoppingBean);
                    break;
            }
        }
    };

    @Override
    public void toRequest(String url, Map<String, String> map, int type, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        Okhttputil.getIntener().doget(url,null,1,handler);
    }


    public interface MyCallBack{
        public void success(Object obj);
    }
}
