package org.example;

import org.junit.platform.suite.api.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.model.InitializationError;

public class ProjectTestRunner {
    private Result testResult;

    public void runTestByClassName(String className) {
        try {
            Class<?> testClass = Class.forName(className);
            runTestByClass(testClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void runTestByClass(Class<?> testClass) {
        Result result = JUnitCore.runClasses(testClass);
        setTestResult(result);
        printTestFailures(result);
    }



    private void printTestFailures(Result result) {
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

    private void setTestResult(Result result) {
        this.testResult = result;
    }

    public Result getTestResult() {
        return testResult;
    }
}