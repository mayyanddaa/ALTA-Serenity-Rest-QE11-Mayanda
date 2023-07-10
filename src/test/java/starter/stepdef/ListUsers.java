package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUsers {
    @Steps
    GetAPI getAPI;

    //GET VALID LIST USERS
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        getAPI.setListUser(page);
    }

    @When("User send request get list users")
    public void userSendRequestGetListUsers() {
        SerenityRest.when().get(GetAPI.LIST_USER);
    }

    @Then("Response value body page should be {int}")
    public void responseValueBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user JSON schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/ListUsersSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
