package com.wypeboard.architecturetests;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.wypeboard")
public class DomainModelTest {
    private static final String COM_WYPEBOARD = "com.wypeboard.";

    @ArchTest
    @ArchIgnore
    private static ArchRule domainModelTest = Architectures.onionArchitecture()
            .domainModels(COM_WYPEBOARD + "model..")
            .domainServices(COM_WYPEBOARD + "service..")
            .applicationServices(COM_WYPEBOARD + "webapp..", COM_WYPEBOARD + "controllers..")
            .adapter("ado",COM_WYPEBOARD + "adapter.azuredevops..")
            .adapter("persistence", COM_WYPEBOARD + "adapter.persistence..");
}