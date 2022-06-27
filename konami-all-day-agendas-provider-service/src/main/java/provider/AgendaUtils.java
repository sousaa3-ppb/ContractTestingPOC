package provider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class AgendaUtils {

    AgendasDataSource dataSource;

    public AgendaUtils() {
        this.dataSource = new AgendasDataSource();
    }

    public void createAgenda(Agenda newAgenda) {

        dataSource.createAgendaOnDataSource(newAgenda);

    }

    public int createAgenda() {

        Agenda newAgenda = new Agenda();
        newAgenda.setDate("18/02/2022");
        newAgenda.setDescription("Konami All Day agenda for sprint " + newAgenda.getSprintId());
        Map<String, String> ceremoniesData = new LinkedHashMap<>();
        ceremoniesData.put("refinement", "09_30");
        ceremoniesData.put("planning", "10:30");
        ceremoniesData.put("lunch", "09:30");
        ceremoniesData.put("retrospective", "09:30");
        ceremoniesData.put("sharingsessions", "15:00");
        ceremoniesData.put("jogatinas", "17:00");
        ceremoniesData.put("MADONNA", "17:00");
        ceremoniesData.put("xpto", "17:00");
        newAgenda.setCeremonies(ceremoniesData);

        dataSource.createAgendaOnDataSource(newAgenda);

        return newAgenda.getSprintId();


    }

    public void createAgendasList() {

        Agenda agenda1 = new Agenda();
        agenda1.setDate("18/01/2022");
        agenda1.setDescription("Konami All Day Agenda for sprint 1000");
        Map<String, String> ceremoniesAgenda1 = new LinkedHashMap();
        ceremoniesAgenda1.put("refinement", "09:30");
        ceremoniesAgenda1.put("planning", "10:30");
        ceremoniesAgenda1.put("lunch", "12:00");
        ceremoniesAgenda1.put("retrospective", "14:00");
        ceremoniesAgenda1.put("sharingsessions", "15:00");
        ceremoniesAgenda1.put("jogatinas", "17:00");
        agenda1.setCeremonies(ceremoniesAgenda1);

        Agenda agenda2 = new Agenda();
        agenda2.setDate("31/01/2022");
        agenda2.setDescription("Konami All Day Agenda for sprint 1001");
        Map<String, String> ceremoniesAgenda2 = new LinkedHashMap();
        ceremoniesAgenda2.put("refinement", "09:30");
        ceremoniesAgenda2.put("planning", "10:30");
        ceremoniesAgenda2.put("lunch", "12:00");
        ceremoniesAgenda2.put("retrospective", "14:00");
        ceremoniesAgenda2.put("sharingsessions", "15:00");
        ceremoniesAgenda2.put("jogatinas", "17:00");
        agenda2.setCeremonies(ceremoniesAgenda2);

        createAgenda(agenda1);
        createAgenda(agenda2);


    }


}






