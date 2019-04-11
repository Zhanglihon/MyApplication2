package zlh.com.myapplication.p;

import java.util.List;

import zlh.com.myapplication.MVP.MVPInterface;
import zlh.com.myapplication.bean.ShoppingBean;
import zlh.com.myapplication.m.MyModel;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class MyPresenter implements MVPInterface.MyPresenterInterface {
    MVPInterface.MyModelInterface myModelInterface;
    MVPInterface.MyViewInterface myViewInterface;

    public MyPresenter(MVPInterface.MyViewInterface myViewInterface){
        myModelInterface=new MyModel();
        this.myViewInterface=myViewInterface;
    }
    @Override
    public void toModel() {
        myModelInterface.toRequest("http://172.17.8.100/small/commodity/v1/commodityList", null, 1, new MyModel.MyCallBack() {
            @Override
            public void success(Object obj) {
                ShoppingBean shoppingBean= (ShoppingBean) obj;
                myViewInterface.display((List<ShoppingBean>) shoppingBean);
            }
        });
    }
}
