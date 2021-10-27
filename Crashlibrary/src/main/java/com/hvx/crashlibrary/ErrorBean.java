package com.hvx.crashlibrary;

import android.os.Build;

import java.io.Serializable;
import java.util.List;

public class ErrorBean implements Serializable {

    private String brand = Build.BRAND;
    private String model = Build.MODEL;
    private String app_name;
    private String package_name;
    private String app_version_name;
    private String app_version_code;
    private String sdk_version_name;
    private String sdk_version_code;
    private String android_id;
    private String mobile;
    private String isDebug;
    private Throwable type;
    private Object cause;
    private String localizedMessage;
    private String message;
    private List<StackTraceBean> stackTrace;
    private String date;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getApp_version_name() {
        return app_version_name;
    }

    public void setApp_version_name(String app_version_name) {
        this.app_version_name = app_version_name;
    }

    public String getApp_version_code() {
        return app_version_code;
    }

    public void setApp_version_code(String app_version_code) {
        this.app_version_code = app_version_code;
    }

    public String getSdk_version_name() {
        return sdk_version_name;
    }

    public void setSdk_version_name(String sdk_version_name) {
        this.sdk_version_name = sdk_version_name;
    }

    public String getSdk_version_code() {
        return sdk_version_code;
    }

    public void setSdk_version_code(String sdk_version_code) {
        this.sdk_version_code = sdk_version_code;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsDebug() {
        return isDebug;
    }

    public void setIsDebug(String isDebug) {
        this.isDebug = isDebug;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Throwable getType() {
        return type;
    }

    public void setType(Throwable type) {
        this.type = type;
    }

    public Object getCause() {
        return cause;
    }

    public void setCause(Object cause) {
        this.cause = cause;
    }

    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public void setLocalizedMessage(String localizedMessage) {
        this.localizedMessage = localizedMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StackTraceBean> getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(List<StackTraceBean> stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public String toString() {
        return "{" +
                "\"app_name\":" + isNull(app_name) + "," +
                "\"app_version_name\":" + isNull(app_version_name) + "," +
                "\"sdk_version_name\":" + isNull(sdk_version_name) + "," +

                "\"errorFile\":" + isNull(stackTrace.get(0).getFileName()) + "," +
                "\"errorLineNum\":" + isNull(stackTrace.get(0).getLineNumber()) + "," +
                "\"errorMethod\":" + isNull(stackTrace.get(0).getMethodName()) + "," +

                "\"package_name\":" + isNull(package_name) + "," +
                "\"brand\":" + isNull(brand) + "," +
                "\"model\":" + isNull(model) + "," +
                "\"app_version_code\":" + isNull(app_version_code) + "," +
                "\"sdk_version_code\":" + isNull(sdk_version_code) + "," +
                "\"android_id\":" + isNull(android_id) + "," +
                "\"mobile\":" + isNull(mobile) + "," +
                "\"isDebug\":" + isNull(isDebug) + "," +
                "\"type\":" + isNull(type) + "," +
                "\"date\":" + System.currentTimeMillis() + "," +
                "\"cause\":" + isNull(cause) + "," +
                "\"localizedMessage\":" + localizedMessage + "," +
                "\"message\":" + message + "," +
                "\"stackTrace\":" + stackTrace.toString() +
                "}";
    }

    public String isNull(Object o) {
        return o == null ? "\"\" " : "\"" + o + "\"";
    }

    public static class StackTraceBean implements Serializable {
        /**
         * className : com.pandarupees.app.frame.ui.activity.Test
         * fileName : Test.java
         * lineNumber : 12
         * methodName : test
         * nativeMethod : false
         */

        private String className;
        private String fileName;
        private int lineNumber;
        private String methodName;
        private boolean nativeMethod;

        @Override
        public String toString() {
            return "{" +
                    "\"className\":" + isNull(className) + "," +
                    "\"fileName\":" + isNull(fileName) + "," +
                    "\"lineNumber\":" + isNull(lineNumber) + "," +
                    "\"methodName\":" + isNull(methodName) + "," +
                    "\"nativeMethod\":" + isNull(nativeMethod) +
                    "}";
        }

        public String isNull(Object o) {
            return o == null ? "\"\" " : "\"" + o + "\"";
        }


        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public boolean isNativeMethod() {
            return nativeMethod;
        }

        public void setNativeMethod(boolean nativeMethod) {
            this.nativeMethod = nativeMethod;
        }


    }


}
