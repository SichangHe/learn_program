public class Clock {

    // instance variables
    private int h, m;

    /**
     * Creates a clock whose initial time is hours and minutes.
     *
     */
    public Clock(int hour, int minute)
    {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hours must be between 0 and 23");
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("minutes must be between 0 and 59");

        h = hour;
        m = minute;
    }

    /**
     * Creates a clock whose initial time is specified as a string, using the format
     * HH:MM.
     *
     * @param s initial time using the format HH:MM
     */
    // @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(
    // { "DRE_DECLARED_RUNTIME_EXCEPTION", "LEST_LOST_EXCEPTION_STACK_TRACE" })
    public Clock(String s) throws IllegalArgumentException
    {
        if (s.length() != 5)
            throw new IllegalArgumentException("the format must be HH:MM");
        if (Character.compare(s.charAt(2), ':') != 0)
            throw new IllegalArgumentException("the format must be HH:MM");
        int hour, minute;
        try
        {
            hour = Integer.parseInt(s.substring(0, 2));
            minute = Integer.parseInt(s.substring(3, 5));
        } catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("the format must be HH:MM");
        }
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hours must be between 0 and 23");
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("minutes must be between 0 and 59");

        h = hour;
        m = minute;
    }

    /**
     *
     * @return a string representation of this clock, using the format HH:MM
     */
    public String toString()
    {
        return String.format("%02d:%02d", h, m);
    }

    /**
     *
     * @param that that clock
     * @return boolean is the time on this clock earlier than the time on that one?
     */
    public boolean isEarlierThan(Clock that)
    {
        if (this.h < that.h)
            return true;
        if (this.h > that.h)
            return false;
        if (this.m < that.m)
            return true;
        return false;
    }

    /**
     * Adds 1 minute to the time on this clock.
     *
     */
    public void tic()
    {
        if (m == 59)
        {
            m = 0;
            if (h == 23)
            {
                h = 0;
                return;
            }
            h++;
            return;
        }
        m++;
    }

    /**
     *
     * @param delta Adds Δ minutes to the time on this clock
     */
    public void toc(int delta)
    {
        if (delta < 0)
            throw new IllegalArgumentException("Δ must be greater than 0");
        m += delta;
        h += m / 60;
        h = h % 24;
        m = m % 60;
    }

    public static void main(String[] args)
    {
        Clock clocky = new Clock(21, 5);
        Clock clock2 = new Clock("11:26");
        System.out.println(clocky.toString() + ", " + clock2.toString());
        System.out.println(clocky.isEarlierThan(clock2));
        clocky.tic();
        clock2.toc(2586845);
        System.out.println(clocky.toString() + ", " + clock2.toString());
    }
}
