/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary;

import java.io.*;

/**
 *
 * @author Julius
 */
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    //Appointment particulars:
    private String description;//A description for this appointment.
    private int duration;//The number of hours that the appointment will last.
    private String month;
    private int day;
        //int monthIndex; this has been decomissioned but can still be called for testing and debugging

    public Appointment back;//The next appointment (back) of this appointment on the same date
    public Appointment right;//The next appointment (right) of this appointment in the same week.
    public Appointment down;//The next appointment (down) of this appointment in the same month.

    public Appointment()// used to create new appointment
    {
        /*You may implement this constructor to suit your needs, or you may add additional constructors.  This is the constructor which will be used for marking*/
        description = " ";
        duration = 0;
    }

    public Appointment(int _day)// is this ever used?
    {

        day = _day;
    }
    /* public Appointment(int _day)
     {
     day = _day;
     }*/

    public Appointment(String _month)// is this ever used?
    {
        month = _month;
    }

    public void setDescription(String desc) {
        /*Implement this method to set the description for this appointment*/
        description = desc;
    }

    public void setDuration(int dur) {
        /*Implement this method to set the duration of this appointment*/
        duration = dur;
    }

    public String getDescription() {
        /*This method returns the description of this appointment*/
        return description;
    }

    public int getDuration() {
        /*This method returns the duration of this appointment*/
        return duration;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day > Calendar.intDay.length || day < 1) {
            System.out.println("Wrong date");
        } else {
            this.day = day;
        }

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return String.format("Date: %d/%s  Description: %s Duration: %d\n", getDay(), getMonth(), getDescription(), getDuration());
    }

}
