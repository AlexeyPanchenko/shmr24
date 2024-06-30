package ru.yandex.shmr24.feature1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.runBlocking
import ru.yandex.shmr24.core.NetworkRepository
import ru.yandex.shmr24.model.DogInfo

val text = mutableStateOf("")

@Composable
fun Feature1Screen(navController: NavController, repository: NetworkRepository) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MaterialTheme(
            colorScheme = lightColorScheme(
                primary = Color.White,
                secondary = Color.Black,
                tertiary = Color.Red
            ),
            typography = Typography(
                bodyLarge = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp
                ),
            ),
            content = {
                Column(
                    modifier = Modifier.padding(innerPadding),
                ) {
                    Text(
                        text = "Feature1",
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        onClick = {
                            val dogInfo = runBlocking {
                                runCatching { repository.getDogInfo().body() }
                                    .getOrElse {
                                        it.printStackTrace()
                                        DogInfo(it.message ?: "Error", "Error") }
                            }
                            text.value = "message = ${dogInfo?.message}\nstatus = ${dogInfo?.status}"
                        }) {
                        Text(
                            color = Color.Red,
                            text = "get data"
                        )
                    }
                    Text("Result:")
                    val resultText by text
                    Text(resultText)
                }
            }
        )
    }

}
