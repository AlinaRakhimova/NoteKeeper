package ru.rakhimova.notekeeper.view

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View

class FabBehavior(context: Context, attributeSet: AttributeSet) : FloatingActionButton.Behavior(context, attributeSet) {

    override fun onStartNestedScroll(
            coordinatorLayout: CoordinatorLayout,
            child: FloatingActionButton,
            directTargetChild: View,
            target: View,
            axes: Int,
            type: Int
    ): Boolean {

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(
                coordinatorLayout,
                child, directTargetChild, target, axes, type
        )
    }

    override fun onNestedScroll(
            coordinatorLayout: CoordinatorLayout,
            child: FloatingActionButton,
            target: View,
            dxConsumed: Int,
            dyConsumed: Int,
            dxUnconsumed: Int,
            dyUnconsumed: Int,
            type: Int
    ) {

        super.onNestedScroll(
                coordinatorLayout, child, target,
                dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type
        )

        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
            child.hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                @SuppressLint("RestrictedApi")
                override fun onHidden(fab: FloatingActionButton) {
                    fab.visibility = View.INVISIBLE
                }
            })
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            child.show()
        }
    }

}