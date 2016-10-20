package com.example.counter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;


public class MainActivity extends AppCompatActivity {
    String str1="";
    String str2="";
    String str3="";
    int n=0;            //用于结果与后续运算
    int m=0;            //判断运算符和小数点多输入没
    int a=0;            //判断转换二进制还是十六进制

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click();
    }

    public void click(){                          //各键的输入
        final TextView txt=(TextView)findViewById(R.id.text);
        int[] buttons = new int[] {
                R.id.button00, R.id.button01, R.id.button02, R.id.button03,
                R.id.button04, R.id.button05, R.id.button06, R.id.button07,
                R.id.button08, R.id.button09, R.id.button19,
                R.id.jia, R.id.jian, R.id.cheng, R.id.chu};
        for (int i = 0; i < buttons.length; i++){
            Button temp = (Button) findViewById(buttons[i]);
            temp.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(n==1){
                                str1=new String(str2);
                                n=0;
                            }
                            char a=((Button) v).getText().charAt(0);
                            if(a=='+'||a=='-'||a=='÷' ||a=='×'||a=='.'){
                                m++;
                            }else {
                                m=0;
                            }
                            if(m<2){
                                str1 = str1+String.valueOf(((Button) v).getText());
                                txt.setText(str1);
                            }
                            else{
                                str1=str1.substring(0,str1.length()-1)+a;
                                txt.setText(str1);
                            }
                        }
                    });
        }
    }

    public void deng(View view) {
        TextView txt=(TextView)findViewById(R.id.text);
        TextView txt1=(TextView)findViewById(R.id.text1);
        String text = (String)txt.getText();                        //字符串转换
        List<String> numList = new ArrayList<>();
        Double sum;
        int splitIndex = 0;
        for(int i=1;i<text.length();i++){
            char c = text.charAt(i);                                 //字符串中提取字符
            char a = text.charAt(i-1);
            if(c=='-'&&a != '+'&&a != '-'&&a!='×'&&a!='÷'){         //判断是否为负号
                c='—';
            }
            if(c == '+'||c == '—'||c=='×'||c=='÷'){
                numList.add(text.substring(splitIndex, i));
                numList.add(c+"");
                splitIndex = i+1;
            }
        }
        // 因为使用符号做判断，增加前一位和符号，所以最后一位数字不会在循环里处理
        numList.add(text.substring(splitIndex, text.length()));

        // 先做乘除计算
        List<String> list = new ArrayList<>();
        Double temp = null; // 用于做乘除计算临时变量
        for(int i=1;i<numList.size();i+=2){ // 这里只循环运算符号
            if("+".equals(numList.get(i))||"—".equals(numList.get(i))){
                if(null != temp){ // 存在临时变量，说明前面进行过乘除计算
                    list.add(temp.toString());
                    temp = null;
                } else {
                    list.add(numList.get(i-1));
                }
                list.add(numList.get(i)); // 把符号加进去
                if(i==numList.size()-2) { // 处理到最后时遇到直接处理
                    list.add(numList.get(i+1));
                }
            }else if("×".equals(numList.get(i))){
                if(null == temp){
                    temp = Double.parseDouble(numList.get(i-1)) * Double.parseDouble(numList.get(i+1));
                }else{
                    temp = temp * Double.parseDouble(numList.get(i+1));
                }
                if(i==numList.size()-2) { // 处理到最后时遇到直接处理
                    list.add(temp.toString());
                    temp = null;
                }
            }else if("÷".equals(numList.get(i))){
                if(null == temp){
                    temp = Double.parseDouble(numList.get(i-1)) / Double.parseDouble(numList.get(i+1));
                }else{
                    temp = temp / Double.parseDouble(numList.get(i+1));
                }
                if(i==numList.size()-2) { // 处理到最后时遇到直接处理
                    list.add(temp.toString());
                    temp = null;
                }
            }
        }
        // 再做加减计算                                               // 第一位不会在循环里处理
        sum = Double.parseDouble(String.valueOf(list.get(0)));
        for(int i=1;i<list.size();i+=2){                // 这里只循环运算符号
            if("+".equals(list.get(i))){
                sum +=  Double.parseDouble(list.get(i+1));
            }else if("—".equals(list.get(i))){
                sum -=  Double.parseDouble(list.get(i+1));
            }
        }
        str2=String.valueOf(sum);
        if(str2.length()>9){
            str2=str2.substring(0,9);
        }else if((int)Double.parseDouble(str2)==Double.parseDouble(str2)){
            str2=String.valueOf((int)Double.parseDouble(str2));
        }
        txt.setText(str2);
        str3=str1;
        txt1.setText(str3);
        n=1;
        str1= str2;
    }

    public void qingchu(View view) {
        final TextView txt=(TextView)findViewById(R.id.text);
        final TextView txt1=(TextView)findViewById(R.id.text1);
        str1="";str2="";str3="";
        txt.setText(str1);
        txt1.setText(str3);
        a=0;
    }

    public void tuige(View view) {
        final TextView txt=(TextView)findViewById(R.id.text);
        final TextView txt1=(TextView)findViewById(R.id.text1);
        if(txt.getText().equals("")&& Objects.equals(str3, "")) {
            qingchu(view);
        }
        else if(!(Objects.equals(str3, ""))&&txt.getText().equals("")){
            str1=str3;
            str3="";
            txt.setText(str1);
            txt1.setText(str3);
        }else{
            str1 = str1.substring(0, str1.length() - 1);
            txt.setText(str1);
        }
    }

    public void transform(View view) {
        String str="";
        char[] s=new char[100];
        int i=0;int temp;int jinzhi;  //进制数
        final TextView txt=(TextView)findViewById(R.id.text);
        a=a%3;
        if(m==0&&a<2) {
            if(a==0){
                jinzhi=2;
            }
            else{
                jinzhi=16;
            }
            double t = Double.parseDouble(str1);
            int in=(int)t;          //整数部分
            double de=t-in;         //小数部分
            while(in!=0){
                temp=in%jinzhi;
                in=in/jinzhi;
                if(temp>=10){
                    s[i]=(char)(temp+55);
                }else{
                    s[i]=String.valueOf(temp).charAt(0);
                }
                i++;
            }
            for(i--;i>=0;i--){
                str+=s[i];
                System.out.print(s[i]);
            }
            i=0;
            if(de!=0.0){
                str+=".";
                while(de!=0.0){
                    temp=((int)(de*jinzhi));
                    if(temp>=10){
                        s[i]=(char)(temp+55);
                    }else{
                        s[i]=String.valueOf(temp).charAt(0);                //整数转换字符
                    }
                    str+=s[i];
                    de=(de*jinzhi)-temp;
                }
            }
            if(str.length()>9)
                txt.setText(str.substring(0,9));
            else
                txt.setText(str);
            a++;
        }else if(m==0&&a==2){
            txt.setText(str1);
            a++;
        }
    }
}


