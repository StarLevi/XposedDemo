package com.xposed;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Practice implements IXposedHookLoadPackage {
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        Log.d("xiaojianbang", "hook...");

        if (!lpparam.packageName.equals("com.xiaojianbang.xposeddemo")) return;

        Log.d("xiaojianbang", "hooking...");
    }
}