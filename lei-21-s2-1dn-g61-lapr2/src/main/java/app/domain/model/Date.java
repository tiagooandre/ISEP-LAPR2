package app.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Represents a date in year, month and day
 *
 * @author Renan
 */
public class Date implements Serializable {

    /**
     * The date's year
     */
    private int year;
    
    /**
     * The date's month
     */
    private int month;
    
    /**
     * The date's day
     */
    private int day;

    /**
     * Number of days in each month of the year.
     */
    private static int[] daysPerMonth = {  0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31};

    /**
     * Names of the months of the year.
     */
    private static String[] nomeMes = {"Invalid", "January", "February",
            "March", "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"};



    /**
     * Creates a new date with year, month and day
     */
    public Date() {
        this.setDate();
    }

    /**
     * Creates a new date with year, month and day
     * Ex: 22/03/2021
     */
    public Date(String date) {
        try {
            String[] dat = date.split("/");
            this.day = Integer.parseInt(dat[0]);
            this.month = Integer.parseInt(dat[1]);
            this.year = Integer.parseInt(dat[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }

    /**
     * Creates a new date with an old Date
     */
    public Date(Date date) {
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }

    public Date(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    /**
     * Gets the date's year
     *
     * @return this date's year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Gets the date's month
     *
     * @return this date's month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Gets the date's day
     *
     * @return this date's day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * @param year the year the date will have
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param month the year the date will have
     */
    public void setMonth(int month) {
        boolean dayFlag = false;
        while(!dayFlag) {
            if (month > 12) {
                month -= 12;
                setYear(year+1);
            } else {
                dayFlag = true;
                this.month = month;
            }
        }

    }

    /**
     * @param day the year the date will have
     */
    public void setDay(int day) {
        boolean dayFlag = false;
        this.day = day;
        while (!dayFlag) {
            if (this.day > (daysPerMonth[month])) {
                this.day -= (daysPerMonth[month]);
                plusMonth(1);
                if (this.day <= daysPerMonth[month]) {
                    dayFlag = true;
                }
            } else {
                dayFlag = true;
            }
        }
    }

    /**
     * @param year the year the date will have
     */
    public void plusYear(int year) {
        this.year += year;
    }

    /**
     * @param month the year the date will have
     */
    public void plusMonth(int month) {
        boolean dayFlag = false;
        this.month += month;
        while(!dayFlag) {
            if (this.month > 12) {
                this.month -= 12;
                plusYear(1);
            } else {
                if (this.month <= 12) {
                    dayFlag = true;
                }
            }
        }
    }

    /**
     * @param day the year the date will have
     */
    public void plusDay(int day) {
        boolean dayFlag = false;
        this.day += day;
        while (!dayFlag) {
            if (this.day > (daysPerMonth[month])) {
                this.day -= (daysPerMonth[month]);
                plusMonth(1);
                if (this.day <= daysPerMonth[month]) {
                    dayFlag = true;
                }
            } else {
                dayFlag = true;
            }
        }
    }

    /**
     * Sets new year, month and day to a date
     */
    public void setDate() {
        Calendar hoje = Calendar.getInstance();
        this.year = hoje.get(Calendar.YEAR);
        this.month = hoje.get(Calendar.MONTH) + 1;
        this.day = hoje.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Returns the difference in number of days between the date and the date received by parameter.
     * @param otherDate the other date to which the date is compared to calculate
     *        the difference in the number of days
     * @return difference in number of days between the date and the date received by parameter
     */
    public int calculateDifference(Date otherDate) {
        int totalDays = countDays();
        int totalDays1 = otherDate.countDays();
        return Math.abs(totalDays - totalDays1);
    }

    /**
     * Returns the difference in number of years between the date and the date received by parameter.
     * @param otherDate the other date to which the date is compared to calculate
     *        the difference in the number of years
     * @return difference in number of years between the date and the date received by parameter
     */
    public int calculateDifferenceYears(Date otherDate) {
        if (this.year > otherDate.getYear()) {
            return this.year - otherDate.getYear() + 1;
        } else if (this.year < otherDate.getYear()) {
            return otherDate.getYear() - this.year + 1;
        } else {
            return 1;
        }
    }

    /**
     * Returns the difference in number of Months between the date and the date received by parameter.
     * @param otherDate the other date to which the date is compared to calculate
     *        the difference in the number of Months
     * @return difference in number of Months between the date and the date received by parameter
     */
    public int calculateDifferenceMonths(Date otherDate) {
        int years = calculateDifferenceYears(otherDate);
        int months = 0;
        if (years > 2) {
             months = (years-2)*12;
        }
        if (year == otherDate.getYear()) {
            if (this.month > otherDate.getMonth()) {
                months += this.month - otherDate.getMonth() + 1;
            } else {
                months += otherDate.getMonth() - this.month + 1;
            }
        } else {
            months += 12 - this.month + 1 + otherDate.month;
        }
        return months;
    }

    /**
     * Returns true if the year passed by parameter is leap year.
     * If the year passed by parameter is not a leap, it returns false.
     *
     * @param year o ano a validar
     * @return true if the year passed by parameter is leap, otherwise returns false
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * Returns the number of days from day 1/1/1 to date.
     *
     * @return number of days from 1/1/1 to date
     */
    private int countDays() {
        int totalDays = 0;

        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            totalDays += daysPerMonth[i];
        }
        totalDays += (isLeapYear(year) && month > 2) ? 1 : 0;
        totalDays += day;

        return totalDays;
    }


    /**
     * this method compare a date to another
     * @param o obj which will be compared
     * @return if 0 it means, the date are equal. if > 0 it is
     * that a date is lower than the other
     */

/*    public int compareTo(Object o) {
        Date d = (Date) o;
        int diff = this.year - d.year;

        if(diff != 0) {
            return diff;
        }

        diff = this.month - d.month;


        if(diff != 0) {
            return diff;
        }

        return this.day - d.day;
    }*/

    /**
     * Gives a date description with year, month and day
     *
     * @return String with information about the date
     */
    @Override
    public String toString() {
        return String.format("%d %s %d", this.day,
                this.month, this.year);
    }

    /**
     * Shows the date in YYYY/MM/DD format
     *
     * @return String with information about the date
     */
    public String toYMDString() {
        return String.format("%04d/%02d/%02d", this.year, this.month, this.day);
    }

    public int compareTo(Date obj){

        if(this.year > obj.getYear()){
            return 1;
        }
        if(this.year < obj.getYear()){
            return -1;
        }
        if(this.year == obj.getYear()){
            if(this.month > obj.getMonth()){
                return 1;
            }
            if(this.month < obj.getMonth()){
                return -1;
            }
            if(this.month == obj.getMonth()){
                if(this.day > obj.getDay()){
                    return 1;
                }
                if(this.day < obj.getDay()){
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * @param otherDate the last date to consider
     * @return Array of string with with years between two dates
     */
    public String[] datesYear(Date otherDate) {
        int years = calculateDifferenceYears(otherDate);
        String[] yearsString = new String[years];
        for (int i = 0; i < years; i++) {
            yearsString[i] = String.valueOf(this.year + i);
        }
        return yearsString;
    }

    /**
     * @param otherDate the last date to consider
     * @return Array of string with with months and years between two dates
     */
    public String[] datesMonth(Date otherDate) {
        int months = calculateDifferenceMonths(otherDate);
        String[] monthsString = new String[months];
        int m = month, y = year;
        for (int i = 0; i < months; i++) {
            monthsString[i] = nomeMes[m] + " " + y;
            if (m == 12) {
                m = 0;
                y++;
            }
            m++;
        }
        return monthsString;
    }

    /**
     * @param otherDate the last date to consider
     * @return Array of string with with weeks between two dates
     */
    public String[] weeksDay(Date otherDate) {
        Date d = new Date(this.year, this.month, this.day);
        int weeks = calculateDifference(otherDate)/7;
        String[] weeksString = new String[weeks];
        for (int i = 0; i < weeks; i++) {
            weeksString[i] = nomeMes[d.getMonth()] + " " + d.getDay() + ", "  + d.getYear();
            d.plusDay(7);
            weeksString[i] += " to " + nomeMes[d.getMonth()] + " " + d.getDay() + ", "  + d.getYear();
            d.plusDay(1);
        }
        return weeksString;
    }

    /**
     * @param otherDate the last date to consider
     * @return Array of string with with days between two dates
     */
    public String[] datesDay(Date otherDate) {
        Date d = new Date(this.year, this.month, this.day);
        int days = calculateDifference(otherDate) + 1;
        String[] daysString = new String[days];
        for (int i = 0; i < days; i++) {
            daysString[i] = nomeMes[d.getMonth()] + " " + d.getDay() + ", "  + d.getYear();
            d.plusDay(1);
        }
        return daysString;
    }

}

