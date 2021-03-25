package com.destructo.mars.app.data.datasource

import com.destructo.mars.app.R
import com.destructo.mars.app.data.model.common.Rover

object RoversList {

    val rovers = arrayListOf(
            Rover(
                name = "Curiosity",
                image = R.drawable.curiosity,
                landingDate = "AUG 06, 2012",
                launchDate = "Nov 26, 2011",
                missionName = "Mars Exploration Program",
                mainJob = "Curiosity set out to answer the question: Did Mars ever have the right environmental conditions to support small life forms called microbes?"),
            Rover(
                name = "Opportunity",
                image = R.drawable.opportunity,
                landingDate = "Jan 24, 2004 PST",
                launchDate = "Jul 08, 2003",
                missionName = "Mars Exploration Program",
                mainJob = "One of two rovers launched in 2003 to explore Mars and search for signs of past life, Opportunity far outlasted her planned 90-day mission."),
            Rover(
                name = "Perseverance",
                image = R.drawable.perseverance,
                landingDate = "Feb 18, 2021",
                launchDate = "Jul 30, 2020",
                missionName = "Mars 2020",
                mainJob = "Seek signs of ancient life and collect samples of rock and regolith (broken rock and soil) for possible return to Earth."),
            Rover(
                name = "Spirit",
                image = R.drawable.spirit,
                landingDate = "Jan 03, 2004 PST",
                launchDate = "Jun 10, 2003",
                missionName = "Mars Exploration Program",
                mainJob = "One of two rovers launched in 2003 to explore Mars and search for signs of past life, Spirit far outlasted her planned 90-day mission."),
            )
}