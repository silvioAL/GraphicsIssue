package teste.teste.graphicsissue

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GridLabelRenderer
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import teste.teste.graphicsissue.databinding.ActivityGraphicsBinding
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class GraphicsActivity : AppCompatActivity() {

     lateinit var binding: ActivityGraphicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_graphics)

        val graphicData = ArrayList<DataModel>()
        graphicData.add(DataModel("1847", "53396", "1414.0", "433.0", "2018-04-01T00:00:00", "Oficial"))
        graphicData.add(DataModel("2871", "53396", "1261.0", "433.0", "2018-04-02T00:00:00", "Oficial"))
        graphicData.add(DataModel("3871", "53396", "781.0", "1414.0", "2018-04-03T00:00:00", "Oficial"))
        graphicData.add(DataModel("5409", "53396", "1364.0", "1024.0", "2018-04-04T00:00:00", "Oficial"))
        graphicData.add(DataModel("7368", "53396", "1762.0", "2538.0", "2018-04-05T00:00:00", "Oficial"))
        graphicData.add(DataModel("8324", "53396", "2111.0", "1959.0", "2018-04-06T00:00:00", "Oficial"))
        graphicData.add(DataModel("9700", "53396", "1299.0", "1936.0", "2018-04-07T00:00:00", "Oficial"))
        graphicData.add(DataModel("10200", "53396", "1231.0", "1977.0", "2018-04-08T00:00:00", "Oficial"))
        graphicData.add(DataModel("11283", "53396", "963.0", "690.0", "2018-04-09T00:00:00", "Oficial"))
        graphicData.add(DataModel("13883", "53396", "1611.0", "1784.0", "2018-04-10T00:00:00", "Oficial"))
        graphicData.add(DataModel("15001", "53396", "1233.0", "2217.0", "2018-04-11T00:00:00", "Oficial"))
        graphicData.add(DataModel("17200", "53396", "1163.0", "1379.0", "2018-04-12T00:00:00", "Oficial"))
        graphicData.add(DataModel("19028", "53396", "763.0", "2217.0", "2018-04-13T00:00:00", "Oficial"))
        graphicData.add(DataModel("29388", "53396", "2873.0", "1784.0", "2018-04-14T00:00:00", "Oficial"))
        graphicData.add(DataModel("30112", "53396", "1363.0", "1784.0", "2018-04-15T00:00:00", "Oficial"))
        graphicData.add(DataModel("31826", "53396", "1263.0", "1977.0", "2018-04-16T00:00:00", "Oficial"))
        graphicData.add(DataModel("32988", "53396", "1763.0", "433.0", "2018-04-17T00:00:00", "Oficial"))
        graphicData.add(DataModel("33872", "53396", "0.0", "1959.0", "2018-04-18T00:00:00", "Espelhamento"))
        graphicData.add(DataModel("34882", "53396", "0.0", "433.0", "2018-04-19T00:00:00", "Espelhamento"))
        graphicData.add(DataModel("35873", "53396", "0.0", "1784.0", "2018-04-20T00:00:00", "Espelhamento"))
        graphicData.add(DataModel("36927", "53396", "0.0", "1784.0", "2018-04-21T00:00:00", "Tendencia"))
        graphicData.add(DataModel("37928", "53396", "0.0", "1379.0", "2018-04-22T00:00:00", "Tendencia"))
        graphicData.add(DataModel("38928", "53396", "0.0", "433.0", "2018-04-23T00:00:00", "Tendencia"))
        graphicData.add(DataModel("39018", "53396", "0.0", "690.0", "2018-04-24T00:00:00", "Tendencia"))
        graphicData.add(DataModel("42032", "53396", "0.0", "433.0", "2018-04-25T00:00:00", "Tendencia"))
        graphicData.add(DataModel("44221", "53396", "0.0", "2217.0", "2018-04-26T00:00:00", "Tendencia"))
        graphicData.add(DataModel("48828", "53396", "0.0", "2613.0", "2018-04-27T00:00:00", "Tendencia"))
        graphicData.add(DataModel("51287", "53396", "0.0", "1652.0", "2018-04-28T00:00:00", "Tendencia"))
        graphicData.add(DataModel("52300", "53396", "0.0", "1256.0", "2018-04-29T00:00:00", "Tendencia"))
        graphicData.add(DataModel("53396", "53396", "0.0", "1923.0", "2018-04-30T00:00:00", "Tendencia"))



        //content
        var targetSerieContent = arrayListOf<DataPoint>()
        var mirrorContent = arrayListOf<DataPoint>()
        var sellsBarSerieContent = arrayListOf<DataPoint>()
        var projectionSerieContent = arrayListOf<DataPoint>()
        var acumulatedSerieContent = arrayListOf<DataPoint>()

        lateinit var scaleMaxRangeX: Date
        lateinit var scaleMinRangeX: Date
        var YSecondScaleMinRange: Double = 0.0
        var YSecondScaleMaxRange: Double = 0.0
        var YScaleMinRange: Double = 0.0
        var YScaleMaxRange: Double = 0.0

        var isFirst = true
        var firstRange = true
        //   val formatter = StringUtils()
        lateinit var sellsLegacyLastXAxis: Date
        var sellsLegacyLastYAxis = 0.0

        fun checkHigherForScale(num: Double){
            if(num > YScaleMaxRange){
                YScaleMaxRange = num}
        }

        fun checkHigherForSecondScale(num: Double){
            if(num > YSecondScaleMaxRange){
                YSecondScaleMaxRange = num}
        }

        val calendar = Calendar.getInstance()
        for ((index, block:DataModel) in graphicData.withIndex()) {

            calendar.time
            calendar.add(Calendar.DATE, 1)

            when {
                block.type == "Oficial" -> {

                    if (firstRange) {
                        scaleMinRangeX = calendar.time
                        firstRange = false
                        YSecondScaleMinRange = BigDecimal(block.blueLine.replace(",", ".")).toDouble()
                    }

                    sellsBarSerieContent.add(DataPoint(calendar.time, BigDecimal(block.blueBar.replace(",", ".")).toDouble()))
                    acumulatedSerieContent.add(DataPoint(calendar.time, BigDecimal(block.redLine.replace(",", ".")).toDouble()))
                    sellsLegacyLastYAxis = BigDecimal(block.redLine.replace(",", ".")).toDouble()
                    sellsLegacyLastXAxis = calendar.time
                    scaleMaxRangeX = calendar.time
                }
                block.type == "Tendencia" -> {

                    if (isFirst) {
                        projectionSerieContent.add(DataPoint(sellsLegacyLastXAxis, sellsLegacyLastYAxis))
                        isFirst = false
                    }
                    projectionSerieContent.add(DataPoint(calendar.time, BigDecimal(block.redLine.replace(",", ".")).toDouble()))


                }
                block.type == "Espelhamento" -> mirrorContent.add(DataPoint(calendar.time, BigDecimal(block.blueBar.replace(",", ".")).toDouble()))
            }

            targetSerieContent.add(DataPoint(calendar.time, BigDecimal(block.blueLine.replace(",", ".")).toDouble()))

            checkHigherForScale(BigDecimal(block.blueBar.replace(",", ".")).toDouble())
            checkHigherForSecondScale(BigDecimal(block.blueLine.replace(",", ".")).toDouble())
            checkHigherForSecondScale(BigDecimal(block.redLine.replace(",", ".")).toDouble())


        }

        //series
        val targetSerie = LineGraphSeries<DataPoint>(targetSerieContent.toTypedArray())
        val mirrorSerie = BarGraphSeries<DataPoint>(mirrorContent.toTypedArray())
        val sellsSerie = BarGraphSeries<DataPoint>(sellsBarSerieContent.toTypedArray())
        val acumulatedSerie = LineGraphSeries<DataPoint>(acumulatedSerieContent.toTypedArray())
        val projectionSerie = LineGraphSeries<DataPoint>(projectionSerieContent.toTypedArray())

        projectionSerie.color = Color.parseColor("#6ba600")
        targetSerie.color = Color.parseColor("#ffffff")
        mirrorSerie.color = Color.parseColor("#f8aa08")
        sellsSerie.color = Color.parseColor("#003264")
        acumulatedSerie.color = Color.parseColor("#c6270d")

        val paint = Paint()
        //    paint.style = Paint.Style.FILL
        paint.color = Color.parseColor("#007eb0")
        paint.strokeWidth = (10F)
        paint.style = Paint.Style.STROKE;
        paint.pathEffect = DashPathEffect(floatArrayOf(8f, 5f), 0f)


        //  paint.pathEffect = DashPathEffect(floatArrayOf(8f, 5f), 0f)
        targetSerie.setCustomPaint(paint)
        //  targetSerie.isDrawDataPoints = true
        targetSerie.dataPointsRadius = (10F)
        targetSerie.thickness = 8
        targetSerie.isDrawAsPath = true


        //date labels
        //   binding.graphView.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(binding.graphView.context, SimpleDateFormat("dd/MM", Locale("pt", "BR")))
        binding.graphView.gridLabelRenderer.numHorizontalLabels = 0
        binding.graphView.viewport.isXAxisBoundsManual = true


        binding.graphView.viewport.setMinX(scaleMinRangeX.time.toDouble())
        binding.graphView.viewport.setMaxX(scaleMaxRangeX.time.toDouble())
        binding.graphView.viewport.isYAxisBoundsManual = true
        binding.graphView.gridLabelRenderer.verticalAxisTitleTextSize = 10f
        binding.graphView.viewport.setBorderPaint(paint)
        binding.graphView.viewport.setMinY(YScaleMinRange)
        binding.graphView.viewport.setMaxY(YScaleMaxRange)
        binding.graphView.secondScale.setMinY(YSecondScaleMinRange)
        binding.graphView.secondScale.setMaxY(YSecondScaleMaxRange)
        binding.graphView.viewport.isScalable = false
        binding.graphView.gridLabelRenderer.isVerticalLabelsVisible = true
        binding.graphView.gridLabelRenderer.isHorizontalLabelsVisible = true
        binding.graphView.gridLabelRenderer.labelsSpace = 20

        binding.graphView.viewport.isScrollable = true
        binding.graphView.gridLabelRenderer.gridStyle = GridLabelRenderer.GridStyle.VERTICAL

        binding.graphView.gridLabelRenderer.padding = 22


        val nf = NumberFormat.getInstance()
        nf.maximumFractionDigits = 0

        sellsSerie.spacing = 30
        mirrorSerie.spacing = 30


        binding.graphView.addSeries(sellsSerie)
        binding.graphView.addSeries(mirrorSerie)

        binding.graphView.secondScale.addSeries(projectionSerie)
        binding.graphView.secondScale.addSeries(acumulatedSerie)
        binding.graphView.secondScale.addSeries(targetSerie)

        binding.graphView.invalidate()




    }
}
