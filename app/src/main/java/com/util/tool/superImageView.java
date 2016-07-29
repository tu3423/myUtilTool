package com.util.tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.ce_ztzheng.myutiltool.R;

/**
 * Created by ce-ztzheng on 2016/4/19.
 * 自定义一个view,有动画功能,播放几张图片
 */
public class superImageView extends ImageView {
    public superImageView(Context context, AttributeSet attrs) {

        this(context, attrs,0);

    }

    Bitmap bitmap;
    android.widget.ImageView iv;

    public superImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
 //   View image=    LayoutInflater.from(context).inflate(R.layout.title, this);
       // iv= (android.widget.ImageView) findViewById(R.id.imageView2);
        TypedArray typearray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.imageview, defStyleAttr, 0);
        Drawable drawable = typearray.getDrawable(R.styleable.imageview_src1);
        bitmap = ((BitmapDrawable) drawable).getBitmap();
      //  iv.setImageResource(R.drawable.bed_bell);
       // setWillNotDraw(false);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasueSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasueSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasueSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasueSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            System.out.println("EXACTLY width:" + widthSize);
            width = widthSize;
        } else {
            width = bitmap.getWidth();
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            System.out.println("EXACTLY hight:" + heightSize);
            height = heightSize;
        } else {
            height = bitmap.getHeight();
        }
        setMeasuredDimension(width, height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("ondraw");
            canvas.drawText("hello world",getWidth()/2,getHeight()-20,new Paint());
        //canvas.drawBitmap(bitmap,20,20,null);

    }
}
