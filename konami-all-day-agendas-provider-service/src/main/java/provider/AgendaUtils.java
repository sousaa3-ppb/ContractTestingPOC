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

    public String createAgendaWithId(int sprintId){

        Agenda newAgenda = new Agenda();
        newAgenda.setSprintId(sprintId);
        newAgenda.setDate("18/02/2022");
        Map<String,String> ceremoniesData = new LinkedHashMap<>();
        ceremoniesData.put("refinement","09:30");
        ceremoniesData.put("planning","10:30");
        ceremoniesData.put("lunch","09:30");
        ceremoniesData.put("retrospective","09:30");
        ceremoniesData.put("sharingsessions","15:00");
        newAgenda.setCeremonies(ceremoniesData);

        dataSource.createAgendaOnDataSource(newAgenda);



        return newAgenda.getUuid();



    }























}






