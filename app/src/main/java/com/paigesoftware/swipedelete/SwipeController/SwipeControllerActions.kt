package com.paigesoftware.swipedelete.SwipeController

abstract class SwipeControllerActions {
    abstract fun onLeftClicked(position: Int)
    abstract fun onRightClicked(position: Int)
}