package com.example.homestaymanagementgroup_four.model.enums;

public enum SearchOperation implements BaseEnum<String> {

    GREATER_THAN("gt", "gt"),
    LESS_THAN("lt", "lt"),
    GREATER_THAN_EQUAL("gte", "gte"),
    LESS_THAN_EQUAL("lte", "lte"),
    NOT_EQUAL("neq", "neq"),
    EQUAL("eq", "eq"),
    MATCH("like", "like"),
    MATCH_START("like_start", "like_start"),
    MATCH_END("like_end", "like_end"),
    IN("in", "in"),
    NOT_IN("not_in", "not_in");

    private final String value;
    private final String displayName;

    private SearchOperation(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return this.value;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static SearchOperation parse(String value) {
        SearchOperation[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SearchOperation v = var1[var3];
            if (v.getValue().equals(value)) {
                return v;
            }
        }

        return null;
    }
}
