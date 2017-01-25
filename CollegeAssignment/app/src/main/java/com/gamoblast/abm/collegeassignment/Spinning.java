package com.gamoblast.abm.collegeassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

/**
 * Created by abm on 12/26/16.
 */
public class Spinning extends Activity implements GestureDetector.OnGestureListener,OnItemSelectedListener {

    ImageView imgv;
    Spinner spin;
    private GestureDetectorCompat gdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Parent Layout
        final RelativeLayout rSpinLayout = new RelativeLayout(this);

        //Spinner to be used
        spin = new Spinner(this);
        spin.setId(1);

        //Array that fetches and stores the contents for the Spinner.

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alphabet, android.R.layout.simple_spinner_item);

        //Setting the Spinner Viewing Layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the adapter to the Spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        spin.setSelection(0);

        //Image module that would show images acc. to the change in Spinner value
        imgv = new ImageView(this);

        //Layout for the Image View module
        RelativeLayout.LayoutParams spinlayout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        spinlayout.addRule(RelativeLayout.BELOW,spin.getId());
        spinlayout.setMargins(0,30,0,0);

        //Adding Child Views to the Parent Layout
        rSpinLayout.addView(spin);
        rSpinLayout.addView(imgv,spinlayout);

        //Setting the Content to be Viewed(the UI)
        setContentView(rSpinLayout);
        this.gdc = new GestureDetectorCompat(this,this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (i) {
            case 1:imgv.setImageResource(R.drawable.a); break;
            case 2:imgv.setImageResource(R.drawable.b); break;
            case 3:imgv.setImageResource(R.drawable.c); break;
            case 4:imgv.setImageResource(R.drawable.d); break;
            case 5:imgv.setImageResource(R.drawable.e); break;
            case 6:imgv.setImageResource(R.drawable.f); break;
            default:imgv.setImageResource(R.drawable.nope);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Not Required but needed to be here, because we are implementing an interface in a normal class (not abstract)
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
