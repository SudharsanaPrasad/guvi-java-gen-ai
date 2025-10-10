package com.guvi.activity.one;

public abstract class TrainTicket {
    private final String pnr;
    private String coachType;

    public TrainTicket(String p, String coachType) {
        this.pnr = p;
        this.coachType = coachType;
    }

    // must implement
    public abstract int fare(int km);

    public String coachType() {
        return coachType;
    }
}
