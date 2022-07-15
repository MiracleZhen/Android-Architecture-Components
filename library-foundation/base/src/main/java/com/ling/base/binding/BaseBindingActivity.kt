package com.ling.base.binding

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.ling.base.BaseActivity
import java.lang.reflect.*
import java.lang.reflect.Array

/**
 * author : wangchengzhen
 * github : https://github.com/chengzhen-wang/Android-Architecture-Components
 * time   : 2022/5/17
 * desc   : Activity ViewBinding基类 - https://www.jianshu.com/p/4ed5eef13fc9
 */
abstract class BaseBindingActivity<VB : ViewBinding> : BaseActivity() {

    /** ViewBinding  */
    protected var binding: VB? = null

    override fun initLayout() {
        binding = initBinding()
        binding?.let {
            setContentView(it.root)
            initSoftKeyboard()
        }
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
    @SuppressWarnings("unchecked")
    protected open fun initBinding(): VB? {
        try {
            val superClass = javaClass.genericSuperclass
            if (superClass != null) {
                val type = (superClass as ParameterizedType).actualTypeArguments[0]
                val clazz = getRawType(type)
                val method = clazz!!.getMethod("inflate", LayoutInflater::class.java)
                return method.invoke(null, layoutInflater) as VB
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

    /**
     * type不能直接实例化对象，通过type获取class的类型，然后实例化对象
     */
    open fun getRawType(type: Type?): Class<*>? {
        return when (type) {
            is Class<*> -> {
                type
            }
            is ParameterizedType -> {
                val rawType = type.rawType
                rawType as Class<*>
            }
            is GenericArrayType -> {
                val componentType = type.genericComponentType
                Array.newInstance(getRawType(componentType)!!, 0).javaClass
            }
            is TypeVariable<*> -> {
                Any::class.java
            }
            is WildcardType -> {
                getRawType(type.upperBounds[0])
            }
            else -> {
                val className = if (type == null) "null" else type.javaClass.name
                throw IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <$type> is of type $className")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
