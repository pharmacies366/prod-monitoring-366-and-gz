import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static io.restassured.RestAssured.*;

@Feature(value = "Прод - Мониторинг")
@Story("Проверка доступности сайтов аптек 366 и Горздрав")
@DisplayName("Проверка доступности сайтов аптек 366 и Горздрав")
public class ProdMonitoringApiTest {

    @DisplayName("Мониторинг доступности сайта https://366.ru/")
    @Test
    public void checkSite366() {
        given().
                when().get("https://366.ru/").
                then().statusCode(400);
    }

    @DisplayName("Мониторинг доступности сайта https://gorzdrav.org/")
    @Test
    public void checkSiteGz() {
        given().
                when().get("https://gorzdrav.org/").
                then().statusCode(400);
    }
}
