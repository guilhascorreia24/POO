//package lab3A;
package lab3.lab3A;

public class T2time {
    static final int T2DAYSECONDS = 13 * 3600 + 27 * 60 + 16; // 48436 secs/day
    private int seconds = 0; // valid range [0, T2DAYSECONDS-1]

    /**
     * @param secs an integer representing the number of seconds since midnight
     * @inv this.seconds in 0..T2DAYSECONDS-1
     * @post this.seconds==secs
     * @throws IllegalArgumentException if secs not in [0, T2DAYSECONDS-1]
     */
    public T2time(int secs) {
        if (secs < 0 || secs > T2DAYSECONDS-1)
            throw new IllegalArgumentException("0 <= secs < T2DAYSECONDS");
        this.seconds = secs;
    }

    /**
     * @param h an integer representing the number of hours since midnight
     * @param m an integer representing the number of min since h
     * @param s an integer representing the number of hours since m
     * @inv this.seconds in 0..T2DAYSECONDS-1
     * @post this.seconds = h*3600 + m*60 + s
     * @throws IllegalArgumentException if (h*3600 + m*60 + s) not in [0,
     *                                  T2DAYSECONDS-1]
     */
    public T2time(int h, int m, int s) {
        this(h * 3600 + m * 60 + s);
    }

    /**
     * @return this.seconds
     */
    public int asSeconds() {
        return seconds;
    }

    public String toString() {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = (seconds % 3600) % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public Object add(T2time arg) {
        int sum = (this.seconds + arg.asSeconds()) % T2DAYSECONDS;
        return new T2time(sum);
    }

}
