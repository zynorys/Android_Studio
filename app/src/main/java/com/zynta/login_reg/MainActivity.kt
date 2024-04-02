package com.zynta.login_reg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zynta.login_reg.ui.theme.Login_RegTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_RegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    Login()

                }
            }
        }
    }
}

@Composable

fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val mContext = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(vertical = 20.dp)) {
        Text(text = "eMobilis Login",
            color = Color.Magenta,
            fontSize = 28.sp,

        )
        Spacer(modifier = Modifier.height(20.dp))
        Icon(imageVector = Icons.Default.Person, contentDescription = "Per")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =email ,
            onValueChange ={email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Icons")},
            label = { Text(text = "Enter Email",
                color = Color.Blue,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange ={password=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "pass")},
            label = { Text(text = "Enter Pass",
                color = Color.Blue,
                fontSize = 20.sp)},
            modifier = Modifier.fillMaxWidth()


        )
        Spacer(modifier = Modifier.height(20.dp))
        
        Button(onClick = {
                         mContext.startActivity(Intent(mContext,Intents_Activity::class.java))
        },
            modifier = Modifier
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        )
        {
            Text(text = "Log In",
                fontSize = 20.sp)


        }


    }

}

@Preview
@Composable
private fun Loginpre() {
    Login()

}