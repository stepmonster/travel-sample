package ca.stepmonster.travel.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by judy on 4/27/17.
 */
public class Trip {
    protected Date startTime;
    protected Date endTime;
    protected String name;
    protected String displayName;
    protected String userName;
    protected String description;

    public Trip( String description,  String name,  Date endTime,  Date startTime, String userName) {
        this.description = description;
        this.name = name;
        this.displayName = name;
        this.endTime = endTime;
        this.startTime = startTime;
        this.userName = userName;
    }



    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName(){
        return displayName;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setDisplayName(String name) {
        this.displayName = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  }
