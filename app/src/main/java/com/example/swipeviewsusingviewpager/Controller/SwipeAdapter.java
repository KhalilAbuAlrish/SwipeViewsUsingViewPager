package com.example.swipeviewsusingviewpager.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.swipeviewsusingviewpager.Module.SwipeModule;
import com.example.swipeviewsusingviewpager.R;

import java.util.List;

public class SwipeAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<SwipeModule> listItem;

    public SwipeAdapter(Context context, LayoutInflater layoutInflater, List<SwipeModule> listItem) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_item,container,false);

        ImageView imageItem;
        TextView titleItem,descItem;

        imageItem=view.findViewById(R.id.image_item);
        titleItem=view.findViewById(R.id.title_item);
        descItem=view.findViewById(R.id.desc_item);


        SwipeModule swipeModule=listItem.get(position);
        imageItem.setImageResource(swipeModule.getImageItem());
        titleItem.setText(swipeModule.getTitleItem());
        descItem.setText(swipeModule.getDescItem());


        container.addView(view);

        return view;
    }




    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((View)object);


    }
}
