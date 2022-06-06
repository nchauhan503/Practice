package com.nitin.interval;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {

        int schedule[][] =  {{0,30},{30,40},{35,50}};  // Output : false

        //int schedule[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}}; // Output : true

        boolean m =  meetingRoom(schedule);

        System.out.println(" Meeting Possible :" + m);

    }

    public static boolean meetingRoom(int[][] meeting) {

        Arrays.sort(meeting , (a,b) -> a[0] - b[0]);

        int start = meeting[0][0];
        int end = meeting[0][1];

        int i = 1;
        int len = meeting.length;

        while ( i < len) {

            int currStart = meeting[i][0];
            int currEnd = meeting[i][1];

            if ( currStart < end ){
                return false;
            }else{
                end = currEnd;
            }
            i++;
        }

        return true;
    }
}
