package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetAPI;
import starter.reqres.PostAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class Register {
    @Steps
    PostAPI postAPI;

    //POST VALID REGISTER
    @Given("Create new register user with valid json")
    public void createNewRegisterUserWithValidJson() {
        File json = new File(Constants.REQ_BODY + "/Register.json");
        postAPI.setRegister(json);
    }
    @When("User send request post register user")
    public void userSendRequestPostRegisterUser() {
        SerenityRest.when().post(PostAPI.REGISTER);
    }
    @And("Response body should be {int} as id and {string} as token")
    public void responseBodyShouldBeAsIdAndAsToken(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate register json schema")
    public void validateRegisterJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/RegisterSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //POST INVALID REGISTER
    @Given("Create new register with invalid json")
    public void createNewRegisterWithInvalidJson() {
        File json = new File(Constants.REQ_BODY + "/InvalidRegister.json");
        postAPI.setRegister(json);

    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badReq) {
        SerenityRest.then().statusCode(badReq);
    }
    @And("Response body should be {string} as error message")
    public void responseBodyShouldBeAsErrorMessage(String message) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(message));
    }
    @And("Validate unsuccesful register schema")
    public void validateUnsuccesfulRegisterSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/InvalidRegister.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
