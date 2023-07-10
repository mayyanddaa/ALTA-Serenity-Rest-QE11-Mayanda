package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetAPI;
import starter.utils.Constants;

import java.io.File;

public class SingleResource {
    @Steps
    GetAPI getAPI;

    @Given("Get single resources with valid parameter {int}")
    public void getSingleResourcesWithValidParameter(int id) {
        getAPI.setGetSingleResource(id);
    }

    @When("User send request get single resource")
    public void userSendRequestGetSingleResource() {
        SerenityRest.when().get(GetAPI.SINGLE_RESOURCE);
    }

    @And("Validate get single resource schema")
    public void validateGetSingleResourceSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/SingleResourceSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
