package zlh.com.myapplication.MVP;

import java.util.List;
import java.util.Map;

import zlh.com.myapplication.bean.ShoppingBean;
import zlh.com.myapplication.m.MyModel;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public interface MVPInterface {
    public interface MyModelInterface{
        public void toRequest(String url, Map<String,String>map, int type, MyModel.MyCallBack myCallBack);
    }
    public interface MyPresenterInterface{
        public void toModel();
    }
    public interface MyViewInterface{
        public void display(List<ShoppingBean>mlist);
    }
}
