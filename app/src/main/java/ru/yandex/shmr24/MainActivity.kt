package ru.yandex.shmr24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.yandex.shmr24.core.DogApiService
import ru.yandex.shmr24.core.NetworkRepository
import ru.yandex.shmr24.feature1.Feature1Screen
import ru.yandex.shmr24.feature2.Feature2Screen
import ru.yandex.shmr24.ui.theme.Shmr24Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repo = NetworkRepository(
            Retrofit.Builder()
                .baseUrl("https://dog.ceo")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DogApiService::class.java)
        )

        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "start"
            ) {
                composable(route = "start") {
                    StartScreen(navController = navController)
                }
                composable(
                    route = "feature1"
                ) {
                    Feature1Screen(
                        navController = navController,
                        repository = repo
                    )
                }
                composable(
                    route = "feature2"
                ) {
                    Feature2Screen(
                        navController = navController,
                        repository = repo
                    )
                }
            }
        }
    }
}

@Composable
fun StartScreen(navController: NavController) {
    Shmr24Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column {
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )
                Button(
                    onClick = {
                        navController.navigate("feature1")
                    }
                ) {
                    Text("open feature1")
                }
                Button(
                    onClick = {
                        navController.navigate("feature2")
                    }
                ) {
                    Text("open feature2")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Shmr24Theme {
        Greeting("Android")
    }
}
