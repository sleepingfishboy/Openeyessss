package com.example.lib.api

import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter
import kotlin.reflect.KClass

object ServiceManager {/**
 * 写法：
 * ```
 * ServiceManger(IAccountService::class)
 *   .isLogin()
 * ```
 * 还有更简单的写法：
 * ```
 * IAccountService::class.impl
 *   .isLogin()
 * ```
 */
operator fun <T : Any> invoke(serviceClass: KClass<T>): T {
    return ARouter.getInstance().navigation(serviceClass.java)
}

    /**
     * 写法：
     * ```
     * ServiceManger<IAccountService>(ACCOUNT_SERVICE)
     *   .isLogin()
     * ```
     */
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> invoke(servicePath: String): T {
        return ARouter.getInstance().build(servicePath).navigation() as T
    }

}

/**
 * 写法：
 * ```
 * IAccountService::class.impl
 *   .isLogin()
 * ```
 */
val <T: IProvider> KClass<T>.impl: T
    get() = ServiceManager(this)