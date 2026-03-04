package com.example.dogsinfo_vikasm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dogsinfo_vikasm.data.Dog
import com.example.dogsinfo_vikasm.data.dogs
import androidx.compose.material.icons.filled.Pets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import com.example.dogsinfo_vikasm.ui.theme.DogsInfoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            DogsInfoTheme {

                Scaffold(
                    topBar = { DogsTopBar() }
                ) { paddingValues ->

                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {

                        DogList()

                    }

                }

            }

        }
    }
}

@Composable
fun ExpandButton(
    expanded: Boolean,
    onClick: () -> Unit
) {

    IconButton(onClick = onClick) {

        Icon(
            imageVector =
                if (expanded)
                    Icons.Filled.ExpandLess
                else
                    Icons.Filled.ExpandMore,

            contentDescription = "Expand Button",

            tint = MaterialTheme.colorScheme.primary
        )

    }

}

@Composable
fun DogHobby(hobby: String) {

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {

        Text(
            text = "Hobby",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = hobby,
            style = MaterialTheme.typography.labelMedium
        )

    }

}

@Composable
fun DogItem(dog: Dog) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )

    ) {

        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Image(
                    painter = painterResource(id = dog.image),
                    contentDescription = dog.name,

                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),

                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {

                    Text(
                        text = dog.name,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text(
                        text = "${dog.age} years old",
                        style = MaterialTheme.typography.bodyLarge
                    )

                }

                Spacer(modifier = Modifier.weight(1f))

                ExpandButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )

            }

            if (expanded) {

                DogHobby(dog.hobby)

            }

        }

    }

}

@Composable
fun DogList() {

    LazyColumn(

        contentPadding = PaddingValues(
            top = 8.dp,
            bottom = 8.dp
        )

    ) {

        items(dogs) { dog ->

            DogItem(dog)

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsTopBar() {

    CenterAlignedTopAppBar(

        title = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Filled.Pets,
                    contentDescription = "App Icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "DogsInfo",
                    style = MaterialTheme.typography.displayLarge
                )

            }

        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )

    )
}