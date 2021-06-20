package app.domain.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Represents a time in hours, minutes and seconds
 * 
 * @author renan
 */
public class Time implements Serializable {

    /**
     * The hours
     */
    private int hours;
    
    /**
     * The minutes
     */
    private int minutes;
    
    /**
     * The seconds
     */
    private int seconds;

    /**
     * Creates an instance of time with hours, minutes an seconds
     *
     */
    public Time() {
        this.setTime();
    }

    /**
     * Creates an instance of time with hours, minutes an seconds
     * Ex: 18:52
     */
    public Time(String time) {
        String[] hour = time.split(":");
        this.hours = Integer.parseInt(hour[0]);
        this.minutes = Integer.parseInt(hour[1]);
        this.seconds = 0;
    }

    /**
     * Gets the time's hours
     *
     * @return this time's hours
     */
    public int getHours() {
        return this.hours;
    }

    /**
     * Gets the time's minutes
     *
     * @return this time's minutes
     */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     *  Gets the time's seconds
     *
     * @return this time's seconds
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Sets new hours, minutes and seconds to a time
     *
     */
    public void setTime() {
        Calendar c = Calendar.getInstance();
        this.hours = c.get(Calendar.HOUR_OF_DAY);
        this.minutes = c.get(Calendar.MINUTE);
        this.seconds = c.get(Calendar.SECOND);
    }

    /**
     * this method compare a time to another
     * @param o obj which will be compared
     * @return if 0 it means, the time are equal. if > 0 it is
     * that a time is lower than the other
     */
    public int compareTo(Object o) {
        Time t = (Time) o;
        int diff = this.hours - t.hours;

        if(diff != 0) {
            return diff;
        }

        diff = this.minutes - t.minutes;

        if(diff != 0) {
            return diff;
        }

        return this.seconds - t.seconds;
    }

    /**
     * Gives a time description in %02d%02d%02d format
     *
     * @return String with information about the time
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

    
}
