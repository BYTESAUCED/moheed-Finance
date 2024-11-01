package com.ag_apps.spending_tracker.graph_screen.presentation




//import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.SubdirectoryArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GraphScreenDisplay(
//    changeScreen: () -> Unit
//) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
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
//                Spacer(modifier = Modifier.height(40.dp))
//            }
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(horizontal = 16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Title
//            Text(
//                text = "Insights",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Pie Chart for `isPlastic` items using Vico
//            Text(
//                text = "Plastic Items Breakdown",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = Modifier.align(Alignment.Start)
//            )
//
//            // Placeholder pie chart with Vico - replace with actual data as needed
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(16.dp)
//            ) {
//                if (/* condition to check if there's data for pie chart */) {
//                    // Render pie chart with actual data
//                    VicoPieChart(
//                        data = /* provide isPlastic data here */,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                } else {
//                    // Render empty pie chart
//                    VicoPieChart(
//                        data = emptyList(),
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Bar Chart for monthly spending
//            Text(
//                text = "Monthly Spending Comparison",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = Modifier.align(Alignment.Start)
//            )
//
//            // Placeholder bar chart with Vico - replace with actual monthly spending data
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(16.dp)
//            ) {
//                if (/* condition to check if there's data for bar chart */) {
//                    // Render bar chart with actual data
//                    VicoBarChart(
//                        data = /* provide monthly spending data here */,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                } else {
//                    // Render empty bar chart
//                    VicoBarChart(
//                        data = listOf(/* current month data placeholder */),
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Most frequently purchased items
//            Text(
//                text = "Most Frequently Purchased Items",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = Modifier.align(Alignment.Start)
//            )
//
//            val mostFrequentItems = /* retrieve most frequently purchased items here */
//                if (mostFrequentItems.isNotEmpty()) {
//                    mostFrequentItems.forEach { item ->
//                        Text(
//                            text = item,
//                            fontSize = 16.sp,
//                            color = MaterialTheme.colorScheme.onBackground,
//                            modifier = Modifier.padding(vertical = 4.dp)
//                        )
//                    }
//                } else {
//                    Text(
//                        text = "No data available",
//                        fontSize = 16.sp,
//                        color = Color.Gray,
//                        modifier = Modifier.padding(vertical = 4.dp)
//                    )
//                }
//        }
//    }
//}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphScreenDisplay(
    changeScreen: () -> Unit
) {

    // add code here



    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    Scaffold(
        modifier = Modifier.nestedScroll(
            scrollBehavior.nestedScrollConnection
        ),
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
                Spacer(modifier = Modifier.height(40.dp)) // Space at the bottom of the column
            }
        }
    ){
        paddingValues -> null
    }
        // Your main content goes here, applying any necessary padding
        // Example: Box(modifier = Modifier.padding(paddingValues)) { ... }

}



@Preview(showBackground = true)
@Composable
fun PreviewGraphScreen() {
    GraphScreenDisplay(
        changeScreen = {}
    )
}