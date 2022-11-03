package com.back.inditex.qa.postcreateuser;

import com.back.inditex.qa.resources.Utils;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import static com.back.inditex.qa.resources.GenerateCucumberReportParallel.generateReport;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserRunner {
    private static final String fs = File.separator;
    private static final String karateEnv = "dev";
    private static final String projectName = "postcreateuser";
    private static final String target = "target/cucumber-reports" + fs + projectName + fs + karateEnv + fs + Utils.getTimeStamp();
    public static Collection<File> jsonFiles = new LinkedList();
    String[] tags = {"~@ignore"};
    @AfterAll
    public static void AfterAll() {
        generateReport(jsonFiles, target, projectName);
    }
    @Test
    @Order(1)
    public void testGetCollectionMethod() {
        String testName = new Exception().getStackTrace()[0].getMethodName();
        Results result = Runner.path("classpath:com/back/inditex/qa/postcreateuser/createuser.feature")
                .reportDir(target + fs + testName)
                .karateEnv(karateEnv)
                .tags(tags)
                .systemProperty("readTimeout", "40000")
                .outputCucumberJson(true)
                .parallel(1);
        jsonFiles.addAll(FileUtils.listFiles(new File(result.getReportDir()), new String[]{"json"}, true));
        assertEquals(0, result.getFailCount(), result.getErrorMessages());
    }
}
