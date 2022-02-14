package provider;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Agenda {

    private int sprintId;
    private String description;
    private String date;
    private Map<String,String> ceremonies;
    private String uuid;

    public Agenda(){

        this.uuid = UUID.randomUUID().toString();

    }

    public Agenda(int sprintId, String description, String date, Map<String,String> ceremonies){
        this.sprintId = sprintId;
        this.description = description;
        this.date = date;
        this.ceremonies = ceremonies;
    }

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
