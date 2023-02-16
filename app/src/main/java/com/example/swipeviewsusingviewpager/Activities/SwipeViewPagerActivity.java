package com.example.swipeviewsusingviewpager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.swipeviewsusingviewpager.Controller.SwipeAdapter;
import com.example.swipeviewsusingviewpager.Module.SwipeModule;
import com.example.swipeviewsusingviewpager.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeViewPagerActivity extends AppCompatActivity {


    ViewPager viewPager;
    SwipeAdapter swipeAdapter;
    List<SwipeModule> listSwipe;

    Integer[]colors=null;
    ArgbEvaluator argbEvaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view_pager);


        viewPager=findViewById(R.id.view_pager);
        argbEvaluator=new ArgbEvaluator();
        listSwipe=new ArrayList<>();

        listSwipe.add(new SwipeModule(R.drawable.image_1,"Green","Green is the color between cyan and yellow on the visible spectrum. It is evoked by light which has a dominant wavelength of roughly 495–570 nm."));
        listSwipe.add(new SwipeModule(R.drawable.image_2,"Orange","Orange is the colour between yellow and red on the spectrum of visible light. Human eyes perceive orange when observing light with a dominant wavelength between roughly 585 and 620 nanometres."));
        listSwipe.add(new SwipeModule(R.drawable.image_3,"Red","Red is the color at the long wavelength end of the visible spectrum of light, next to orange and opposite violet."));
        listSwipe.add(new SwipeModule(R.drawable.image_4,"blue","Blue is one of the three primary colours in the RYB colour model (traditional colour theory), as well as in the RGB (additive) colour model."));


        swipeAdapter=new SwipeAdapter(SwipeViewPagerActivity.this,getLayoutInflater(),listSwipe);
        viewPager.setAdapter(swipeAdapter);
        viewPager.setPadding(130,0,130,0);

        Integer[]tempColor={

                getResources().getColor(  R.color.color1)
                ,getResources().getColor(R.color.color2)
                ,getResources().getColor(R.color.color3)
                ,getResources().getColor(R.color.color4)
        };

        colors=tempColor;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                if(position< (swipeAdapter.getCount()-1) && position<(colors.length-1)){

                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset
                                    ,colors[position]
                                    ,colors[position+1])

                    );

                }else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }



            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}