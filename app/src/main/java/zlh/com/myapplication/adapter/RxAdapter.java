package zlh.com.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import zlh.com.myapplication.R;
import zlh.com.myapplication.bean.ShoppingBean;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class RxAdapter extends RecyclerView.Adapter<RxAdapter.holder> {
    public Context context;
    public List<ShoppingBean>list;

    public RxAdapter(Context context, List<ShoppingBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.rxadapter_layout,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        String price=list.get(i).getResult().get(i).rxxp.get(i).commodityList.get(i).getPrice();
        String image=list.get(i).getResult().get(i).rxxp.get(i).commodityList.get(i).getMasterPic();
        String content=list.get(i).getResult().get(i).rxxp.get(i).commodityList.get(i).getCommodityName();
        holder.text_price1.setText(price);
        holder.text_view1.setText(content);
        Glide.with(context).load(image).into(holder.image_view1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder{

        TextView text_1;
        TextView text_view1;
        TextView text_price1;
        ImageView image_view1;

        public holder(@NonNull View itemView) {
            super(itemView);
            text_1 = itemView.findViewById(R.id.text_1);
            text_view1 = itemView.findViewById(R.id.text_view1);
            text_price1 = itemView.findViewById(R.id.text_price1);
            image_view1 = itemView.findViewById(R.id.image_view1);
        }
    }
}
