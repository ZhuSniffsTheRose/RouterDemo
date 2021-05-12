package com.zhu.router;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

/**
 * @author Zhu
 * @date 2021/5/12 5:58 PM
 * @desc
 */
public class ClassScannerJava {

    public List<String> scan(Context context, String packageName) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Enumeration entries = new DexFile(context.getPackageResourcePath()).entries();
            while (entries.hasMoreElements()) {
                String entryName = (String) entries.nextElement();
                if (entryName.startsWith(packageName)) {
                    Log.d("heiheihei", "ModuleARouterImpl scan: " + entryName);
                    list.add(entryName);
                }
            }
        } catch (Exception e) {
            Log.d("heiheihei", "Exception  ${e.message}}");
        }
        return list;
    }
}
