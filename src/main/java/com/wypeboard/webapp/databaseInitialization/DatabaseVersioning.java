package com.wypeboard.webapp.databaseInitialization;

import com.wypeboard.webapp.databaseInitialization.versioning.DatabaseVersioningApi;
import com.wypeboard.webapp.databaseInitialization.versioning.Initialization;

import java.util.function.Supplier;

public enum DatabaseVersioning {

    INTIALIZATION(Initialization::new),
    ;

    private final Supplier<DatabaseVersioningApi> constructor;

    DatabaseVersioning(Supplier<DatabaseVersioningApi> constructor) {
        this.constructor = constructor;
    }

    public int getRank() {
        return this.ordinal();
    }

    public String getName() {
        return this.name();
    }

    public DatabaseVersioningApi getVersioning() {
        return constructor.get();
    }
}
