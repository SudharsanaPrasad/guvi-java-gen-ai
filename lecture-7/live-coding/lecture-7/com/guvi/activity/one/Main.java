package com.guvi.activity.one;

public class Main {
    public static void main(String[] args) {
        SleeperTicket st1 = new SleeperTicket("PNR1", "Sleeper");
        AcTicket ac1 = new AcTicket("PNR2", "AC");

        System.out.println(st1.coachType());
        System.out.println(ac1.coachType());

        // polymorphism via parent reference
        // declaring an array of type TrainTicket (abstract class), trainTickets
        // initializing this array with three elements
        // index:           0            1              2
        // elements: [sleeper ticket, ac ticket, sleeper ticket]
        TrainTicket[] trainTickets = { st1, ac1, new SleeperTicket("PNR3", "Sleeper") };
        for(int i = 0; i < trainTickets.length; i++) {
            int fare = trainTickets[i].fare((i + 1) * 20);
            System.out.println(fare);
        }

//        trainTickets[2] = null;

        // for each loop
        for(TrainTicket trainTicket: trainTickets) {
            System.out.println(trainTicket.coachType());
        }
    }
}
