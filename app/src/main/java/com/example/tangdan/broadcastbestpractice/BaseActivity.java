package com.example.tangdan.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by tangdan on 16/8/11.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
