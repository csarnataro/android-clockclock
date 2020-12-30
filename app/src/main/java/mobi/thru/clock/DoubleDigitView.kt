package mobi.thru.clock

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.gridlayout.widget.GridLayout

class DoubleDigitView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(
    context,
    attrs,
    defStyleAttr
) {
    fun set(value: Int) {
        if (value >= 10) {
            firstDigit.set(value/10)
            secondDigit.set(value%10)

        } else {
            firstDigit.set(0)
            secondDigit.set(value)
        }

    }

    var firstDigit: DigitView
    var secondDigit: DigitView

    init {
        Log.d("DoubleDigitView","****** In DoubleDigitView INIT ******")
        inflate(context, R.layout.double_digit_view, this);

        firstDigit = findViewById(R.id.first_digit)
        secondDigit = findViewById(R.id.second_digit)

    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

}