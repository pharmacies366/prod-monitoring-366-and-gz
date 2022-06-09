import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

@Story("Мониторинг")
@DisplayName("Проверка доступности сайта аптек Горздрав")
public class ProdMonitoringApiTest {

/*    @DisplayName("Мониторинг доступности сайта https://gorzdrav.org/")
    @Test
    public void checkSite366() {
        given().
                when().get("https://gorzdrav.org/").
                then().statusCode(200);
    }
    */

    @DisplayName("Мониторинг доступности сайта https://gorzdrav.org/")
    @Test
    public void checkSiteGorzdrav() {
        Response response = RestAssured.get("https://gorzdrav.org/");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
