package com.wypeboard.architecturetests;


import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ArchUnitRunner.class)
public class DomainModelTest {
    private static final String COM_WYPEBOARD = "com.wypeboard.";

    @ArchTest
    private static ArchRule domainModelTest = Architectures.onionArchitecture()
            .domainModels(COM_WYPEBOARD + "model..")
            .domainServices(COM_WYPEBOARD + "service..")
            .applicationServices(COM_WYPEBOARD + "webapp..", COM_WYPEBOARD + "controllers..")
            .adapter("ado",COM_WYPEBOARD + "adapter.azuredevops..")
            .adapter("persistence", COM_WYPEBOARD + "adapter.persistence..");
}