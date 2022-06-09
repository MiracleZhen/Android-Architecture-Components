package com.ling.mvc.http.model

import kotlin.math.ceil

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/EasyHttp
 * time   : 2022/6/8
 * desc   : 统一接口列表数据结构
 */
class HttpListData<T> : HttpData<HttpListData.ListBean<T?>?>() {

    class ListBean<T> {

        /** 当前页码 */
        private val pageIndex: Int = 0

        /** 页大小 */
        private val pageSize: Int = 0

        /** 总数量 */
        private val totalNumber: Int = 0

        /** 数据 */
        private val items: MutableList<T?>? = null

        /**
         * 判断是否是最后一页
         */
        fun isLastPage(): Boolean {
            return ceil((totalNumber.toFloat() / pageSize.toFloat())) <= pageIndex
        }

        fun getTotalNumber(): Int {
            return totalNumber
        }

        fun getPageIndex(): Int {
            return pageIndex
        }

        fun getPageSize(): Int {
            return pageSize
        }

        fun getItems(): MutableList<T?>? {
            return items
        }
    }
}
