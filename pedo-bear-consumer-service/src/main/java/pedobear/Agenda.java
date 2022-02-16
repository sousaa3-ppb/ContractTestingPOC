package pedobear;

import java.util.Map;
public class Agenda {

    private int sprintId;
    private String description;
    private String date;
    private Map<String,String> ceremonies;
    private String uuid;

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getCeremonies() {
        return ceremonies;
    }

    public void setCeremonies(Map<String, String> ceremonies) {
        this.ceremonies = ceremonies;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
