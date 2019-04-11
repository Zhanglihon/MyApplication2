package zlh.com.myapplication.v;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import zlh.com.myapplication.R;
import zlh.com.myapplication.adapter.MyFragmentAdapter;
import zlh.com.myapplication.fragment.MyFragment;
import zlh.com.myapplication.fragment.ShowFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private RadioGroup radio_group;
    List<Fragment>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        view_pager = findViewById(R.id.view_pager);
        radio_group = findViewById(R.id.radio_group);
        list.add(new ShowFragment());
        list.add(new MyFragment());
        //创建适配器
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        view_pager.setAdapter(adapter);
        //点击切换页面
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        view_pager.setCurrentItem(0,false);
                        break;
                    case R.id.rb2:
                        view_pager.setCurrentItem(1,false);
                        break;
                }
            }
        });
        //滑动页面
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radio_group.check(radio_group.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
