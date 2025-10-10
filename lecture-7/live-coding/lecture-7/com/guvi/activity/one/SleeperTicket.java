package com.guvi.activity.one;

public class SleeperTicket extends TrainTicket {
    public SleeperTicket(String p, String coachT) {
        super(p, "Sleeper");
    }

    @Override
    public int fare(int km) {
        if(km <= 0) {
            return 0;
        } else {
            return km * 2;
        }
    }

    @Override
    public String coachType() {
        return "Sleeper";
    }
}
