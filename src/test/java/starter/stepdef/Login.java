package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class Login {
    @Steps
    PostAPI postAPI;

    //POST VALID LOGIN
    @Given("Login with existing user with valid json")
    public void loginWithExistingUserWithValidJson() {
        File json = new File(Constants.REQ_BODY + "/Login.json");
        postAPI.setLogin(json);
    }

    @When("User send request post login user")
    public void userSendRequestPostLoginUser() {
        SerenityRest.when().post(PostAPI.LOGIN);
    }

    @And("Response body should be {string} as token")
    public void responseBodyShouldBeAsToken(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate login json schema")
    public void validateLoginJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/LoginSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //POST INVALID LOGIN
    @Given("Login with existing user with invalid json")
    public void loginWithExistingUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY + "/InvalidLogin.json");
        postAPI.setLogin(json);
    }

    @And("Validate unsuccesful login schema")
    public void validateUnsuccesfulLoginSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/InvalidLoginSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
