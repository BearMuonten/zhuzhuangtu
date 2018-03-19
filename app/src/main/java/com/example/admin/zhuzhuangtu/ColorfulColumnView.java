package com.example.admin.zhuzhuangtu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * 熊峰
 * 彩色柱状图
 * Created by admin on 2017/12/26.
 *
 */

public class ColorfulColumnView extends View {

    private Paint paintGreen,paintBlue,paintYellow,paintOrage,paintRed,paintText;
    private List<PjModel> listPj;
    private float bottomHeigt=60;
    private float topHeight=60;
    private float viewWidth,viewHeight;
    private float cloumDrawHeight;
    private Paint[] paints;
    private float textsize=34;

    public ColorfulColumnView(Context context) {
        super(context);
        init();
    }

    public ColorfulColumnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorfulColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        paintGreen=new Paint();
        paintGreen.setStyle(Paint.Style.FILL);
        paintGreen.setStrokeWidth(1);
        paintGreen.setColor(Color.parseColor("#07B351"));

        paintBlue=new Paint();
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setStrokeWidth(1);
        paintBlue.setColor(Color.parseColor("#3D74E9"));

        paintYellow=new Paint();
        paintYellow.setStyle(Paint.Style.FILL);
        paintYellow.setStrokeWidth(1);
        paintYellow.setColor(Color.parseColor("#FF9320"));

        paintOrage=new Paint();
        paintOrage.setStyle(Paint.Style.FILL);
        paintOrage.setStrokeWidth(1);
        paintOrage.setColor(Color.parseColor("#FF511D"));

        paintRed=new Paint();
        paintRed.setStyle(Paint.Style.FILL);
        paintRed.setStrokeWidth(1);
        paintRed.setColor(Color.parseColor("#FA3741"));

        paintText=new Paint();
        paintText.setStyle(Paint.Style.FILL);
        paintText.setStrokeWidth(1);
        paintText.setColor(Color.parseColor("#7A7A7A"));
        paintText.setTextSize(textsize);

        paints=new Paint[]{paintGreen,paintBlue,paintYellow,paintOrage,paintRed};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewHeight=getHeight();
        viewWidth=getWidth();
        cloumDrawHeight=viewHeight-bottomHeigt-topHeight;


        drawColumn(canvas);

        drawText(canvas);
    }

    /**
     * 画柱状图
     * @param canvas
     */
    private void drawColumn(Canvas canvas){
        if(listPj!=null) {
            float max=getMax(listPj);
            float spaceVetical=cloumDrawHeight/max;
            float x,y;


            for (int i = 0; i < listPj.size(); i++) {
                x=16.0f/197.0f*viewWidth+37.0f/197.0f*viewWidth*i;
                y=cloumDrawHeight-spaceVetical*listPj.get(i).getRange()+topHeight;
//                x=16.0f/197.0f*viewWidth+20.0f/197.0f*viewWidth*i;
//                y=cloumDrawHeight-spaceVetical*listPj.get(i).getRange()+topHeight;
                canvas.drawRect(x,y,x+17.0f/197.0f*viewWidth,cloumDrawHeight+topHeight,paints[i]);
            }
        }
    }

    /**
     * 画字
     * @param canvas
     */
    private void drawText(Canvas canvas){
        float x,y;
        float max=getMax(listPj);
        float spaceVetical=cloumDrawHeight/max;
        float cloumWidth=17.0f/197.0f*viewWidth;
        for (int i=0;i<listPj.size();i++){
            x=16.0f/197.0f*viewWidth+37.0f/197.0f*viewWidth*i;
            y=cloumDrawHeight-spaceVetical*listPj.get(i).getRange()+topHeight;

            canvas.drawText(listPj.get(i).getTag(),x+(cloumWidth-paintText.measureText(listPj.get(i).getTag()))/2,viewHeight-2,paintText);

            canvas.drawText(listPj.get(i).getRange()+"",x+(cloumWidth-paintText.measureText(listPj.get(i).getRange()+""))/2,y-20,paintText);
        }
    }



    public void setData(List<PjModel> list){
        listPj=list;
        invalidate();
    }


    private float getMax(List<PjModel> list){

        float max=0;
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                if (max<list.get(i).range){
                    max=list.get(i).range;
                }
            }
        }
        return  max;
    }
}
