package com.example.ce_ztzheng.myutiltool;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.Future;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable r;
    private Future<?> tranPending;
    private ProgressDialog progress;
    private ArrayList<dog> dogList;
    private AnimationDrawable animationDrawable;
    private boolean isplaying = false;
    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogList = new ArrayList<>();
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bed_bell_show);
        double a=20/3f;
        double c=20/3.00;  //结果保留两位小数
        double b=(Math.round(a*100))/100.00;  //保留两位小数(四舍五入)
String TAG="zzt";
        Log.e(TAG, "onCreate:" + a);
        Log.e(TAG, "onCreate:" + c);
        Log.e(TAG, "onCreate:" + b);
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("onclick");
                findViewById(R.id.view).startAnimation(animation);
            }
        });
       /* findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("button2 onclick");
            }
        });*/
        // findViewById(R.id.imageView2).onclick
        // ImageView iv= (ImageView) findViewById(R.id.imageView);
        // animationDrawable = (AnimationDrawable) iv.getDrawable();
        // button.getDrawable()
        //  animationDrawable.stop();
       /* iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!isplaying) {
                   isplaying=true;
                   animationDrawable.start();
               }else{
                   isplaying=false;
                   animationDrawable.stop();
               }
            }
        });*/

    }

    class dog {
        String name;
        int age;

        public dog(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }


}
