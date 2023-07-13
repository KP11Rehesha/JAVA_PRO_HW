package org.example;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

public class TestRunner {
    public static void main(String[] args) {
        ProjectTestRunner testRunner = new ProjectTestRunner();

        // Запуск тестів за іменами класів (рядкове значення)
        testRunner.runTestByClassName("SimpleMathLibraryTest");

        // Запуск тестів за іменами класів (тип даних клас)
        testRunner.runTestByClass(SimpleMathLibraryTest.class);

        // Запуск тесту на ім'я класу (рядкове значення)
        testRunner.runTestByClassName("SimpleMathLibraryTest");

        // Запуск тесту на ім'я класу (тип даних клас)
        testRunner.runTestByClass(SimpleMathLibraryTest.class);


        // Отримання результатів виконання тестів
        Result result = testRunner.getTestResult();

        // Виведення результатів в консоль
        System.out.println("Test run finished after " + result.getRunTime() + " ms");
        System.out.println("[ " + result.getRunCount() + " containers found ]");
        System.out.println("[ " + result.getIgnoreCount() + " containers skipped ]");
        System.out.println("[ " + (result.getRunCount() - result.getIgnoreCount()) + " containers started ]");
        System.out.println("[ " + result.getFailureCount() + " containers aborted ]");
        System.out.println("[ " + (result.getRunCount() - result.getFailureCount()) + " containers successful ]");
        System.out.println("[ " + result.getRunCount() + " tests found ]");
        System.out.println("[ " + result.getIgnoreCount() + " tests skipped ]");
        System.out.println("[ " + result.getFailureCount() + " tests failed ]");
    }
}
