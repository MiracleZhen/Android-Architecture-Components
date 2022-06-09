package com.ling.widget.recyclerview

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 图片选择列表分割线
 */
class GridSpaceDecoration constructor(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun onDraw(canvas: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {}

    override fun onDrawOver(canvas: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {}

    override fun getItemOffsets(rect: Rect, view: View, recyclerView: RecyclerView, state: RecyclerView.State) {
        val position: Int = recyclerView.getChildAdapterPosition(view)
        val spanCount: Int = (recyclerView.layoutManager as GridLayoutManager).spanCount

        // 每一行的最后一个才留出右边间隙
        if ((position + 1) % spanCount == 0) {
            rect.right = space
        }

        // 只有第一行才留出顶部间隙
        if (position < spanCount) {
            rect.top = space
        }
        rect.bottom = space
        rect.left = space
    }
}
