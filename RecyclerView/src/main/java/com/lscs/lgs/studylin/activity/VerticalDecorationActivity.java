package com.lscs.lgs.studylin.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.lscs.lgs.annotationlib.ContentView;
import com.lscs.lgs.studylin.R;
import com.lscs.lgs.studylin.base.BaseRecyclerActivity;
import com.lscs.lgs.studylin.view.LinearDividerItemDecoration;


/**
 * Created by Administrator on 2018/5/24/024.
 */
@ContentView(R.layout.activity_main)
public class VerticalDecorationActivity extends BaseRecyclerActivity {

    @Override
    protected void initData() {
        super.initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new LinearDividerItemDecoration(this, LinearDividerItemDecoration.VERTICAL_LIST));
    }
}
