package com.hvx.crashlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler INSTANCE;
    private CrashListener crashListener;
    private boolean isJumpError = true;
    private Context context;
    private ErrorBean errorInfo;
    private boolean isDebug;

    public static CrashHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler();
        }
        return INSTANCE;
    }

    public CrashHandler init(Context context) {
        this.context = context;
        errorInfo = new ErrorBean();
        Thread.setDefaultUncaughtExceptionHandler(this);
        return this;
    }

    public CrashHandler setDebug(boolean debug) {
        isDebug = debug;
        return this;
    }

    public void setCrashListener(CrashListener crashListener) {
        this.crashListener = crashListener;
    }

    public CrashHandler setJumpError(boolean isJumpError) {
        this.isJumpError = isJumpError;
        return this;
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable ex) {
        if (crashListener != null) {
            crashListener.CrashInfo(ex);
        } else {
            Log.e("CrashHandler", "No crash listening set");
        }

        errorInfo = Covers(ex);
        saveError(errorInfo.toString());
        if (isJumpError)
            startActivity();
        System.exit(0);
    }

    private void startActivity() {
        Intent intent = new Intent(context, ErrorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private ErrorBean Covers(Throwable t) {
        errorInfo.setDate(new Date().toString());
        errorInfo.setCause(t.getCause());
        errorInfo.setLocalizedMessage(t.getLocalizedMessage());
        errorInfo.setMessage(t.getMessage());
        List<ErrorBean.StackTraceBean> resultList = new ArrayList<>(t.getStackTrace().length);
        for (StackTraceElement s : t.getStackTrace()) {
            ErrorBean.StackTraceBean st = new ErrorBean.StackTraceBean();
            st.setClassName(s.getClassName());
            st.setFileName(s.getFileName());
            st.setLineNumber(s.getLineNumber());
            st.setMethodName(s.getMethodName());
            st.setNativeMethod(s.isNativeMethod());
            resultList.add(st);
        }
        errorInfo.setStackTrace(resultList);
        errorInfo.setType(t.getCause());

        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            errorInfo.setBrand(Build.BRAND);
            errorInfo.setModel(Build.MODEL);
            errorInfo.setSdk_version_name(android.os.Build.VERSION.RELEASE);
            errorInfo.setSdk_version_code(android.os.Build.VERSION.SDK_INT + "");
            errorInfo.setApp_version_name(pi.versionName + "");
            errorInfo.setApp_version_code(pi.versionCode + "");
            errorInfo.setAndroid_id(getAndroidID(context));
            errorInfo.setPackage_name(context.getPackageName());
            errorInfo.setApp_name(pi.applicationInfo.loadLabel(pm).toString());
            errorInfo.setIsDebug(isDebug + "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return errorInfo;
    }

    @SuppressLint("ApplySharedPref")
    public void saveError(String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("error", str);
        editor.commit();
    }

    public String readError() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        return sharedPreferences.getString("error", "None");
    }

    public interface CrashListener {
        void CrashInfo(Throwable ex);
    }

    @SuppressLint("HardwareIds")
    public static String getAndroidID(Context context) {
        String id = Settings.Secure.getString(
                context.getContentResolver(),
                Settings.Secure.ANDROID_ID
        );
        if ("9774d56d682e549c".equals(id)) return "";
        return id == null ? "" : id;
    }

}