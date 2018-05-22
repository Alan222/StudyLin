package com.lscs.lgs.myscrollview;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fram_title_bar)
    View mParent;
    @BindView(R.id.bg_toolbar)
    ImageView mBgToolbar;
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.scoll_view)
    MyScrollView mScollView;
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.share)
    ImageView mShare;
    private boolean ismeasure;
    private int mToolBarHeight;
    private int mToolBarWidth;
    private int mMeasureHeight;
    private int mTitleWidth;
    private int mTitleHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.loadUrl("https://github.com/Alan222?tab=repositories");
        initEvent();
    }

    private void initEvent() {
        mScollView.setOnMyScollViewChangeListener(new MyScrollView.OnMyScollViewChangeListener() {
            @Override
            public void onScrollChanged(int t) {

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus&&!ismeasure) {         //获取焦点并且未测量
            measure();
        }
    }

    private void measure() {
        mToolBarHeight = mParent.getHeight();
        mToolBarWidth = mParent.getWidth();
        mMeasureHeight = mBgToolbar.getHeight();
        mTitleWidth = mTitle.getWidth();
        mTitleHeight = mTitle.getHeight();
    }

    @OnClick({R.id.back, R.id.share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Toast.makeText(getApplicationContext(), "已返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(), "已分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
