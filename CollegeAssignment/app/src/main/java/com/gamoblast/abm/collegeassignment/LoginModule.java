package com.gamoblast.abm.collegeassignment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.util.TypedValue;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

/**
 * Created by abm on 12/22/16. : Login Module
 */
public class LoginModule extends Activity implements GestureDetector.OnGestureListener{

    EditText mUsername, mPassword;
    Button Loginbutton;
    String usr,pwd;
    Toast mToast;
    private GestureDetectorCompat gdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the usr and pwd
        usr = "GoneGirl";
        pwd = "BenAffleck";

        //Setting a Toast
        mToast = new Toast(this);

        //Parent Layout
        final RelativeLayout rLoginLayout = new RelativeLayout(this);

        //Text to edit
        //Username Field
        mUsername = new EditText(this);
        mUsername.setId(1);
        mUsername.setHint("Username");
        mUsername.setHintTextColor(Color.DKGRAY);
        mUsername.setSingleLine();

        //Password Field
        mPassword = new EditText(this);
        mPassword.setId(2);
        mPassword.setHint("Password");
        mPassword.setHintTextColor(Color.DKGRAY);
        mPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);


        //Button
        Loginbutton = new Button(this);
        Loginbutton.setText("Log In");
        Loginbutton.setId(3);

        //Layout Parameters and Rules
        RelativeLayout.LayoutParams usernamelayout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        usernamelayout.addRule(RelativeLayout.ABOVE, mPassword.getId());
        usernamelayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernamelayout.setMargins(0,0,0,30);

        RelativeLayout.LayoutParams passwordlayout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        passwordlayout.addRule(RelativeLayout.ABOVE, Loginbutton.getId());
        passwordlayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        passwordlayout.setMargins(0,0,0,30);

        RelativeLayout.LayoutParams Loginlayout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Loginlayout.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        //Adding Child Views to the Parent Layout
        rLoginLayout.addView(mUsername,usernamelayout);
        rLoginLayout.addView(mPassword,passwordlayout);
        rLoginLayout.addView(Loginbutton,Loginlayout);

        //Changing the Screen DIP into pixels
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300,r.getDisplayMetrics());

        //Managing the width of text input in pixel
        mUsername.setWidth(px);
        mPassword.setWidth(px);


        //Changing Background color from Default Black to White
        rLoginLayout.setBackgroundColor(Color.DKGRAY);

        //Setting the all the above Content to be visible
        setContentView(rLoginLayout);

        //The Action On clicking of the button Login
        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usr.equals(mUsername.getText().toString()) && pwd.equals(mPassword.getText().toString()))
                    mToast.makeText(view.getContext(),"Login Success",Toast.LENGTH_SHORT).show();
                else mToast.makeText(view.getContext(),"Wrong Username/Password",Toast.LENGTH_SHORT).show();
            }
        });
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
        Intent i = new Intent(this,Spinning.class);
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
