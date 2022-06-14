package com.sbdev.project.recyclerview_item_decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    var orientation: Orientation = Orientation.VERTICAL
    var spanCount: Int = 1

    var topOffset: Int = R.dimen._0dp
    var endOffset: Int = R.dimen._0dp
    var bottomOffset: Int = R.dimen._0dp
    var startOffset: Int = R.dimen._0dp
    var lastOffset: Int = bottomOffset

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val topDecorationHeight = context.resources.getDimensionPixelSize(topOffset)
        val endDecorationHeight = context.resources.getDimensionPixelSize(endOffset)
        val bottomDecorationHeight = context.resources.getDimensionPixelSize(bottomOffset)
        val startDecorationHeight = context.resources.getDimensionPixelSize(startOffset)
        val lastDecorationHeight = context.resources.getDimensionPixelSize(lastOffset)

        val itemPosition: Int = parent.getChildAdapterPosition(view)
        val totalCount: Int = parent.adapter?.itemCount ?: 0
        val rows = totalCount / spanCount

        outRect.top = topDecorationHeight
        outRect.right = endDecorationHeight
        outRect.bottom = bottomDecorationHeight
        outRect.left = startDecorationHeight

        when {
            spanCount == 1 && itemPosition == totalCount - 1 -> {
                when (orientation) {
                    Orientation.VERTICAL -> {
                        outRect.bottom = lastDecorationHeight
                    }
                    Orientation.HORIZONTAL -> {
                        outRect.right = lastDecorationHeight
                    }
                }
            }
            else -> {
                if (itemPosition in (rows * spanCount) until totalCount) {
                    when (orientation) {
                        Orientation.VERTICAL -> {
                            outRect.bottom = lastDecorationHeight
                        }
                        Orientation.HORIZONTAL -> {
                            outRect.right = lastDecorationHeight
                        }
                    }
                }
            }
        }
    }

}