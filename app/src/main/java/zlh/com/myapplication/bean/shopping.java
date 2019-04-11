package zlh.com.myapplication.bean;

import java.util.List;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class shopping {
    public List<Rxxp>rxxp;
    public List<Pzsh>pzsh;
    public List<Mlss>mlss;

    public shopping(List<Rxxp> rxxp, List<Pzsh> pzsh, List<Mlss> mlss) {
        this.rxxp = rxxp;
        this.pzsh = pzsh;
        this.mlss = mlss;
    }

    public List<Rxxp> getRxxp() {
        return rxxp;
    }

    public void setRxxp(List<Rxxp> rxxp) {
        this.rxxp = rxxp;
    }

    public List<Pzsh> getPzsh() {
        return pzsh;
    }

    public void setPzsh(List<Pzsh> pzsh) {
        this.pzsh = pzsh;
    }

    public List<Mlss> getMlss() {
        return mlss;
    }

    public void setMlss(List<Mlss> mlss) {
        this.mlss = mlss;
    }

    @Override
    public String toString() {
        return "shopping{" +
                "rxxp=" + rxxp +
                ", pzsh=" + pzsh +
                ", mlss=" + mlss +
                '}';
    }
}
