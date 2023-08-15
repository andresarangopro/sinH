package com.example.logogenia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.logogenia.presentation.ui.home.HomeRoute
import com.example.logogenia.presentation.ui.home.HomeViewModel
import com.example.logogenia.presentation.ui.navigation.NavigationMainComponent
import com.example.logogenia.presentation.ui.theme.LogogeniaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        //val userStatus = bundle!!.getString("UserStatus")
        var startDestination = HomeRoute.route
        setContent {
            val navController = rememberNavController()
            LogogeniaTheme() {
                Scaffold {
                    NavigationMainComponent().navigationComponent(
                        navController, it, startDestination
                    )
                }
            }
        }
    }
}
