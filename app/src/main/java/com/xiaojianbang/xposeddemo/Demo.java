package com.xiaojianbang.xposeddemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Animal{
    int AnimalInt = 400;
    public abstract void eatFunc(String value);
}

public class Demo {
    private static String Tag = "xingchen";

    private static  int staticInt = 100;
    public  int publicInt = 200;
    private int privateInt = 300;

    private static  String staticString = "static String";
    public  String publicString = "public String";
    private String privateString = "private String";

    private String reflect = "reflect"; //reflect = 反射

    public Demo(){
        this("xingchen");
        Log.d(Tag, "这是构造函数的Log");
    }

    private Demo(String str){
        Log.d(Tag, "this is Demo(String) log || " + str);
    }

    public void test(){

        Log.d(Tag, "staticInt = " + staticInt);
        Log.d(Tag, "publicInt = " + publicInt);
        Log.d(Tag, "privateInt = " + privateInt);

        Log.d(Tag, "staticString = " + staticString);
        Log.d(Tag, "publicString = " + publicString);
        Log.d(Tag, "privateString = " + privateString);

        publicFunc("xingchen");
        privateFunc("xingchen");
        staticPrivateFunc("xingchen");

        String[][] strArr = new String[1][2];
        Map map = new HashMap<String, String>();
        map.put("key", "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add("listValue");

        complexParameterFunc("xingchen", strArr, map, arrayList);

        repleaceFunc();

        Inner(new Animal() {
            @Override
            public void eatFunc(String value) {
                Log.d(Tag, "这是抽象类的eatFunc方法(String value)的Log || " + value);
                Log.d(Tag, "AnimalInt =  " + AnimalInt);
            }
        }, "xingchen");

        InnerClass innerClass = new InnerClass();
        innerClass.innerFunc("xingchen");
    }

    public void publicFunc(String value){
        Log.d(Tag, "这是公有函数(String value)的Log || " + value);
    }

    private void privateFunc(String value){
        Log.d(Tag, "这是私有函数(String value)的Log || " + value);
    }

    static private void staticPrivateFunc(String value){
        Log.d(Tag, "这是静态私有函数(String value)的Log || " + value);
    }

    private void complexParameterFunc(String value, String[][] str, Map<String,String> map, ArrayList arrayList) {
        Log.d(Tag, "这是复杂参数函数(Strin value)的Log || " + value);
    }

    private void repleaceFunc(){
        Log.d(Tag, "this is repleaceFunc log");
    }

    public void Inner(Animal dog, String value){
        Log.d(Tag, "this is Inner log ||" + value);
        dog.eatFunc("xingchen");
    }

    private void refl(){
        Log.d(Tag,"这是反射的publicInt " + this.publicInt);
    }

    //内部类
    class InnerClass{
        public int innerPublicInt = 1000;
        private int innerPrivateInt = 2000;
        public InnerClass(){
            Log.d(Tag, "这是内部类构造函数的Log");
        }
        public void innerFunc(String value){
            Log.d(Tag, "这是内部类的innerFunc方法(String value)的Log || " + value);
            Log.d(Tag, "innerPublicInt = " + innerPublicInt);
            Log.d(Tag, "innerPrivateInt = " + innerPrivateInt);
        }
    }
}