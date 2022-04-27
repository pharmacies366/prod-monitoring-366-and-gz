import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Прод - Мониторинг")
@Story("Проверка доступности сайта аптек 366")
@DisplayName("Проверка доступности сайта аптек 366")
public class ProdMonitoringApiTest {

/*    @DisplayName("Мониторинг доступности сайта https://366.ru/")
    @Test
    public void checkSite366() {
        given().
                when().get("https://366.ru/").
                then().statusCode(200);
    }
    */

    @DisplayName("Мониторинг доступности сайта https://366.ru/")
    @Test
    public void checkSite366() {
        Response response = RestAssured.get("https://366.ru/");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
