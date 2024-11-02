package com.ag_apps.spending_tracker.graph_screen.presentation




//import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SubdirectoryArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ag_apps.spending_tracker.core.data.RoomSpendingDataSource
import com.ag_apps.spending_tracker.core.domain.LocalSpendingDataSource
import com.ag_apps.spending_tracker.core.domain.Spending
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GraphScreenDisplay(
//    changeScreen: () -> Unit
//) {
//
//    // add code here
//
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//    // get data from view model
//    val spendingData = RoomSpendingDataSource.getInstance(LocalContext.current)
//
//    val spendingList = spendingData.getAllSpendings()
//    val totalSpending = spendingList.sumOf { it.price }
//
//    // get number of isPlastic items total
//
//
//
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(
//            scrollBehavior.nestedScrollConnection
//        ),
//        floatingActionButton = {
//            Column {
//                FloatingActionButton(
//                    onClick = { changeScreen() },
//                    contentColor = Color.Black
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.SubdirectoryArrowRight,
//                        contentDescription = "Back to Spending Overview"
//                    )
//                }
//                Spacer(modifier = Modifier.height(39.dp)) // Space at the bottom of the column
//            }
//        }
//    ){
//        paddingValues -> null
//    }
//        // Your main content goes here, applying any necessary padding
//        // Example: Box(modifier = Modifier.padding(paddingValues)) { ... }
//
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphScreenDisplay(
    changeScreen: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // Initialize variables for spending data
    var spendingList = emptyList<Spending>()
    var totalSpending = 0.0
    var plasticItemsCount = 0.0

    // Get data from Room database in a coroutine
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        val spendingData = RoomSpendingDataSource.getInstance(context)
        spendingList =
            spendingData.getAllSpendings() // This will suspend execution until the data is fetched
        totalSpending = spendingList.sumOf { it.price }
        plasticItemsCount = spendingList.count { it.isPlastic }
            .toDouble() // Assuming there is a property `isPlastic`
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    onClick = { changeScreen() },
                    contentColor = Color.Black
                ) {
                    Icon(
                        imageVector = Icons.Default.SubdirectoryArrowRight,
                        contentDescription = "Back to Spending Overview"
                    )
                }
                Spacer(modifier = Modifier.height(39.dp)) // Space at the bottom of the column
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(), // Fill the available space
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Center the content vertically
        ) {
            // Title
            Text(
                text = "Insights",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp), // Increase font size
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Display total spending
            Text(
                text = "Total Amount Spent: $${String.format("%.2f", totalSpending)}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp), // Increase font size
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Display count of plastic items
            Text(
                text = "Total Plastic Items: $plasticItemsCount",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp), // Increase font size
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGraphScreen() {
    GraphScreenDisplay(
        changeScreen = {}
    )
}