package com.destructo.mars.app.ui.roverList

import com.destructo.mars.app.data.model.Rover

class RoverClickListener(val clickListener: (rover : Rover?) -> Unit) {
    fun onClick(rover: Rover?) = clickListener(rover)
}