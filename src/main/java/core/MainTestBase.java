package core;

import listener.RetryRule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class MainTestBase {

    protected Logger logger = LogManager.getLogger(MainTestBase.class);

    /**
     * Управление действиями, при различных исходах теста
     */

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.info("Тест упал");
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("Тест успешно завершен");
        }

    };

    /*
     * Повторный запуск тестов при падении
     */

    @Rule
    public RetryRule rule = new RetryRule(4);

}
