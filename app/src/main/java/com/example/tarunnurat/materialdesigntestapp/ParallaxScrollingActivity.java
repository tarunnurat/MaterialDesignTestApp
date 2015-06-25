package com.example.tarunnurat.materialdesigntestapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.nirhart.parallaxscroll.views.ParallaxScrollView;


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
        final int displayHeight = displaymetrics.heightPixels;

        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }

        ImageView second_pic_iv = (ImageView)findViewById(R.id.second_pic_iv);
        second_pic_iv.getLayoutParams().height = (int) (1.75 * displayHeight) - actionBarHeight;
        second_pic_iv.setLayoutParams(second_pic_iv.getLayoutParams());
        /*
        View tv_ll = findViewById(R.id.toolbar_bottom_rl);
        tv_ll.getLayoutParams().height = (int) (2.5 * displayHeight);
        tv_ll.setLayoutParams(tv_ll.getLayoutParams());

        Toast.makeText(this, "height: " + displayHeight, Toast.LENGTH_LONG).show();





        // setting second pic behind action bar.
        LinearLayout.LayoutParams secondPicIvParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //LinearLayout.LayoutParams toolBarBottomParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //secondPicIvParams.topMargin = -1 * (int) (displayHeight - (1.5 * actionBarHeight));
        //toolBarBottomParams.topMargin = (int) (displayHeight - (1.5 * actionBarHeight));

        RelativeLayout bottomToolBarLayout = (RelativeLayout) findViewById(R.id.toolbar_bottom_rl);
        //bottomToolBarLayout.setLayoutParams(toolBarBottomParams);
        secondPicIvParams.topMargin = -200;
        second_pic_iv.setLayoutParams(secondPicIvParams);




        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        getLayoutInflater().inflate(R.layout.test, ll);
        */

        final ParallaxScrollView pv = (ParallaxScrollView)findViewById(R.id.ps);
        pv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {

            @Override
            public void onScrollChanged() {

                int scrollY = pv.getScrollY(); //for verticalScrollView
                //DO SOMETHING WITH THE SCROLL COORDINATES
                if (scrollY > 555) {
                    ImageView second_pic_iv = (ImageView) findViewById(R.id.second_pic_iv);
                    second_pic_iv.setPadding(0, 0, 0, scrollY - 555);
                    ImageView iv = (ImageView) findViewById(R.id.iv);
                    iv.getLayoutParams().height = 300;
                    iv.setLayoutParams(iv.getLayoutParams());
                    //Log.d("PSActivity", "height: " + scrollY);
                }

                /*
                */

            }
        });

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
