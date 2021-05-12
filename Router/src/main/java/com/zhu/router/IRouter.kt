package com.zhu.router

/**
 * @author Zhu
 * @date 2021/5/12 4:29 PM
 * @desc  将注册逻辑下沉至各个 module.
 */
interface IRouter {
    fun loadRouterInfo(routerMap: HashMap<String, Class<*>>)
}