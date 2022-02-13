package provider;

import org.apache.commons.collections4.map.HashedMap;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class AgendasDataSource {


    public AgendasDataSource(){



    }

    public Agenda getAgendaFromDataBaseByID(int id)
    {
        Agenda agenda = new Agenda();
        agenda.setSprintId(id);
        agenda.setDescription("Konami All Day Agenda for sprint 104");
        agenda.setDate("18/02/2022");
        Map <String,String> ceremoniesData = new HashMap<String,String>();
        ceremoniesData.put("refinement","09:30");
        ceremoniesData.put("planning","10:30");
        ceremoniesData.put("lunch","12:00");
        ceremoniesData.put("retrospective","14:00");
        ceremoniesData.put("sharingsessions","15:00");
        agenda.setCeremonies(ceremoniesData);


        return agenda;

    }

    public AgendaList getAllAgendas()
    {
        Agenda agenda1 = new Agenda();
        agenda1.setSprintId(103);
        agenda1.setDate("18/01/2022");
        agenda1.setDescription("Konami All Day Agenda for sprint 1000");
        Map <String,String> ceremoniesAgenda1 = new LinkedHashMap();
        ceremoniesAgenda1.put("refinement","09:30");
        ceremoniesAgenda1.put("planning","10:30");
        ceremoniesAgenda1.put("lunch","12:00");
        ceremoniesAgenda1.put("retrospective","14:00");
        ceremoniesAgenda1.put("sharingsessions","15:00");
        agenda1.setCeremonies(ceremoniesAgenda1);

        Agenda agenda2 = new Agenda();
        agenda2.setSprintId(104);
        agenda2.setDate("31/01/2022");
        agenda2.setDescription("Konami All Day Agenda for sprint 1001");
        Map <String,String> ceremoniesAgenda2 = new LinkedHashMap();
        ceremoniesAgenda2.put("refinement","09:30");
        ceremoniesAgenda2.put("planning","10:30");
        ceremoniesAgenda2.put("lunch","12:00");
        ceremoniesAgenda2.put("retrospective","14:00");
        ceremoniesAgenda2.put("sharingsessions","N/A");
        agenda2.setCeremonies(ceremoniesAgenda2);

        List<Agenda> newList = new ArrayList();
        newList.add(agenda1);
        newList.add(agenda2);

        AgendaList agendas = new AgendaList(newList);



        return agendas;
    }

}
