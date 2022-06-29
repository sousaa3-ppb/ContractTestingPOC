package provider;

import java.util.*;

public class AgendasDataSource {

    private static final Map<Integer,Agenda> agendasDataBase = new HashMap<>();
    static {

        Agenda agenda = new Agenda();
        agenda.setDescription("Konami All Day Agenda for sprint "+agenda.getSprintId());
        agenda.setDate("18/02/2050");
        Map<String,String> ceremoniesData = new LinkedHashMap<>();
        ceremoniesData.put("refinement","09:30");
        ceremoniesData.put("planning","10:30");
        ceremoniesData.put("lunch","12:00");
        ceremoniesData.put("retrospective","14:00");
        ceremoniesData.put("sharingsessions","15:00");
        agenda.setCeremonies(ceremoniesData);

        Agenda agenda2 = new Agenda();
        agenda2.setDescription("Konami All Day Agenda for sprint "+agenda2.getSprintId());
        agenda2.setDate("18/02/2050");
        Map<String,String> ceremoniesData2 = new LinkedHashMap<>();
        ceremoniesData2.put("refinement","09:30");
        ceremoniesData2.put("planning","10:30");
        ceremoniesData2.put("lunch","12:00");
        ceremoniesData2.put("retrospective","14:00");
        ceremoniesData2.put("sharingsessions","15:00");
        agenda2.setCeremonies(ceremoniesData2);

        Agenda agenda3 = new Agenda();
        agenda3.setSprintId(300);
        agenda3.setDescription("Konami All Day Agenda for sprint "+agenda3.getSprintId());
        agenda3.setDate("18/02/2050");
        Map<String,String> ceremoniesData3 = new LinkedHashMap<>();
        ceremoniesData3.put("refinement","09:30");
        ceremoniesData3.put("planning","10:30");
        ceremoniesData3.put("lunch","12:00");
        ceremoniesData3.put("retrospective","14:00");
        ceremoniesData3.put("sharingsessions","15:00");
        ceremoniesData3.put("jogatinas","09:30");
        agenda3.setCeremonies(ceremoniesData3);

        agendasDataBase.put(agenda.getSprintId(),agenda);
        agendasDataBase.put(agenda2.getSprintId(),agenda2);
        agendasDataBase.put(agenda3.getSprintId(),agenda3);
    }

    public Agenda getAgendaFromDataBaseByID(int id)
    {
        return agendasDataBase.get(id);
    }

    public AgendaList getAllAgendas()
    {
        List<Agenda> newList = new ArrayList();

        agendasDataBase.values().forEach(agenda -> {
            System.out.println("New agenda for list: "+agenda.getDescription()+" : "+agenda.getUuid());
            newList.add(agenda);

        });

        AgendaList agendas = new AgendaList(newList);

        return agendas;
    }

    public void createAgendaOnDataSource(Agenda newAgenda){

        Integer key = newAgenda.getSprintId();
        System.out.println("New agenda with: "+newAgenda.getSprintId());
        agendasDataBase.put(key,newAgenda);

        agendasDataBase.values().forEach(agenda ->
            System.out.println("actual database:"+agenda.getSprintId()+" : "+agenda.getUuid()));



}
}
