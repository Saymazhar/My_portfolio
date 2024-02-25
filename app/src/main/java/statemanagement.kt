package com.example.myportfolio
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@SuppressLint("UnrememberedMutableState")
@Composable
fun statemanagement(){
    var username=""
    var state = remember {
         mutableStateOf("")
    }//recompose ke time par value lost nhi hone deta ha remember block .
    Log.d("TAG","statemanagement: ${state}")
    TextField(value = state.value, onValueChange ={
    state.value =it;
    } )

}