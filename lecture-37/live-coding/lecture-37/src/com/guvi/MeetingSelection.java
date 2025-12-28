package com.guvi;

import java.util.ArrayList;
import java.util.List;

// meeting: name, start, end
public class MeetingSelection {
    public record Meeting(String name, int start, int end) {
    }

    public static List<Meeting> selectMaxMeetings(List<Meeting> meetings) {
        // validation: meetings == null? meetings.size() == 0?
        if(meetings == null) {
            throw new IllegalArgumentException("Meetings cannot be null");
        }

        // Sort meetings by the earliest finishing time
        List<Meeting> sortedMeetings = new ArrayList<>(meetings);
        // Sorting: Option A
        /*
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.end - m2.end;
            }
        });
        */
        /*
        Recall how sort functions:
        a.end - b.end   -> negative (place a before b in the sorting order)
                        -> positive (place a after b)
                        -> zero (a equals b)
        Example:
            Compare: Meetings C (end time: 6) & A  (end time: 4)
            6 - 4 => positive
            Sorted order: A, C
         */
        // Sorting: Option B
        sortedMeetings.sort((a, b) -> a.end() - b.end());

        // List of meetings -> (a, b)
        // Sorting: Option C
        // sortedMeetings.sort(Comparator.comparing(Meeting::end));

        // selectedMeetings, lastEnd
        List<Meeting> selectedMeetings = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;

        // Iterate over each meeting in the sorted list
        for(Meeting meeting : sortedMeetings) {
            // Feasibility check: no overlap with the previously selected meeting
            if(meeting.start() >= lastEnd) {
                selectedMeetings.add(meeting);
                lastEnd = meeting.end();
            }
        }

        return selectedMeetings;
    }

    public static void main(String[] args) {
        Meeting m1 = new Meeting("A", 1, 4);
        Meeting m2 = new Meeting("B", 3, 5);
        Meeting m3 = new Meeting("C", 0, 6);
        Meeting m4 = new Meeting("D", 5, 7);
        Meeting m5 = new Meeting("E", 8, 9);
        Meeting m6 = new Meeting("F", 5, 9);

//        List<Meeting> meetings = new ArrayList<>();
//        meetings.add(m1);
//        meetings.add(m2);
        List<Meeting> meetings = List.of(m1, m2, m3, m4, m5, m6);
        System.out.println(selectMaxMeetings(meetings));
    }
}
