package org.oym.newshive.data.model

import androidx.annotation.DrawableRes
import org.oym.newshive.R

/**
 * Created by oguzhan.yildirim on 13.02.2024.
 */
data class Page(
    val title: String,
    val description : String,
    @DrawableRes val image: Int
)

//Dummy Pages

val pages = listOf(
    Page(
        title = "Dive Into the Headlines",
        description = "Explore headlines and trends with News Hive's simple interface. Get the news that matters to you instantly.",
        image = R.drawable.onboarding1
    ),
    Page(
            title = "Discover Worldwide News",
            description = "Begin your global news journey with News Hive. Find stories tailored to your interests effortlessly.",
            image = R.drawable.onboarding2
        ),
    Page(
            title = "Empower Your News Experience",
            description = "Take control of your news with News Hive's powerful features. Customize your feed and stay informed easily.",
            image = R.drawable.onboarding3
        )
)
