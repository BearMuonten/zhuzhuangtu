package com.example.admin.zhuzhuangtu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ColorfulColumnView ccv;
    private List<PjModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ccv= (ColorfulColumnView) findViewById(R.id.ccv);

        PjModel pjModel1=new PjModel(10,"卖出");
        PjModel pjModel2=new PjModel(5,"减持");
        PjModel pjModel3=new PjModel(8,"中性");
        PjModel pjModel4=new PjModel(12,"增持");
        PjModel pjModel5=new PjModel(4,"买入");

        list=new ArrayList<>();

        list.add(pjModel1);
        list.add(pjModel2);
        list.add(pjModel3);
        list.add(pjModel4);
        list.add(pjModel5);

        ccv.setData(list);
    }
}
