package com.wypeboard.service.front;

import org.springframework.stereotype.Component;

@Component
public class FrontHelper {

    public String getId(String orgField) {
        if (orgField.contains(".")) {
            int dotIdeks = orgField.indexOf(".") + 1;
            orgField = orgField.substring(dotIdeks);
        }
        return orgField.replace("[","").replace("]", "");
    }

    public String getField(String orgField) {
        String[] strings = orgField.split("\\.");
        return strings[strings.length - 1];
    }
}
