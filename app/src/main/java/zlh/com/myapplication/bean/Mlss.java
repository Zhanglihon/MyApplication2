package zlh.com.myapplication.bean;

import java.util.List;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class Mlss {
    public List<shop>commodityList;

    public Mlss(List<shop> commodityList) {
        this.commodityList = commodityList;
    }

    public List<shop> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<shop> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "Mlss{" +
                "commodityList=" + commodityList +
                '}';
    }
}
