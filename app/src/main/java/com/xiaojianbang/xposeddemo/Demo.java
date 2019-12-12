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
    private String reflect = "fanshe";

    public Demo(){
        this("xiaojianbang");
        Log.d(Tag, "this is Demo() log");
    }

    private Demo(String str){
        Log.d(Tag, "this is Demo(String) log || " + str);
    }

    public void test(){
        Log.d(Tag, "staticInt = " + staticInt);
        Log.d(Tag, "publicInt = " + publicInt);
        Log.d(Tag, "privateInt = " + privateInt);
        publicFunc("xiaojianbang");
        Log.d(Tag, "publicInt = " + publicInt);
        Log.d(Tag, "privateInt = " + privateInt);
        privateFunc("xiaojianbang");
        staticPrivateFunc("xiaojianbang");

        String[][] strArr = new String[1][2];
        Map map = new HashMap<String, String>();
        map.put("key", "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add("listValue");
        complexParameterFunc("xiaojianbang", strArr, map, arrayList);

        repleaceFunc();
        Inner(new Animal() {
            @Override
            public void eatFunc(String value) {
                Log.d(Tag, "this is eatFunc(String value) log || " + value);
                Log.d(Tag, "AnimalInt =  " + AnimalInt);
            }
        }, "xiaojianbang");

        InnerClass innerClass = new InnerClass();
        innerClass.innerFunc("xiaojianbang");
    }

    public void publicFunc(String value){
        Log.d(Tag, "this is publicFunc(String value) log || " + value);
    }

    private void privateFunc(String value){
        Log.d(Tag, "this is privateFunc(String value) log || " + value);
    }

    static private void staticPrivateFunc(String value){
        Log.d(Tag, "this is staticPrivateFunc(Strin value) log || " + value);
    }

    private void complexParameterFunc(String value, String[][] str, Map<String,String> map, ArrayList arrayList) {
        Log.d(Tag, "this is complexParameter(Strin value) log || " + value);
    }

    private void repleaceFunc(){
        Log.d(Tag, "this is repleaceFunc log");
    }

    public void Inner(Animal dog, String value){
        Log.d(Tag, "this is Inner log ||" + value);
        dog.eatFunc("xiaojianbang");
    }

    private void refl(){
        Log.d(Tag,"this is fanshe publicInt " + this.publicInt);
    }

    class InnerClass{
        public int innerPublicInt = 1000;
        private int innerPrivateInt = 2000;
        public InnerClass(){
            Log.d(Tag, "this is InnerClass construct log");
        }
        public void innerFunc(String value){
            Log.d(Tag, "this is innerFunc(String value) log || " + value);
            Log.d(Tag, "innerPublicInt = " + innerPublicInt);
            Log.d(Tag, "innerPrivateInt = " + innerPrivateInt);
        }
    }
}