package com.activity.one;

sealed interface Badge permits GoldBadge, SilverBadge, BronzeBadge {
    // String type;
    public String type();

}
