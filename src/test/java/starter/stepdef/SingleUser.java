package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleUser {
    @Steps
    GetAPI getAPI;

    //GET VALID SINGLE USER
    @Given("Get single user with valid parameter {int}")
    public void getSingleUserWithValidParameter(int id) {
        getAPI.setSingleUser(id);
    }

    @When("User send request get single user")
    public void userSendRequestGetSingleUser() {
        SerenityRest.when().get(GetAPI.SINGLE_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and().body("data.id", equalTo(id));
    }

    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET INVALID SINGLE USER
    @Given("Get single user with invalid parameter {string}")
    public void getSingleUserWithInvalidParameter(String id) {
        getAPI.setInvalidSingleUser(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

}
