package com.wypeboard.model.logical;

import java.util.Map;

public record Systemparameter(String id,
                              String type,
                              String instance,
                              Map<String, String> keyValue) {
}
