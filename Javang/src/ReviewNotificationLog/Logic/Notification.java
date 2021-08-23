package ReviewNotificationLog.Logic;

import ReviewNotificationLog.Data.Database;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * This class will create a notification object with its given properties
 *
 * @author Florida
 * @version 11.5.2020
 */

public class Notification {
    private Date postedDate;
    private Time postedTime;
    private String title;
    private String content;
    private String staffName;
    private Integer num_Suscribers;

    /**
     * @param pd the postedDate
     * @param pt the PostedTime
     * @param t the title
     * @param c the content
     * @param sn the Staff Name
     * @param ns the number of suscribers
     */
    public Notification(Date pd, Time pt, String t, String c, String sn, Integer ns){
        this.postedDate = pd;
        this.postedTime = pt;
        title = t;
        content = c;
        staffName = sn;
        num_Suscribers = ns;
    }

    /**
     * @param fromDate the start date
     * @param toDate the end date
     * @return
     */


    public static ArrayList<Notification> findData(Date fromDate, Date toDate) {
        return Database.findData (fromDate, toDate);
    }

    /**
     * @return the date when the notification was sent
     */
    public Date getPostedDate(){
        return postedDate;
    }

    /**
     * @return the time the notification was sent
     */
    public Time getPostedTime(){
        return postedTime;
    }

    /**
     * @return the title of the notification
     */
    public String getTitle(){
        return title;
    }

    /**
     * @return the content of the notification
     */
    public String getContent(){
        return content;
    }

    /**
     * @return the name of the person who sent the notification. This will return the firstname + lastname
     */
    public String getName(){
        return staffName;
    }

    /**
     * @return the number of suscribers the notification was sent to
     */
    public Integer getNum_Suscribers(){
        return num_Suscribers;
    }
}
