package com.example.myportfolio

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.myportfolio.Greeting as Greeting

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyportfolioTheme {
                Portfolio()
//                statemanagement()
            }

        }
    }
}



@Composable
fun Portfolio(){
    val isopen= remember {
        mutableStateOf(false)
    }
    Surface(elevation = 8.dp,
        shape = RoundedCornerShape(12.dp) ,
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
//            .wrapContentHeight()
//            .height(120.dp)
            .padding(12.dp)) {

        Column(horizontalAlignment =Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)){
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier=Modifier.size(60.dp) )

            Spacer(modifier =Modifier.height(8.dp))// bichmai gap aayenga 8.dp ki height ka
            Divider()//1 line aayengi ismai
            Spacer(modifier =Modifier.height(8.dp))
            Text(text = "Mazhar Sayed", style = TextStyle(color=Color.Green, fontSize = 20.sp,fontWeight = FontWeight.Bold))
            
            Text(text = "Android Compose Developer", style = MaterialTheme.typography.caption)
            Spacer(modifier =Modifier.height(12.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.instagram), contentDescription = null, modifier = Modifier.size(18.dp))
                Text(text = "Saymazhar7", style = MaterialTheme.typography.caption, modifier = Modifier.padding(horizontal = 8.dp))
            }
            Spacer(modifier =Modifier.height(8.dp))
            Row{
                Image(painter = painterResource(id = R.drawable.github), contentDescription = null, modifier = Modifier.size(18.dp))
                Text(text = "Saymazhar", style = MaterialTheme.typography.caption, modifier = Modifier.padding(horizontal = 8.dp))
            }
            Spacer(modifier =Modifier.height(8.dp))
            Button(onClick = {isopen.value = !isopen.value}) {//ismai maine muutubale lagaya .
                Text(text = "My Projects")
            }

            if(isopen.value)//yaha par check karenga ki button click par list aaynegi .ispoen ke madad se
            {
            LazyColumn {
                items(getProjectList()) {
                    ProjectItem(it)
                }
            }
            }
        }


    }
}

@Composable
fun ProjectItem(project: Project) {
    
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)){
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier
            .size(60.dp)
            .clip(
                CircleShape
            ))
        Column {
            Text(text = project.name, style = MaterialTheme.typography.h6)
            Text(text = project.description, style = MaterialTheme.typography.body1)
        }

    }
    
    
}

fun getProjectList():List<Project>{
    return listOf(
        Project(name = "Traffic system" , description = "To automatically complaint system for the Traffic challan"),
        Project(name = "Security system" , description = "Secure the Website by implementing the jwt token in it"),
        Project(name = "Data Back up APP" , description = "Automatically delete the data when it is not being used for more than 30 days ,And store it on a  google cloud "),
        Project(name = "Traffic system" , description = "To automatically complaint system for the Traffic challan"),
        Project(name = "Security system" , description = "Secure the Website by implementing the jwt token in it"),
        Project(name = "Data Back up APP" , description = "Automatically delete the data when it is not being used for more than 30 days ,And store it on a  google cloud "),
        Project(name = "Traffic system" , description = "To automatically complaint system for the Traffic challan"),
        Project(name = "Security system" , description = "Secure the Website by implementing the jwt token in it"),
        Project(name = "Data Back up APP" , description = "Automatically delete the data when it is not being used for more than 30 days ,And store it on a  google cloud "),
    )
}

data class Project(
    val name: String,val description:String) {
//    companion object {
//    }
}


@Composable
fun MyportfolioTheme(content: @Composable () -> Unit) {
    // Define your theme here
    Surface(modifier = Modifier.wrapContentHeight()) {
        content()
    }
}


@Composable
fun Greeting(name:String){
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
       Portfolio()
}


