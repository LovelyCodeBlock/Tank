package com.gpnu.paperwings.tank;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by paperwings on 2017/9/19.
 */

public class TankView extends View{
    public float currentX = 200;
    public  float currentY = 200;
    private int direction;
    public  int step = 0;
    public  final  int size = 4;


    public TankView(Context context)
    {
        super(context);
    }
    public  TankView(Context context, AttributeSet set){
        super(context,set);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        switch (direction) {
            case 0: {        //头向右
                paint.setColor(Color.RED);
                canvas.drawRect(currentX, currentY - 15, currentX + 100, currentY + 15, paint);// 长方形
                paint.setColor(Color.BLACK);
                canvas.drawCircle(currentX, currentY, 50, paint);

            };break;
            case 1: {
                //头向左
                paint.setColor(Color.RED);
                canvas.drawRect(currentX - 100, currentY - 15, currentX, currentY + 15, paint);// 长方形
                paint.setColor(Color.BLACK);
                canvas.drawCircle(currentX, currentY, 50, paint);
            };break;
            case 2: {
                //头向下
                paint.setColor(Color.RED);
                canvas.drawRect(currentX - 15, currentY, currentX + 15, currentY + 100, paint);// 长方形
                paint.setColor(Color.BLACK);
                canvas.drawCircle(currentX, currentY, 50, paint);
            };break;
            case 3: {
                //头向上
                paint.setColor(Color.RED);
                canvas.drawRect(currentX - 15, currentY - 100, currentX + 15, currentY, paint);// 长方形
                paint.setColor(Color.BLACK);
                canvas.drawCircle(currentX, currentY, 50, paint);
            };break;
        }
        run();
}



    public  void  run(){
        if(step == 0){
            direction = (int)(Math.random()*4);
            step = (int)(Math.random()*21+30);
        }
        else {
            step --;
            float temp;
            switch (direction){
                case 0:{
                    if (currentX > (getWidth() - 100)){
                        step = 0;
                    }
                    else{
                        currentX+=size;
                    }

                };;break;
                case 1:{
                    if (currentX < 100){
                        step = 0;
                    }
                    else{
                        currentX-=size;
                    }
                };break;
                case 2:{
                    if (currentY > getHeight()-100 ){
                        step = 0;
                    }
                    else{
                        currentY+=size;
                    }
                };break;
                case 3:{
                    if(currentY < 100)
                    {
                        step = 0;
                    }
                    else{
                        currentY-=size;
                    }
                };break;

            }

        }
        invalidate();
    }


}
