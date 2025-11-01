package com.activity.one;

public record BronzeBadge() implements Badge {
    @Override
    public String type() {
        return "Bronze Badge";
    }
}
