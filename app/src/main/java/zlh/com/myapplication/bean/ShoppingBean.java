package zlh.com.myapplication.bean;

import java.util.List;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class ShoppingBean {
    public List<shopping> result;

    public ShoppingBean(List<shopping> result) {
        this.result = result;
    }

    public List<shopping> getResult() {
        return result;
    }

    public void setResult(List<shopping> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ShoppingBean{" +
                "result=" + result +
                '}';
    }
}
