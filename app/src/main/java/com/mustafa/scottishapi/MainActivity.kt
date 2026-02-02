package com.Mustafa.scottishapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.Mustafa.scottishapi.navigation.CommentsNavHost
import com.mustafa.scottishapi.ui.theme.ScottishApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScottishApiTheme {
                CommentsNavHost()
            }
        }
    }
}