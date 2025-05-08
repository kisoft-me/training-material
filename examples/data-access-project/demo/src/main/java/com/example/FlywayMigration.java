package com.example;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public static void migrateDatabase(String url, String user, String password) {
        Flyway flyway = Flyway.configure()
            .dataSource(url, user, password)
            .locations("classpath:db/migration")
            .baselineOnMigrate(true)
            .baselineVersion("0")  // Explicit baseline version
            .validateOnMigrate(true)
            .cleanOnValidationError(true) // Auto-clean if validation fails
            .cleanDisabled(false)
            .load();
        flyway.clean();        
        flyway.migrate();
    }
}
