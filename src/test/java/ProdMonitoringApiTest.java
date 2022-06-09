
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Story("Мониторинг")
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

    public void addAllureLog()  {
        String fileName = "Путь к лог файлу для Allure";
        String content = null;
        try {
            content = Files.lines(Paths.get(fileName)).reduce("",(a, b) -> a + "\n" + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = content.split("Запущен тест: ");
        int i = split.length - 1;
        String s = split[i];
        Allure.getLifecycle().updateTestCase((t) -> {
            t.setStatusDetails( t.getStatusDetails().setMessage(s));
        });
    }
}