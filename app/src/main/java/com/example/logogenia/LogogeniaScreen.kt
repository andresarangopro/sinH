package com.example.logogenia

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.logogenia.presentation.ui.EmptyScreen

enum class LogogeniaScreen(
    val body: @Composable ((String)-> Unit) -> Unit
) {
    LogogeniaHome(
        body = { EmptyScreen()}
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): LogogeniaScreen =
            when (route?.substringBefore("/")) {
                LogogeniaHome.name-> LogogeniaHome
                null -> LogogeniaHome
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }

}