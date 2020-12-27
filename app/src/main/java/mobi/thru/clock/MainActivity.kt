package mobi.thru.clock

import android.app.Activity
import android.os.*
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.gridlayout.widget.GridLayout
import java.util.*
import kotlin.concurrent.fixedRateTimer

const val ROWS = 4
const val COLS = 1

data class Time(val hour: Number, val minute: Number)

class MainActivity : Activity() {

    val digits = Array(9) {
        arrayOf( // 0
            Time(hour = 6, minute = 15),
            Time(hour = 9, minute = 30),
            Time(hour = 6, minute = 0),
            Time(hour = 0, minute = 30),
            Time(hour = 3, minute = 0),
            Time(hour = 0, minute = 45)
        )
    }

    lateinit var clockDrawables: Array<DigitView?>
    lateinit var gridLayout: GridLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main)

        // clock = findViewById(R.id.clocks)
        //Remove notification bar
        hideBottomNavigationBar()
        // buildClockGrid()
        // startClock()
    }

    private fun buildClockGrid() {
        gridLayout = findViewById(R.id.grid_layout)
        gridLayout.columnCount = COLS
        gridLayout.rowCount = ROWS

        clockDrawables = Array(ROWS * COLS) { null }

        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {

                val digit = DigitView(applicationContext)

                // val clocks = ImageView(applicationContext)

                val layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                val outMetrics = DisplayMetrics()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val display = this.display
                    display?.getRealMetrics(outMetrics)
                } else {
                    @Suppress("DEPRECATION")
                    val display = this.windowManager.defaultDisplay
                    @Suppress("DEPRECATION")
                    display.getMetrics(outMetrics)
                }

                val height = outMetrics.heightPixels / ROWS
                val width = outMetrics.widthPixels / COLS


                layoutParams.width = width
                layoutParams.height = width

                digit.layoutParams = layoutParams
                // val d = ClockDrawable(applicationContext)

                val index = col + (row * COLS)


                /*

                     0  1  2  3  4  5  6  7
                     8  9 10 11 12 13 14 15
                    16 17 18 19 20 21 22 23

                 */

                /*
                     0  1  8  9
                     2  3 10 11
                     4  5 12 13
                     6  7 14 15
                 */



//                d.index = index
                clockDrawables[index] = digit // d.into(clocks)
//                println(">>>>>>>> $index")
//                clocks.setImageDrawable(d)
                gridLayout.addView(digit, index)
            }

        }

    }

    private fun startClock() {
        fixedRateTimer("timer", false, 0L, 1000) {
            this@MainActivity.runOnUiThread {
                // tvTime.text = SimpleDateFormat("dd MMM - HH:mm", Locale.US).format(Date())
                val c = Calendar.getInstance()
                var hour = c.get(Calendar.HOUR_OF_DAY)
                hour = if (hour > 12) hour - 12 else hour
                var minute = c.get(Calendar.MINUTE)
                var second = c.get(Calendar.SECOND)
                Log.d("CLOCK", ">>>>>>> it's $hour:$minute:$second")


                for (i in 0 until ROWS * COLS) {
                    // clockDrawables[i]!!.hours = digits[i][0].hour.toFloat()
                    // clockDrawables[i]!!.minute = digits[i][0].minute.toFloat()
                    val digit: Time = when (i) {
                        0 -> digits[0][0]
                        1 -> digits[0][1]
                        8 -> digits[0][2]
                        9 -> digits[0][3]
                        16 -> digits[0][4]
                        17 -> digits[0][5]

                        2 -> digits[0][0]
                        3 -> digits[0][1]
                        10 -> digits[0][2]
                        11 -> digits[0][3]
                        18 -> digits[0][4]
                        19 -> digits[0][5]
                        else -> Time(0, 0)
                    }
//                    clockDrawables[i]!!.hours = digit.hour.toFloat()
//                    clockDrawables[i]!!.minute = digit.minute.toFloat()
                    /* 1 ->


                     */
                }
            }
        }
    }


    private fun hideBottomNavigationBar() {
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