package com.gpnu.paperwings.tank;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    TankView tankView;
    public int screenWidth;
    public int screenHeidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tankView = (TankView) findViewById(R.id.tank_view);
    }

    //获取宽高
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            screenWidth = tankView.getWidth();
            screenHeidth = tankView.getHeight();
        }
    }



}
