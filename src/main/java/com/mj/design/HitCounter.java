package com.mj.design;

/*
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);
 */
public class HitCounter {

    int[] times;
    int[] counts;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.times = new int[300];
        this.counts =  new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(this.times[index] != timestamp){
            this.times[index] = timestamp;
            this.counts[index] = 1;
        }
        else{
            this.counts[index] = this.counts[index]+1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i=0; i<this.times.length; i++){
            if(this.times[i] > timestamp - 300){
                count = count + this.counts[i];
            }
        }
        return count;
    }
}
