package com.sbdev.project.recyclerview_item_decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class LineDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    var verticalDividerDrawable = R.drawable.vertical_divider
    var horizontalDividerDrawable = R.drawable.horizontal_divider

    var orientation: Orientation = Orientation.VERTICAL
    var spanCount: Int = 1

    var topOffset: Int = R.dimen._0dp
    var endOffset: Int = R.dimen._0dp
    var bottomOffset: Int = R.dimen._0dp
    var startOffset: Int = R.dimen._0dp
    var lastOffset: Int = bottomOffset

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val childCount = parent.childCount
        val rows = childCount / spanCount

        val topDecorationHeight = context.resources.getDimensionPixelSize(topOffset)
        val endDecorationHeight = context.resources.getDimensionPixelSize(endOffset)
        val bottomDecorationHeight = context.resources.getDimensionPixelSize(bottomOffset)
        val startDecorationHeight = context.resources.getDimensionPixelSize(startOffset)

        val mDividerV = ContextCompat.getDrawable(context, verticalDividerDrawable)
        val mDividerH = ContextCompat.getDrawable(context, horizontalDividerDrawable)

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            when {
                i == childCount - 1 -> {
                    return
                }
                i in childCount-spanCount until childCount -> {
                    when(orientation) {
                        Orientation.VERTICAL -> {
                            val topH = child.top + topDecorationHeight
                            val bottomH = child.bottom - bottomDecorationHeight
                            val leftH = child.right + params.rightMargin - ((mDividerH?.intrinsicWidth ?: 0) / 2)
                            val rightH = leftH + (mDividerH?.intrinsicWidth ?: 0)
                            mDividerH?.setBounds(leftH, topH, rightH, bottomH)
                            mDividerH?.draw(c)
                        }
                        Orientation.HORIZONTAL -> {
                            val leftV = child.left + startDecorationHeight
                            val rightV = child.right - endDecorationHeight
                            val topV =
                                child.bottom + params.bottomMargin - ((mDividerV?.intrinsicHeight ?: 0) / 2)
                            val bottomV = topV + (mDividerV?.intrinsicHeight ?: 0)
                            mDividerV?.setBounds(leftV, topV, rightV, bottomV)
                            mDividerV?.draw(c)
                        }
                    }
                }
                (i+1)%spanCount == 0 -> {
                    when(orientation) {
                        Orientation.VERTICAL -> {
                            val leftV = child.left + startDecorationHeight
                            val rightV = child.right - endDecorationHeight
                            val topV =
                                child.bottom + params.bottomMargin - ((mDividerV?.intrinsicHeight ?: 0) / 2)
                            val bottomV = topV + (mDividerV?.intrinsicHeight ?: 0)
                            mDividerV?.setBounds(leftV, topV, rightV, bottomV)
                            mDividerV?.draw(c)
                        }
                        Orientation.HORIZONTAL -> {
                            val topH = child.top + topDecorationHeight
                            val bottomH = child.bottom - bottomDecorationHeight
                            val leftH = child.right + params.rightMargin - ((mDividerH?.intrinsicWidth ?: 0) / 2)
                            val rightH = leftH + (mDividerH?.intrinsicWidth ?: 0)
                            mDividerH?.setBounds(leftH, topH, rightH, bottomH)
                            mDividerH?.draw(c)
                        }
                    }
                }
                else -> {
                    val leftV = child.left + startDecorationHeight
                    val rightV = child.right - endDecorationHeight
                    val topV =
                        child.bottom + params.bottomMargin - ((mDividerV?.intrinsicHeight ?: 0) / 2)
                    val bottomV = topV + (mDividerV?.intrinsicHeight ?: 0)
                    mDividerV?.setBounds(leftV, topV, rightV, bottomV)
                    mDividerV?.draw(c)

                    val topH = child.top + topDecorationHeight
                    val bottomH = child.bottom - bottomDecorationHeight
                    val leftH = child.right + params.rightMargin - ((mDividerH?.intrinsicWidth ?: 0) / 2)
                    val rightH = leftH + (mDividerH?.intrinsicWidth ?: 0)
                    mDividerH?.setBounds(leftH, topH, rightH, bottomH)
                    mDividerH?.draw(c)
                }
            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val lastDecorationHeight = context.resources.getDimensionPixelSize(lastOffset)

        val itemPosition = parent.getChildAdapterPosition(view)
        val totalCount = parent.adapter?.itemCount ?: 0
        val rows = totalCount / spanCount

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