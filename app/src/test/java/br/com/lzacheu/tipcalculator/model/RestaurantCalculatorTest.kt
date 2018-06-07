package br.com.lzacheu.tipcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RestaurantCalculatorTest {

    lateinit var calculator: RestaurantCalculator

    @Before
    fun setup() {
        calculator = RestaurantCalculator()
    }

    @Test
    fun testCalculateTip() {
        val baseTc = TipCalculation(checkAmount = 10.0)

        val testVals = listOf(baseTc.copy(tipPct = 25, tipAmount = 2.50, grantTotal = 12.50),
                baseTc.copy(tipPct = 15, tipAmount = 1.5, grantTotal = 11.50),
                baseTc.copy(tipPct = 18, tipAmount = 1.8, grantTotal = 11.80))

        testVals.forEach {
            assertEquals(it, calculator.calculateTip(it.checkAmount, it.tipPct))
        }

    }
}