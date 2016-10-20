package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 秦 on 2016/10/15.
 */

public class Other {
    /*String str1="";
    String str2="";
    String str="";
    int i;
    int flag=0;     //判断运算法则
    int n=0;        //是否得出结果
    int m=0;        //判断是第一次or第二次输入数字
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt=(TextView)findViewById(R.id.text);
        int[] buttons = new int[] {
                R.id.button00, R.id.button01, R.id.button02, R.id.button03,
                R.id.button04, R.id.button05, R.id.button06, R.id.button07,
                R.id.button08, R.id.button09, R.id.button19};
        for (i = 0; i < buttons.length; i++){
            Button temp = (Button) findViewById(buttons[i]);
            temp.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(m!=0){
                                str1="";
                                m=0;
                            }
                            if(n!=0){
                                str1="";
                                n=0;
                            }
                            str1 = str1+String.valueOf(((Button) v).getText());
                            txt.setText(str+str1);
                        }
                    });
        }
    }

    public void jia(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        str=str1+String.valueOf(((Button) view).getText());
        str2=new String(str1);
        txt.setText(str);
        flag=1;m=1;
    }
    public void jian(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        str=str1+String.valueOf(((Button) view).getText());
        str2=new String(str1);
        txt.setText(str);
        flag=2;m=1;
    }
    public void cheng(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        str=str1+String.valueOf(((Button) view).getText());
        str2=new String(str1);
        txt.setText(str);
        flag=3;m=1;
    }
    public void chu(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        str=str1+String.valueOf(((Button) view).getText());
        str2=new String(str1);
        txt.setText(str);
        flag=4;m=1;
    }

    public void deng(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        double result1 = Double.parseDouble(str1);
        double result2 = Double.parseDouble(str2);
        double x=0;
        switch(flag){
            case 1:x=result2 + result1;break;
            case 2:x=result2 - result1;break;
            case 3:x=result2 * result1;break;
            case 4:
                if(result1==0) {
                    txt.setText("错误");
                    n = 1;
                    str = "";
                    str2 = "";
                    flag = 0;
                    return;
                }
                else
                    x=result2 / result1;
                break;
        }
        int y=(int)x;
        if(x==y)
            str1=String.valueOf(y);
        else {
            str1 = String.valueOf(x);
            if(str1.length()>10)
                str1=str1.substring(0,9);
        }
        txt.setText(str1);
        n=1;
        str="";
        str2="";
        flag=0;
    }

    public void qinchu(View view) {
        str="";
        str1="";
        str2="";
        flag=0;
        n=0;
        TextView txt=(TextView) this.findViewById(R.id.text);
        txt.setText(str1);
    }

    public void tuige(View view) {
        TextView txt=(TextView) this.findViewById(R.id.text);
        if(str1.length()>0){
            str1=str1.substring(0,str1.length()-1);
        }
        else if(str1.length()==0&&str.length()>0){
            str="";
            flag=0;
            str1=new String(str2);
            str2="";
            m=0;
        }
        txt.setText(str1+str);
    }*/
}
