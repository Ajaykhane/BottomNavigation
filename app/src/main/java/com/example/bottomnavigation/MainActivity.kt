package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bottomnavigation.data.BottomNavItems
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                val item = listOf(
                    BottomNavItems(
                        title = "Home",
                        selectedicon = Icons.Filled.Home,
                        unselectedicon = Icons.Outlined.Home,
                        hasnews = false
                    ),
                    BottomNavItems(
                        title = "Chat",
                        selectedicon = Icons.Filled.MailOutline,
                        unselectedicon = Icons.Outlined.MailOutline,
                        hasnews = false,
                        batchCount = 12
                    ),
                    BottomNavItems(
                        title = "Person",
                        selectedicon = Icons.Filled.Person,
                        unselectedicon = Icons.Outlined.Person,
                        hasnews = false
                    ),
                    BottomNavItems(
                        title = "Setting",
                        selectedicon = Icons.Filled.Settings,
                        unselectedicon = Icons.Outlined.Settings,
                        hasnews = true
                    )
                )

                var selectedItemState by rememberSaveable {
                    mutableIntStateOf(0)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                item.forEachIndexed { index, items ->
                                    NavigationBarItem(
                                        selected = selectedItemState == index,
                                        onClick = {
                                            selectedItemState = index
                                            // navController.navigation(items.title)
                                        },
                                        label ={
                                        Text(text = items.title)},
                                        icon = {
                                            BadgedBox(badge = {
                                                  if(items.batchCount != null){
                                                      Badge {
                                                          Text(text = items.batchCount.toString())
                                                      }
                                                  }else if(items.hasnews){
                                                      Badge()
                                                  }
                                            }
                                            ) {
                                                Icon(
                                                    imageVector = if (index == selectedItemState) {
                                                        items.selectedicon
                                                    } else items.unselectedicon,
                                                    contentDescription = items.title
                                                )
                                            }
                                        })

                                }
                            }
                        }
                    ) {

                    }
                }
            }
        }
    }
}
