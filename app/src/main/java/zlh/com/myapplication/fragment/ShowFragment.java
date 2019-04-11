package zlh.com.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import zlh.com.myapplication.MVP.MVPInterface;
import zlh.com.myapplication.R;
import zlh.com.myapplication.adapter.RxAdapter;
import zlh.com.myapplication.bean.ShoppingBean;
import zlh.com.myapplication.p.MyPresenter;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class ShowFragment extends Fragment implements MVPInterface.MyViewInterface {
    MVPInterface.MyPresenterInterface myPresenterInterface;
    private Banner my_banner;
    private RecyclerView recycler_view;
    List<String>list=new ArrayList<>();
    List<ShoppingBean>slist=new ArrayList<ShoppingBean>();
    private RxAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.showfragment_layout,container,false);
        my_banner = view.findViewById(R.id.my_banner);
        recycler_view = view.findViewById(R.id.recycler_view);
        myPresenterInterface=new MyPresenter(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.add("http://172.17.8.100/images/small/banner/cj.png");
        list.add("http://172.17.8.100/images/small/banner/hzp.png");
        list.add("http://172.17.8.100/images/small/banner/lyq.png");
        list.add("http://172.17.8.100/images/small/banner/px.png");
        list.add("http://172.17.8.100/images/small/banner/wy.png");
        my_banner.isAutoPlay(true).setDelayTime(4000).setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        //获取布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new RxAdapter(getActivity(),slist);
        //设置适配器
        recycler_view.setAdapter(adapter);
        myPresenterInterface.toModel();
    }

    @Override
    public void display(List<ShoppingBean>mlist) {
        slist.addAll(mlist);
        adapter.notifyDataSetChanged();
    }
}
