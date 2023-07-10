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


public class ListResource {
    @Steps
    GetAPI getAPI;

    @Given("Get list resource")
    public void getListResource() {
        getAPI.setGetListResource();
    }

    @When("User send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(GetAPI.LIST_RESOURCE);
    }

    @And("Validate get list resource schema")
    public void validateGetListResourceSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/ListResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
