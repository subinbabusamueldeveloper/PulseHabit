package com.pulsehabit.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pulsehabit.app.core.navigation.NavRoutes

@Composable
fun PulseHabitApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.DASHBOARD
    ) {
        composable(NavRoutes.DASHBOARD) {
            DashboardStub(onOpenMetricDetail = { navController.navigate(NavRoutes.METRIC_DETAIL) })
        }
        composable(NavRoutes.METRIC_DETAIL) {
            MetricDetailStub(onBack = { navController.popBackStack() })
        }
    }
}