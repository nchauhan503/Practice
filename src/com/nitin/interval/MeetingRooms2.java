package com.nitin.interval;

import java.util.Arrays;

public class MeetingRooms2 {

    public static void main(String[] args) {

        //int schedule[][] =  {{0,30},{5,10},{7,40},{40,50}};  // Output : false

        int schedule[][] = {{7,10},{1,4},{1,2},{10,11}, {1,5}}; // Output : true

        int m =  meetingRoom(schedule);

        System.out.println(" Min no of meeting rooms :" + m);

    }

    public static int meetingRoom(int[][] intervals) {

        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        int i = 1;
        int len = intervals.length;

        int count = 1;

        while ( i < len) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if ( currStart < end ){
                count++;
                start = Math.max(start,currStart);
                end = Math.min(end,currEnd);
            }else{
                end = currEnd;
            }
            i++;
        }

        return count;
    }
}
