package com.wypeboard.core.exception;

import jakarta.persistence.Query;

import java.util.HashMap;

public class JpqlQueryBuilder {

    private Query query;
    private HashMap<String, Object> parameters;

    public JpqlQueryBuilder() {
    }

    public JpqlQueryBuilder(String query) {
        this.query = new Query();
    }

    public Query getQuery() {
        return query;
    }

    public JpqlQueryBuilder withQuery(Query query) {
        this.query = query;
        return this;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public JpqlQueryBuilder withParameter(String key, Object object) {
        this.parameters.put(key, object);
        return this;
    }
}
