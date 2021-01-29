package prueba.bith.net;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("prueba.bith.net");

        noClasses()
            .that()
            .resideInAnyPackage("prueba.bith.net.service..")
            .or()
            .resideInAnyPackage("prueba.bith.net.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..prueba.bith.net.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
