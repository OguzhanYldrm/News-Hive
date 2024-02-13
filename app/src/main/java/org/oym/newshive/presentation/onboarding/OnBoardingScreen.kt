package org.oym.newshive.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.oym.newshive.data.model.pages
import org.oym.newshive.presentation.onboarding.components.OnBoardingPage
import org.oym.newshive.ui.theme.NewsHiveTheme

/**
 * Created by oguzhan.yildirim on 13.02.2024.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) {index ->
            OnBoardingPage(page = pages[index])
            
        }
    }
}


@Preview
@Composable
fun OnBoardingScreenPreview() {
    NewsHiveTheme {
        OnBoardingScreen()
    }
}
