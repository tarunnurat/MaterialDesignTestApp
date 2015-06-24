package com.example.tarunnurat.materialdesigntestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


@SuppressWarnings("deprecation")
public class ParallaxScrollingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_scrolling);

        Toolbar toolBarTop = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolBarTop);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int displayHeight = displaymetrics.heightPixels;

        ImageView second_pic_iv = (ImageView)findViewById(R.id.second_pic_iv);


        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        // setting second pic behind action bar.
        LinearLayout.LayoutParams secondPicIvParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //LinearLayout.LayoutParams toolBarBottomParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //secondPicIvParams.topMargin = -1 * (int) (displayHeight - (1.5 * actionBarHeight));
        //toolBarBottomParams.topMargin = (int) (displayHeight - (1.5 * actionBarHeight));

        RelativeLayout bottomToolBarLayout = (RelativeLayout) findViewById(R.id.toolbar_bottom_rl);
        //bottomToolBarLayout.setLayoutParams(toolBarBottomParams);
        secondPicIvParams.topMargin = -200;
        second_pic_iv.setLayoutParams(secondPicIvParams);

    }

    public static float convertPixelsToDp(float px){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parallax_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
