package com.example.guodazhao.gridviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView)findViewById(R.id.gridView);
        GridView gv2 = (GridView)findViewById(R.id.gridView2);
        //为GridView设置适配器
        gv.setAdapter(new MyAdapter(this));
        gv2.setAdapter(new MyAdapter(this));
        //注册监听事件
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Toast.makeText(MainActivity.this, "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
    //自定义适配器
    class MyAdapter extends BaseAdapter {
        //上下文对象
        private Context context;
        //图片数组
        private Integer[] imgs = {
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
        };
        MyAdapter(Context context){
            this.context = context;
        }
        public int getCount() {
            return imgs.length;
        }

        public Object getItem(int item) {
            return item;
        }

        public long getItemId(int id) {
            return id;
        }

        //创建View方法
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(75, 75));//设置ImageView对象布局
                imageView.setAdjustViewBounds(false);//设置边界对齐
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型
                imageView.setPadding(8, 8, 8, 8);//设置间距
            }
            else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imgs[position]);//为ImageView设置图片资源
            return imageView;
        }
    }

}
