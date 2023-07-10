package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DeleteAPI {
    public static  String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    @Step("Delete user")
    public void setDeleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
