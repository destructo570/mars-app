package com.destructo.mars.app.data.datasource

import com.destructo.mars.app.R
import com.destructo.mars.app.data.model.Rover

object RoversList {

    val rovers = arrayListOf(
            Rover(
                name = "Curiosity",
                image = R.drawable.curiosity),
            Rover(
                    name = "Opportunity",
                    image = R.drawable.opportunity),
            Rover(
                    name = "Perseverance",
                    image = R.drawable.perseverance),
            Rover(
                    name = "Spirit",
                    image = R.drawable.spirit),
            )
}