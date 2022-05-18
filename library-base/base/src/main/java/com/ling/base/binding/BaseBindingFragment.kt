package com.ling.base.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.ling.base.BaseFragment
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**
 *  author : wangchengzhen
 *  github : https://github.com/chengzhen-wang/Android-Architecture-Components
 *  time   : 2022/5/17
 *  desc   : Fragment ViewBinding基类 - https://www.jianshu.com/p/4ed5eef13fc9
 */
abstract class BaseBindingFragment<A : BaseBindingActivity<*>, VB : ViewBinding> :
    BaseFragment<A>() {

    /** ViewBinding  */
    protected var binding: VB? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = initBinding(inflater, container) ?: return null

        loading = false
        rootView = binding?.root
        initView()
        return rootView
    }

    /**
     * 使用ViewBinding就不需求子类实现此方法
     */
    override fun getLayoutId(): Int {
        return 0
    }

    /**
     * 利用泛型+反射获取ViewBinding对象.
     * 如果追求完美，不喜欢用反射，也可以子类重写initBinding()方法.
     */
    protected open fun initBinding(inflater: LayoutInflater?, container: ViewGroup?): VB? {
        try {
            val superClass = javaClass.genericSuperclass
            if (superClass != null) {
                val type = (superClass as ParameterizedType).actualTypeArguments[1]
                val clazz = getAttachActivity()!!.getRawType(type)
                val method = clazz!!.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.javaPrimitiveType)
                return method.invoke(null, inflater, container, false) as VB
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
