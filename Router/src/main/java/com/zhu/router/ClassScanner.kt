package com.zhu.router

import android.content.Context
import android.util.Log
import dalvik.system.DexFile
import dalvik.system.PathClassLoader
import kotlin.reflect.KClass

/**
 * @author Zhu
 * @date 2021/5/12 5:02 PM
 * @desc
 */
class ClassScanner {
    fun scan(context: Context, packageName: String): List<KClass<*>> {
        val classes: MutableList<KClass<out Any>> = ArrayList()
        try {
            val classLoader = Thread.currentThread().contextClassLoader as PathClassLoader
            val entries = DexFile(context.packageResourcePath).entries()
            while (entries.hasMoreElements()) {
                val entryName = entries.nextElement()
                if (entryName.startsWith(packageName)) {
                    val entryClass = Class.forName(entryName, true, classLoader).kotlin
                    classes.add(entryClass)
                }
            }
        } catch (e: Exception) {
            Log.d("heiheihei", "Exception  ${e.message}}")
        }
        return classes
    }
}