package com.fanhl.sample;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * https://github.com/dyguests/CoverFlowHelper
 * <p>
 * Created by fanhl on 2017/2/15.
 */
public class CoverFlowHelper {
    public static final String TAG = CoverFlowHelper.class.getSimpleName();
    public static final float POSITION_THRESHOLD = 0.4f;
    public static final float MAX_SCALE = 1f;
    private final ViewPager viewPager;

    public static CoverFlowHelper setup(ViewPager viewPager) {
        return new CoverFlowHelper(viewPager);
    }

    private CoverFlowHelper(ViewPager viewPager) {
        this.viewPager = viewPager;
        init();
    }

    private void init() {
        viewPager.setOffscreenPageLimit(4);
        //左右缩进合适的值
        int marginPixels = -viewPager.getContext().getResources().getDisplayMetrics().widthPixels *2/ 3;
        Log.d(TAG, "marginPixels:" + marginPixels);
        viewPager.setPageMargin(marginPixels);
        //中间大，两边大小渐变的动画变化，最大1.4倍
        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override public void transformPage(View page, float position) {
                Log.d(TAG, "page:" + page + " position:" + position);
                if (position < -1) {
                    //This page is way off-screen to the left
                } else if (position <= 1) {
                    if (position < 0) {
                        if (position < -POSITION_THRESHOLD) {
                            position = -POSITION_THRESHOLD;
                        }
                        page.setScaleX(MAX_SCALE + position);
                        page.setScaleY(MAX_SCALE + position);
                        page.setRotation(30 * position);
                    } else {
                        if (position > POSITION_THRESHOLD) {
                            position = POSITION_THRESHOLD;
                        }
                        page.setScaleX(MAX_SCALE - position);
                        page.setScaleY(MAX_SCALE - position);
                        page.setRotation(30 * position);
                    }
                } else {
                    //This page is way off-screen to the right
                }
            }
        });
    }
}
