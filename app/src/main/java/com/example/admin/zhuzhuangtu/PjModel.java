package com.example.admin.zhuzhuangtu;

/**
 * Created by admin on 2017/12/26.
 */

public class PjModel {
    public float range;
    public String tag;

    public PjModel(float range, String tag) {
        this.range = range;
        this.tag = tag;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
