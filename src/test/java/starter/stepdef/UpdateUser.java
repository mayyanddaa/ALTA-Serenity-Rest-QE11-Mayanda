package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PutAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUser {
    @Steps
    PutAPI putAPI;

    @Given("Put update user with valid id {int} and json")
    public void givenPutUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY + "/UpdateUser.json");
        putAPI.setUpdateUser(id, json);
    }

    @When("User send request update user")
    public void userSendRequestUpdateUser() {
        SerenityRest.when().put(PutAPI.UPDATE_USER);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate put update user schema")
    public void validatePutUpdateUserSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/UpdateUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
