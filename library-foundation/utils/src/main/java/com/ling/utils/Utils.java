package com.ling.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about initialization
 */
public final class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Application sApp;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化Utils
     * <p>
     * Init utils.
     * <p>Init it in the class of UtilsFileProvider.</p>
     *
     * @param app application
     */
    public static void init(final Application app) {
        if (app == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        if (sApp == null) {
            sApp = app;
            UtilsBridge.register(sApp);
            UtilsBridge.preLoad();
            return;
        }
        if (sApp.equals(app)) return;
        UtilsBridge.unregister(sApp);
        sApp = app;
        UtilsBridge.register(sApp);
    }

    /**
     * 获取 Application 对象
     * <p>
     * Return the Application object.
     * <p>Main process get app by UtilsFileProvider,
     * and other process get app by reflect.</p>
     *
     * @return the Application object
     */
    public static Application getApp() {
        if (sApp != null) return sApp;
        init(getApplicationByReflect());
        if (sApp == null) throw new NullPointerException("reflect failed.");
        Log.i("Utils", ProcessUtils.getCurrentProcessName() + " reflect app success.");
        return sApp;
    }

    /**
     * 通过反射获取 Application 对象
     */
    @SuppressWarnings("all")
    @SuppressLint("PrivateApi")
    static Application getApplicationByReflect() {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Object thread = getActivityThread();
            Object app = activityThreadClass.getMethod("getApplication").invoke(thread);
            if (app == null) {
                return null;
            }
            return (Application) app;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射获取 ActivityThread 对象
     */
    static Object getActivityThread() {
        Object activityThread = getActivityThreadInActivityThreadStaticField();
        if (activityThread != null) return activityThread;
        return getActivityThreadInActivityThreadStaticMethod();
    }

    /**
     * 通过反射静态属性获取 ActivityThread 对象
     */
    @SuppressWarnings("all")
    @SuppressLint("PrivateApi")
    private static Object getActivityThreadInActivityThreadStaticField() {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Field sCurrentActivityThreadField = activityThreadClass.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            return sCurrentActivityThreadField.get(null);
        } catch (Exception e) {
            Log.e("Utils", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    /**
     * 通过反射静态方法获取 ActivityThread 对象
     */
    @SuppressWarnings("all")
    @SuppressLint("PrivateApi")
    private static Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            return activityThreadClass.getMethod("currentActivityThread").invoke(null);
        } catch (Exception e) {
            Log.e("Utils", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // interface
    ///////////////////////////////////////////////////////////////////////////

    /**
     * APP 前后台切换监听器
     */
    public interface OnAppStatusChangedListener {

        void onForeground(Activity activity);

        void onBackground(Activity activity);
    }

    /**
     * Activity 生命周期回调
     */
    public static class ActivityLifecycleCallbacks {

        public void onActivityCreated(@NonNull Activity activity) {/**/}

        public void onActivityStarted(@NonNull Activity activity) {/**/}

        public void onActivityResumed(@NonNull Activity activity) {/**/}

        public void onActivityPaused(@NonNull Activity activity) {/**/}

        public void onActivityStopped(@NonNull Activity activity) {/**/}

        public void onActivityDestroyed(@NonNull Activity activity) {/**/}

        public void onLifecycleChanged(@NonNull Activity activity, Lifecycle.Event event) {/**/}
    }

    public abstract static class Task<Result> extends ThreadUtils.SimpleTask<Result> {

        private Consumer<Result> mConsumer;

        public Task(final Consumer<Result> consumer) {
            mConsumer = consumer;
        }

        @Override
        public void onSuccess(Result result) {
            if (mConsumer != null) {
                mConsumer.accept(result);
            }
        }
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Supplier<T> {
        T get();
    }

    public interface Func1<Ret, Par> {
        Ret call(Par param);
    }
}
