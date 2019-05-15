

android:id="@+id/my_nav_host_fragment" 
android:name="androidx.navigation.fragment.NavHostFragment" 
app:defaultNavHost="true"
 app:navGraph="@navigation/mobile_navigation"

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return item.onNavDestinationSelected(findNavController(R.id.main_nav_host_fragment))
            || super.onOptionsItemSelected(item)
}

override fun onSupportNavigateUp(): Boolean {
    return findNavController(R.id.main_nav_host_fragment).navigateUp(appBarConfiguration)
}

    val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.mobile_navigation)
            .setDestination(R.id.fragment_house_detail_dest)
            .createPendingIntent()

