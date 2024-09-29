package com.example.chetvergovakpr_22103k17r

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chetvergovakpr_22103k17r.ui.theme.ChetvergovaKpr22103k17rTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChetvergovaKpr22103k17rTheme {
                SplashScreen {
                    // Когда 5 секунд пройдет, запустим SignInActivity
                    startActivity(Intent(this, signInActivity::class.java))
                    finish() // Завершаем SplashScreenActivity, чтобы пользователь не мог вернуться на него
                }
            }
        }
    }
}

class signInActivity {

}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Используем LaunchedEffect для отсчета времени (5 секунд)
    LaunchedEffect(Unit) {
        delay(5000) // 5 секунд
        onTimeout() // Когда таймер завершится, вызываем onTimeout
    }

    // Отображаем картинку на весь экран
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.launchscreen), // Убедитесь, что у вас есть ресурс изображения
            contentDescription = "Splash Screen Image",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Вызов темы, чтобы стилизация и контекст были корректными
    ChetvergovaKpr22103k17rTheme {
        Greeting(name = "Android") // Теперь передаем имя Android
    }
}

@Composable
fun Greeting(name: String) {

}
