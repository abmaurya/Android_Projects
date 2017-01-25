package com.gamoblast.abm.collegeassignment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by abm on 12/27/16.
 */
public class MenuOptions extends Activity{
    TextView txtv;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Parent Layout
        final RelativeLayout moLayout = new RelativeLayout(this);

        txtv = new TextView(this);

        lv = new ListView(this);

        //Array that fetches and stores the contents for the ListView.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alphabet, android.R.layout.simple_expandable_list_item_1);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(mlistner);

        //Layout for the Text View module
        RelativeLayout.LayoutParams textlayout = new RelativeLayout.LayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textlayout.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        txtv.setText("Tera");
        //Adding Child Views to the Parent Layout
        moLayout.addView(txtv,textlayout);
        moLayout.addView(lv);

        moLayout.setBackgroundColor(Color.DKGRAY);

        //Setting the Content to be Viewed(the UI)
        setContentView(moLayout);
    }

    private OnItemClickListener mlistner = new OnItemClickListener(){
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            switch (arg2){
                case 0:txtv.setText(v.toString());
                case 1:txtv.setText(v.toString());
                case 2:txtv.setText(v.toString());
                case 3:txtv.setText(v.toString());
                case 4:txtv.setText(v.toString());
                case 5:txtv.setText(v.toString());
            }
        }
    };

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add("Item 1");
//        menu.add("Item 2");
//        menu.add("Item 2");
//        menu.add("Item 3");
//        menu.add("Item 4");
//        menu.add("Item 5");
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (arg2){
//            case 1:txtv.setText(Integer.toString(arg2)); return true;
//            case 2:txtv.setText(Integer.toString(arg2)); return true;
//            case 3:txtv.setText(Integer.toString(arg2)); return true;
//            case 4:txtv.setText(Integer.toString(arg2)); return true;
//            case 5:txtv.setText(Integer.toString(arg2)); return true;
//            default: return super.onOptionsItemSelected(item);
//        }
//    }


}
