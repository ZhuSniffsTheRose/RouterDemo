package com.zhu.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * @author Zhu
 * @date 2021/5/12 5:52 PM
 * @desc
 */
public class RouterManager {

    private final HashMap<String, Class<?>> routerMap = new HashMap();

    public void init(Context context) {
        ClassScannerJava classScanner = new ClassScannerJava();
        List<String> scanResult = classScanner.scan(context, "com.zhu.haha");
        for (String cls : scanResult) {
            try {
                Class<?> aClass = Class.forName(cls);
                if (aClass.isAssignableFrom(IRouter.class)) {
                    IRouter iRouter = (IRouter) aClass.newInstance();
                    iRouter.loadRouterInfo(routerMap);
                }
            } catch (Exception e) {
                Log.d("heiheihei", "init: " + e.getMessage());

            }
        }
    }


    public void startActivity(Activity activity, String path) {
        Class<?> clazz = routerMap.get(path);
        if (clazz != null) {
            activity.startActivity(new Intent(activity, clazz));
        } else {
            Toast.makeText(activity, "not found the path", Toast.LENGTH_SHORT).show();
        }
    }

    static class RouterHolder {
        static final RouterManager instance = new RouterManager();
    }

    public static RouterManager getInstance() {
        return RouterHolder.instance;
    }
}
