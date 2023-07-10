package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DeleteAPI;

public class DeleteUser {
    @Steps
    DeleteAPI deleteAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        deleteAPI.setDeleteUser(id);
    }

    @When("User send request delete user")
    public void userSendRequestDeleteUser() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
