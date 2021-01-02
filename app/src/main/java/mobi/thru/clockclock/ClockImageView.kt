package mobi.thru.clockclock

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet

/**
 * Created by alex
 */

class ClockImageView : androidx.appcompat.widget.AppCompatImageView /*, Animatable */ {
  private var clock = ClockDrawable(context)

  var hours: Float
    get() = clock.hours
    set(value) {
      clock.hours = value
    }

  var minutes: Float
    get() = clock.minutes
    set(value) {
      clock.minutes = value
    }

//  override var timeSetDuration: Long
//    get() = clock.timeSetDuration
//    set(value) {
//      clock.timeSetDuration = value
//    }
//
//  override var timeSetInterpolator: TimeInterpolator
//    get() = clock.timeSetInterpolator
//    set(value) {
//      clock.timeSetInterpolator = value
//    }
//
//  override var animationListener: Animator.AnimatorListener?
//    get() = clock.animationListener
//    set(value) {
//      clock.animationListener = value
//    }

  constructor(context: Context?) : this(context, null)

  constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs,
      defStyleAttr) {
    attrs?.let {
      inflateAttrs(attrs)
    }

    setImageDrawable(clock)
  }

  override fun setImageDrawable(drawable: Drawable?) {
    super.setImageDrawable(drawable)

    if (drawable is ClockDrawable) {
      clock = drawable
    }
  }

//  override fun animateToTime(hours: Int, minutes: Int) = clock.animateToTime(hours, minutes)
//
//  override fun animateIndeterminate() = clock.animateIndeterminate()

//  override fun isRunning() = clock.isRunning
//
//  override fun start() = clock.start()
//
//  override fun stop() = clock.stop()

  private fun inflateAttrs(attrs: AttributeSet) {
    val resAttrs = context.theme.obtainStyledAttributes(
        attrs,
        R.styleable.ClockImageView,
        0,
        0
    ) ?: return

    with(resAttrs) {
      hours = getFloat(R.styleable.ClockImageView_hours, hours)
      minutes = getFloat(R.styleable.ClockImageView_minutes, minutes)
      recycle()
    }
  }

  fun animateToTime(hours: Float, minutes: Float) {
    clock.animateToTime(hours, minutes)
  }
}