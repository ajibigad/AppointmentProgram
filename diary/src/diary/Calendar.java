package diary;

import java.io.*;

public class Calendar implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     * @author Julius
     */

    private final Appointment dayPtr[] = new Appointment[30];
    private final Appointment monthPtr[] = new Appointment[12];
    public static final int intDay[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
        13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
        30};
    public static final String strMonth[] = {"Jan", "Feb", "Mar", "Apr",
        "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

	// private Appointment appointment;
    // private String strDay[] = {"1", "2"};
    Calendar() {// to initialize the pointers of the calendar
		/*
         * You may implement this constructor to suit your needs, or you may add
         * additional constructors. This is the constructor which will be used
         * for marking
         */
        for (int i = 0; i < intDay.length; i++) {
            dayPtr[i] = new Appointment(intDay[i]);// Initialising the
            // appointment array day by
            // creating appointment
            // objects with the
            // specified day and
            // assigning it to the day
            // array
            // System.out.print(day[i].right);
        }
        for (int i = 0; i < strMonth.length; i++) {
            monthPtr[i] = new Appointment(strMonth[i]);// initailzing the month
            // array similar to the
            // way the day is
            // initialized
            // System.out.print(strMonth);
        }

		// for(int i = 0; i < )
        // System.out.print(day);
    }

    /* Insertion */
    public void addAppointment(String month, int day, String description,
            int duration) {
        /*
         * Insert an appointment at the given month and day combination.
         * Intialize the appointment with the remainder of the parameters.
         * Duplicate appointments are allowed.
         */
        Appointment newApp = new Appointment();
        newApp.setDescription(description);
        newApp.setDuration(duration);
        newApp.setDay(day);
        newApp.setMonth(month);
        // after the block of codes above we now have a complete appointment
        int monthIndex = getmonthIndex(month);//gets the index by cmp d string wif the array of months<String> and getting the index
        // newApp.monthIndex = monthIndex;// i did this so each time i want to
        // use the month index of any appointment i dont have to use the
        // getmonthIndex method
        int dayIndex = day - 1;
		// System.out.println(monthIndex);

		// System.out.println(dayIndex);
        // Don't have to keep track of day index cos its an int already.
        // Check if appoinmtment exists already.(use either right or down
        // pointer to check for this
        // Check if there is an appointment in the monthIndex,]
        // For insertion into empty calender
        if (dayPtr[dayIndex].right == null && monthPtr[monthIndex].down == null) {
            dayPtr[dayIndex].right = newApp;// This however shows errors. which
            // means it's not right.
            monthPtr[monthIndex].down = newApp;// This however shows errors.
            // which means it's not right.
            // System.out.println(newApp.getDescription());
        } // for empty dayList but Occupied Month list
        else if (dayPtr[dayIndex].right == null
                && monthPtr[monthIndex].down != null) {
            dayPtr[dayIndex].right = newApp;// This is to start the empty
            // dayList

            insertMonth(newApp, monthIndex);// inserts node into month list

			// this.month[monthIndex].back = newApp;
            // use back "pointer" from existing appoinment(node) to new
            // appoinment(newApp)
        }// end of empty day list
        // empty monthList but Occupied DayList
        else if (dayPtr[dayIndex].right != null
                && monthPtr[monthIndex].down == null) {
			// use DOWN "pointer" from existing appoinment(node) to new
            // appoinment(node)
            // and use right "pointer" for whatever day new appointment is on.
            monthPtr[monthIndex].down = newApp; // created the month list

            insertDay(newApp, dayIndex);// inserts node into day list
        }// end
        // this is for occupied day and month list
        else if (dayPtr[dayIndex].right != null
                && monthPtr[monthIndex].down != null) // else if appoinment
        // exists on same day
        // but differnt month
        {
			// use RIGHT "pointer" from existing appoinment(node) to new
            // appoinment(node)
            // and use down "pointer" for whatever month new appointment is on.

            /*
             * My plan for this section is to get the appointment on this date
             * and 1st find out if there is no appointment on this date.. if yes
             * then just add it to both list.. it wouldnt cause any harm since
             * there is no link between the links at this time but if the
             * appointment exist on this date then check if this appiontment has
             * a back if yes then use the checkback and add method to add this
             * appointment to the list.. it would just get the apppointments
             * back and add the newApp to the back but if it doesnt have a back
             * then just add it normally to the back
             */
            Appointment current = getAppointment(month, day);// gets the
            // appointment
            // on this date
            if (current == null) {// if there is no appointment on this date
                // then add to both linkedList
                insertDay(newApp, dayIndex);
                insertMonth(newApp, monthIndex);
            } else {// there is an appointment on this date
                if (!checkBackAdd(current, newApp)) {// meaning it doesnt have a
                    // back
                    current.back = newApp;
                }
            }

        }

    }

    /* Deletion methods */
    public Appointment deleteAppointment(String month, int day) {
        /*
         * Delete the first appointment at the given month and day combination
         * and return the deleted appointment. If no such appointment exists,
         * return null.
         */
        Appointment app = getAppointment(month, day);
        if (app != null) {
            deleteAppointment(app);
            return app;
        }
        return null;
    }

    public void deleteAppointment(Appointment app) {
        deleteAppMonth(app);// deletes the app from the month list
        deleteAppDay(app);// deletes the app from the day list
    }

    private void deleteAppDay(Appointment app) {// deletes app on the day list
        Appointment currentDay = getDayAppointment(app.getDay());
        Appointment prev = currentDay;// to store the previous app
        while (currentDay != null) {// loops to get the prev appointment of the
            // app
            System.out.println("dayApp");
            if (currentDay.right == app) {
                prev = currentDay;// found prevapp
                break;
            } else {
                currentDay = currentDay.right;
            }
        }
        if (app.back != null) {// making the back the head
            System.out.println("back in day");
            prev.right = app.back;
            app.back.right = app.right;
            app.right = null;
        } else {// means no back
            prev.right = app.right;
            app.right = null;
        }
    }

    private void deleteAppMonth(Appointment app) {// deletes app on the month
        // list
        Appointment currentMonth = getMonthAppointment(app.getMonth());
        Appointment prev = currentMonth;// to store the previous app
        while (currentMonth != null) {// loops to get the prev appointment of
            // the app
            System.out.println("monthApp");
            if (currentMonth.down == app) {
                prev = currentMonth;// found prevapp
                break;
            } else {
                currentMonth = currentMonth.down;
            }
        }
        if (app.back != null) {// making the back the head
            prev.down = app.back;
            app.back.down = app.down;
            app.down = null;
        } else {// means no back
            prev.down = app.down;
            app.down = null;
        }
    }

    public Appointment deleteAppointment(String month, int day,
            String description) {
        /*
         * Delete the first appointment at the given month and day combination
         * with the description and return the deleted appointment. If no such
         * appointment exists, return null.
         */
        Appointment app = getAppointment(month, day);
        if (app != null) {
            if (app.getDescription().equalsIgnoreCase(description)) {// if the
                // head
                // is
                // the
                // app
                deleteAppointment(app);
                return app;
            } else {// if its not the app
                Appointment curBack = app.back;
                Appointment curPrev = app;
                while (curBack != null) {// if it has a back
                    if (curBack.getDescription().equalsIgnoreCase(description)) {
                        curPrev.back = curBack.back;// deletes the app in the
                        // backList
                        curBack.back = null;
                        return curBack;
                    } else {// go to the next back
                        curPrev = curBack;
                        curBack = curBack.back;
                    }
                }
            }
        }
        return null;
    }

    /* Clearing Methods */
    public void clearMyMonth(String month) {
        /*
         * All appointements for the given month should be deleted. If the month
         * has no appointments, simply do nothing.
         */

        /*
         * My plan here is delete all the apps in the month list from the day
         * list by using my deleteAppDay method then set the months pointer down
         * to null which then completely deletes the apps from the calendar
         * before passing an app to the delete method, pls remember to make it
         * backless ie set its back to null
         */
        Appointment ptrM = getMonthAppointment(month);
        Appointment curM = getMonthAppointment(month).down; // gets me the head
        // app on this month
        if (curM != null) {// dont execute if the month is empty
            do {
                curM.back = null;// makes the app backless so only the head
                // would be deleted and this is bcus of how
                // the deleteAppDay method is structured to
                // delete only head and and save the backs
                deleteAppDay(curM);// should delete this app from the dayList
                curM = curM.down;
            } while (curM != null);
            ptrM.down = null;// this should completely clear this month
        }
    }

    public void clearMyDays(int day) {
        /*
         * All appointements for the given day should be deleted. If the day has
         * no appointments, simply do nothing.
         */
        Appointment ptrD = getDayAppointment(day);
        Appointment curD = getDayAppointment(day).right; // gets me the head app
        // on this day
        if (curD != null) {// dont execute if the day is empty
            do {
                curD.back = null;// makes the app backless so only the head
                // would be deleted and this is bcus of how
                // the deleteAppMonth method is structured
                // to delete only head and and save the
                // backs
                deleteAppMonth(curD);// should delete this app from the
                // MonthList
                curD = curD.right;
            } while (curD != null);
            ptrD.right = null;// this should completely clear this day
        }
    }

    public void clearMyYear() {
        /* Delete all appointments from the calendar. */
        for (Appointment clear : monthPtr) {
            clear.down = null;
        }
        for (Appointment clear : dayPtr) {
            clear.right = null;
        }
    }

    /* Query methods */
    public Appointment getAppointment(String month, int day) {// gets the
        // appointment
        // on this date
		/*
         * Return the head appointment of the month and day combination. If no
         * such appointment exists, return null
         */
        Appointment currentMonth = monthPtr[getmonthIndex(month)].down;

        while (currentMonth != null) {// Does not execute if the currentMonth is
            // null
            if (currentMonth.getDay() == day) {
                return currentMonth;
            } else {
                // System.out.println("testing 123");
                currentMonth = currentMonth.down;
            }
        }
        return currentMonth;
    }

    public Appointment getMonthAppointment(String month) {
        /*
         * Return the head appointment for the month passed as a parameter. If
         * no such appointment exists, return null
         */
        if (monthPtr[getmonthIndex(month)] == null) {
            return null;
        } else {
            return monthPtr[getmonthIndex(month)];
        }
    }

    public Appointment getDayAppointment(int day) {
        /*
         * Return the head appointment for the day passed as a parameter. If no
         * such appointment exists, return null
         */
        if (dayPtr[day - 1] == null) {
            return null;
        } else {
            return dayPtr[day - 1];
        }
    }

    /* Modification methods */
    public void changeAppointmentDescription(String month, int day,
            String oldDescription, String newDescription) {
        /*
         * Find the first appointment at the month and day combination with the
         * description "oldDescription", and change the description to
         * "newDescription"
         */
        Appointment app = getAppointment(month, day);
        if (app != null) {
            if (app.getDescription().equalsIgnoreCase(oldDescription)) {// if
                // the
                // head
                // is
                // the
                // app
                app.setDescription(newDescription);
            } else {
                Appointment curBack = app.back;
                while (curBack != null) {// if it has a back
                    if (curBack.getDescription().equalsIgnoreCase(
                            oldDescription)) {
                        curBack.setDescription(newDescription);
                        break;
                    } else {// go to the next back
                        curBack = curBack.back;
                    }
                }
            }
        }
    }

    public void changeAppointmentDuration(String month, int day,
            String oldDescription, int newDuration) {
        /*
         * Find the first appointment at the month and day combination with the
         * description "oldDescription", and change the duration to
         * "newDuration"
         */
        Appointment app = getAppointment(month, day);
        if (app != null) {
            if (app.getDescription().equalsIgnoreCase(oldDescription)) {// if
                // the
                // head
                // is
                // the
                // app
                app.setDuration(newDuration);
            } else {
                Appointment curBack = app.back;
                while (curBack != null) {// if it has a back
                    if (curBack.getDescription().equalsIgnoreCase(
                            oldDescription)) {
                        curBack.setDuration(newDuration);
                        break;
                    } else {// go to the next back
                        curBack = curBack.back;
                    }
                }
            }
        }
    }

    public void changeAppointmentDate(String fromMonth, int fromDay,
            String toMonth, int toDay) {// the implication of this using the
        // same date as parameters is that the
        // apps are swap in date day ie the head
        // becomes the tail lol!!!
		/*
         * Find the appointment located at the "fromMonth"/"fromDate"
         * combination and change the appointment to the "toMonth/toDate"
         * location
         */
        /*
         * My plan is to delete the appointment completely from the calendar
         * then add it again to the Calendar with its new monht and day
         */

        Appointment app = deleteAppointment(fromMonth, fromDay);// deletes the
        // head app from
        // the calendar
        if (app != null) {
            app.setDay(toDay);
            app.setMonth(toMonth);
            addAppointment(app.getMonth(), app.getDay(), app.getDescription(),
                    app.getDuration());// adds the app to the calendar with its
            // new data
        }
    }

    public void printAllMonth() {
        for (Appointment iMonth : monthPtr) {
            printMonth(iMonth);
        }

    }

    public void printMonth(String month) {
        printMonth(getMonthAppointment(month));
    }

    public void printMonth(Appointment iMonth) {
        if (iMonth.down != null) {
            Appointment current = iMonth.down;
            do {
                printApp(current);// just print the app and its backs
                current = current.down;
            } while (current != null);
            System.out.println();
        }
    }

    public void printAllDay() {
        for (Appointment dayApp : dayPtr) {
            printDay(dayApp);
        }
    }

    public void printDay(int day) {
        printDay(getDayAppointment(day));
    }

    public void printDay(Appointment day) {
        if (day.right != null) {
            Appointment current = day.right;
            do {
                printApp(current);// just print the app and its backs
                current = current.right;
            } while (current != null);

            System.out.println();
        }

    }

    public void printApp(String name, int age) {
        printApp(getAppointment(name, age));
    }

    public void printApp(Appointment current) {
        System.out.println(current);
		// System.out.printf("Date: %d/%s  Description: %s Duration: %d\n",
        // current.getDay(), current.getMonth(), current.getDescription(),
        // current.getDuration());

        if (current.back != null) {
            Appointment dup = current.back;
            do {
                System.out.println(dup);
				// System.out.printf("Date: %d/%s  Description: %s Duration: %d\n",
                // dup.getDay(), dup.getMonth(), dup.getDescription(),
                // dup.getDuration());
                dup = dup.back;
            } while (dup != null);
        }
    }

    private int getmonthIndex(String m) {
        int monthIndex = 0;// To keep track of the month index.
        for (int i = 0; i < strMonth.length; i++) {
            if (strMonth[i].equalsIgnoreCase(m)) {
                monthIndex = i;
            }
			// System.out.println(newApp.getDescription());
            // i++;
        }
        return monthIndex;
    }

    @SuppressWarnings("unused")
    private int getdayIndex(int d) {
        int dayIndex = 0;// To keep track of the month index.
        for (int i = 0; i < intDay.length; i++) {
            if (intDay[i] == d) {
                dayIndex = i;
            }
			// System.out.println(newApp.getDescription());
            // i++;
        }
        return dayIndex;
    }

    /*
     * These insert methods only insert head apps, dey dont consider backs and
     * this has been handled in the addMethod
     */
    private void insertMonth(Appointment newApp, int monthIndex) {
        Appointment current;
        current = monthPtr[monthIndex];// current equals 1st node
        do {// loops while the list contains more nodes ie loops until end of
            // list.
            if (newApp.getDay() < current.down.getDay()) {// if less than next
                // node fix btw both
                // nodes and leave
                // the loop
                newApp.down = current.down;
                current.down = newApp;
                // System.out.println(current.down.getDescription()+" 3");
                break;
            } else {// no more nodes and newApp is greater
                current = current.down;// moves to the next node for comparison
            }
        } while (current.down != null);

        if (current.down == null) {// if end of list is reached then fix new
            // node at the bottom of the list
            current.down = newApp;
            // System.out.println(current.down.getDescription()+" 4");
        }
    }

    private void insertDay(Appointment newApp, int dayIndex) {// these method is
        // used when it
        // has been
        // identified
        // that this day
        // has a node
        Appointment current;
        current = dayPtr[dayIndex];// current equals 1st node
        do {// loops while the list contains more nodes ie loops until end of
            // list. do while loop because its definitly above 1 node in the
            // list
            if (getmonthIndex(newApp.getMonth())/* newApp.monthIndex */ < getmonthIndex(current.right
                            .getMonth())/* current.right.monthIndex */) {// if less than
                // next node
                // fix btw
                // both
                // nodes and
                // leave the
                // loop
                newApp.right = current.right;
                current.right = newApp;
                // System.out.println(current.right.getDescription()+" 3");
                break;
            } else {// more nodes and newApp is greater
                current = current.right;// moves to the next node for comparison
            }
        } while (current.right != null);

        if (current.right == null) {// if end of list is reached then fix new
            // node at the bottom of the list
            current.right = newApp;
            // System.out.println(current.right.getDescription()+" 4");
        }
    }

    private Appointment getBack(Appointment current) {// this method gets the
        // back of this object
        while (current.back != null) {
            current = current.back;
        }
        return current;
    }

    private boolean checkBackAdd(Appointment current, Appointment app) {// the
        // method
        // checks
        // if
        // the
        // cuurent
        // object
        // has a
        // back,
        // it
        // finds
        // that
        // back
        // with
        // the
        // getBack
        // method
        // then
        // adds
        // the
        // appointment
        // to
        // that
        // back
        if (current.back == null) {// returns false if no back
            return false;
        } else {
            getBack(current).back = app;
            return true;
        }
    }

}
