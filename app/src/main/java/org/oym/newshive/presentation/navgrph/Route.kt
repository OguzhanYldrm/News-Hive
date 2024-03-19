package org.oym.newshive.presentation.navgrph

/**
 * Created by oguzhan.yildirim on 19.03.2024.
 */
sealed class Route(val route: String) {

    //Main Graph
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object BookmarkScreen : Route(route = "bookmarkScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")

    //Sub Graph
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")

}