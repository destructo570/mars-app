package com.destructo.mars.app.data.datasource

import com.destructo.mars.app.R
import com.destructo.mars.app.data.model.Rover

object RoversList {

    val rovers = arrayListOf(
            Rover(
                name = "Curiosity",
                image = R.drawable.curiosity,
                landedOn = "AUG 06, 2012",
                launchedOn = "Nov 26, 2011",
                missionName = "Mars Exploration Program",
                mainJob = "Curiosity set out to answer the question: Did Mars ever have the right environmental conditions to support small life forms called microbes?"),
            Rover(
                name = "Opportunity",
                image = R.drawable.opportunity,
                landedOn = "Jan 24, 2004 PST",
                launchedOn = "Jul 08, 2003",
                missionName = "Mars Exploration Program",
                mainJob = "One of two rovers launched in 2003 to explore Mars and search for signs of past life, Opportunity far outlasted her planned 90-day mission."),
            Rover(
                name = "Perseverance",
                image = R.drawable.perseverance,
                landedOn = "Feb 18, 2021",
                launchedOn = "Jul 30, 2020",
                missionName = "Mars 2020",
                mainJob = "Seek signs of ancient life and collect samples of rock and regolith (broken rock and soil) for possible return to Earth."),
            Rover(
                name = "Spirit",
                image = R.drawable.spirit,
                landedOn = "Jan 03, 2004 PST",
                launchedOn = "Jun 10, 2003",
                missionName = "Mars Exploration Program",
                mainJob = "One of two rovers launched in 2003 to explore Mars and search for signs of past life, Spirit far outlasted her planned 90-day mission."),
            )
}