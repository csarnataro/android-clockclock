package mobi.thru.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.gridlayout.widget.GridLayout

class TimeView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(context, attrs, defStyleAttr) {

    init {
        println("****** In TimeView INIT ******")

        inflate(context, R.layout.time_view, this)

//        val imageView: ImageView = findViewById(R.id.image)
//        val textView: TextView = findViewById(R.id.caption)
//
//        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)
//        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
//        textView.text = attributes.getString(R.styleable.BenefitView_text)
//        attributes.recycle()

    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)


//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        println("**************** Grid size: ${gridLayout.layoutParams.width} X ${gridLayout.layoutParams.height}}")
//        gridLayout.draw(canvas)
//        drawBackground(canvas)
//        drawBorder(canvas)
//        canvas.drawText("TEXT", 100F, 100F, Paint().apply {
//            color = Color.RED
//            strokeWidth = 1.5f
//            textSize = 30F
//            style = Paint.Style.FILL_AND_STROKE
//        })
//        // clockDrawable.into(clocks)
////        // drawText(canvas)
////        // drawCircle(canvas)
////        // drawCenter(canvas)
////        // drawHands(canvas)
//        postInvalidateDelayed(1000)
//        invalidate()
//    }
//
//    private fun drawBorder(canvas: Canvas) {
//        val paint = Paint()
//        paint.color = Color.RED
//        paint.strokeWidth = 10.5f
//        paint.style = Paint.Style.STROKE
//        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
//    }
//
//    private fun drawBackground(canvas: Canvas) {
//        canvas.drawColor(Color.CYAN)
//    }
}