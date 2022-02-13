package provider;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections4.map.HashedMap;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class AgendasDataSource {

    private static Map<Integer,Agenda> agendasDataBase = new HashMap<>();
    static {
        Agenda agenda = new Agenda();
        agenda.setSprintId(999);
        agenda.setDescription("Konami All Day Agenda for sprint 999");
        agenda.setDate("18/02/2050");
        Map<String,String> ceremoniesData = new LinkedHashMap<>();
        ceremoniesData.put("refinement","09:30");
        ceremoniesData.put("planning","10:30");
        ceremoniesData.put("lunch","12:00");
        ceremoniesData.put("retrospective","14:00");
        ceremoniesData.put("sharingsessions","15:00");
        agenda.setCeremonies(ceremoniesData);

        Agenda agenda2 = new Agenda();
        agenda2.setSprintId(1000);
        agenda2.setDescription("Konami All Day Agenda for sprint 1000");
        agenda2.setDate("18/02/2050");
        Map<String,String> ceremoniesData2 = new LinkedHashMap<>();
        ceremoniesData2.put("refinement","09:30");
        ceremoniesData2.put("planning","10:30");
        ceremoniesData2.put("lunch","12:00");
        ceremoniesData2.put("retrospective","14:00");
        ceremoniesData2.put("sharingsessions","15:00");
        agenda2.setCeremonies(ceremoniesData);

        agendasDataBase.put(999,agenda);
        agendasDataBase.put(1000,agenda2);
    }

    public Agenda getAgendaFromDataBaseByID(int id)
    {

        System.out.println("Getting Agenda from SprintId: "+id);
        return agendasDataBase.get(id);
    }

    public AgendaList getAllAgendas()
    {
        List<Agenda> newList = new ArrayList();

        agendasDataBase.values().forEach(agenda -> {
            System.out.println("Printing:"+agenda.getSprintId());
            newList.add(agenda);

        });

        AgendaList agendas = new AgendaList(newList);

        return agendas;
    }

    public void createAgendaOnDataSource(Agenda newAgenda){

        Integer key = newAgenda.getSprintId();
        agendasDataBase.put(key,newAgenda);

    }

}
