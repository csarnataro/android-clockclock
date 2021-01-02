package mobi.thru.clockclock

import android.app.Activity
import android.os.*
import android.view.*
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : Activity() {

    lateinit var hoursView: DoubleDigitView
    lateinit var minutesView: DoubleDigitView
    var firstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main)
        hoursView = findViewById(R.id.hours_view)
        minutesView = findViewById(R.id.minutes_view)

        //Remove notification bar
        goFullScreen()
        startClock()
    }


    private fun startClock() {
        fixedRateTimer("timer", false, 0L, 1000) {
            this@MainActivity.runOnUiThread {
                val c = Calendar.getInstance()
                val second = c.get(Calendar.SECOND)

                if (firstTime) {
                    val hour = c.get(Calendar.HOUR_OF_DAY)
                    // hour = if (hour > 12) hour - 12 else hour
                    val minute = c.get(Calendar.MINUTE)
                    hoursView.set(hour, true)
                    minutesView.set(minute, true)
                    firstTime = false
                } else {

                    if (second == 50) {
                        c.add(Calendar.MINUTE, 1)
                        val hour = c.get(Calendar.HOUR_OF_DAY)
                        // hour = if (hour > 12) hour - 12 else hour
                        val minute = c.get(Calendar.MINUTE)
                        hoursView.set(hour, true)
                        minutesView.set(minute, true)
                    }
                }
            }
        }
    }


    private fun goFullScreen() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let {
                // Default behavior is that if navigation bar is hidden, the system will "steal" touches
                // and show it again upon user's touch. We just want the user to be able to show the
                // navigation bar by swipe, touches are handled by custom code -> change system bar behavior.
                // Alternative to deprecated SYSTEM_UI_FLAG_IMMERSIVE.
                it.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                // make navigation bar translucent (alternative to deprecated
                // WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                // - do this already in hideSystemUI() so that the bar
                // is translucent if user swipes it up
                window.navigationBarColor =
                    getColor(R.color.internal_black_semitransparent_light)
                // Finally, hide the system bars, alternative to View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                // and SYSTEM_UI_FLAG_FULLSCREEN.
                it.hide(WindowInsets.Type.systemBars())
            }
            window.setDecorFitsSystemWindows(false)
        } else {
            // Enables regular immersive mode.
            // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
            // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    // Do not let system steal touches for showing the navigation bar
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            // Hide the nav bar and status bar
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            // Keep the app content behind the bars even if user swipes them up
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            // make navbar translucent - do this already in hideSystemUI() so that the bar
            // is translucent if user swipes it up
            @Suppress("DEPRECATION")
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }

}