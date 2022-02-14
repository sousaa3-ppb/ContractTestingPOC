package provider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class AgendaUtils {

    AgendasDataSource dataSource;

    public AgendaUtils() {
        this.dataSource = new AgendasDataSource();
    }

    public void createAgenda(Agenda newAgenda){

        dataSource.createAgendaOnDataSource(newAgenda);

    }

    public int createAgenda(){

        Agenda newAgenda = new Agenda();
        newAgenda.setDate("18/02/2022");
        newAgenda.setDescription("Konami All Day agenda for sprint "+newAgenda.getSprintId());
        Map<String,String> ceremoniesData = new LinkedHashMap<>();
        ceremoniesData.put("refinement","09:30");
        ceremoniesData.put("planning","10:30");
        ceremoniesData.put("lunch","09:30");
        ceremoniesData.put("retrospective","09:30");
        ceremoniesData.put("sharingsessions","15:00");
        newAgenda.setCeremonies(ceremoniesData);

        dataSource.createAgendaOnDataSource(newAgenda);

        return newAgenda.getSprintId();



    }























}






