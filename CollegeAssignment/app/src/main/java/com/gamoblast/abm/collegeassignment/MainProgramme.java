package com.gamoblast.abm.collegeassignment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

/**
 * Created by abm on 12/21/16.//
 * Created for College Practicals for Applied Course "Mobile Application on Android Platform"
 */
public class MainProgramme extends Activity implements GestureDetector.OnGestureListener {
    private GestureDetectorCompat gdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RelativeLayout rLayout = new RelativeLayout(this);
        TextView tv = new TextView(this);
        tv.setText("Hello World");
        tv.setTextSize(40);
        tv.setTextColor(Color.GREEN);
        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        rLayout.addView(tv,layout);
        rLayout.setBackgroundColor(Color.DKGRAY);
        setContentView(rLayout);
        this.gdc = new GestureDetectorCompat(this,this);
    }

//      Gesture Control Starts here
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Intent i = new Intent(this,MenuOptions.class);
        startActivity(i);
        finish();
        return true;
    }
    //Gesture control ends here


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}