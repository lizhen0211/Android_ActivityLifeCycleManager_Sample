package com.example.lz.activitylifecyclemanagertest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityC extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Button exitByActivityStack = (Button) findViewById(R.id.exit_by_stack);
        exitByActivityStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApplicationByActivityStack();
            }
        });

        Button sendAnException = (Button) findViewById(R.id.send_an_exception);
        sendAnException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException();
            }
        });

        Button finishBAndC = (Button) findViewById(R.id.finish_B_and_C);
        finishBAndC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(ActivityB.class, ActivityC.class);
            }
        });
    }
}
