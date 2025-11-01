package com.activity.one;

/*
Badge (sealed)
    - GoldBadge - non-sealed
        - <>
    - SilverBadge
 */
public final class GoldBadge implements Badge {
    @Override
    public String type() {
        return "Gold Badge";
    }
}
