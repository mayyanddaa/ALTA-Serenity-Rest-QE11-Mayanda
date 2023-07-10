package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostAPI extends Constants {
    public static String REGISTER = Constants.BASE_URL + "/api/register";
    public static String LOGIN = Constants.BASE_URL + "/api/login";
    public static String CREATE_USER = Constants.BASE_URL + "/api/users";

    @Step("Post register user acc")
    public void setRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post login user")
    public void setLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post create new user")
    public void setCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
