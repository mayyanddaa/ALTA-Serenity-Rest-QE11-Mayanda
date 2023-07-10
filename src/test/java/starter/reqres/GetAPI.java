package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetAPI extends Constants {
    public static String SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String LIST_USER = Constants.BASE_URL + "/api/users?page={page}";
    public static String LIST_RESOURCE= BASE_URL + "/api/unknown";

    public static String SINGLE_RESOURCE= BASE_URL + "/api/unknown/{id}";

    //GET SINGLE USER
    @Step("Get valid single user")
    public void setSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get invalid single user")
    public void setInvalidSingleUser(String id){
        SerenityRest.given().pathParam("id", id);
    }

    //GET LIST USER
    @Step("Get valid list user")
    public void setListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }

    //GET LIST RESOURCE
    @Step("Get list resource")
    public void setGetListResource(){
        SerenityRest.given();
    }

    @Step("Get  valid single resource user")
    public void setGetSingleResource(int id){
        SerenityRest.given().pathParam("id", id);
    }


}
