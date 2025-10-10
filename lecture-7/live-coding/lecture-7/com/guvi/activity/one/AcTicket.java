package com.guvi.activity.one;

public class AcTicket extends TrainTicket {
    public AcTicket(String p, String coachT) {
        super(p, coachT);
    }

    @Override
    public int fare(int km) {
        return (km <= 0) ? 0 : km * 3;
    }

    @Override
    public String coachType() {
        return "AC";
    }
}
