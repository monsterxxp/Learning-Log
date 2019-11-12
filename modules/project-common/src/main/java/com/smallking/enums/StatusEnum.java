package com.smallking.enums;

public enum StatusEnum {
    DELETED("0", "已删除"),
    ENABLE("1", "启用"),
    DISABLE("2", "禁用");

    private final String code;
    private final String name;

    private StatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}