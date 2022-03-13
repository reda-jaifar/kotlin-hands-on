package sportair

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import digital.doublr.sportair.exerciseOutside
import kotlin.test.assertEquals

class StepDefs {

    private var temperature: Int = 18
    private lateinit var response: String

    @Given("^The temperature is (.+)$")
    fun `The temperature is`(temperature: Int) {
        this.temperature = temperature
    }

    @When("^I ask whether I can exercise outside$")
    fun `I ask whether I can exercise outside`(){
        response = exerciseOutside(temperature)
    }

    @Then("^I should be told (.+)$")
    @Throws(Exception::class)
    fun `I should be told`(expectedResponse: String){
        assertEquals(expectedResponse, this.response)
    }
}