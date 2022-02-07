package provider;

import org.springframework.stereotype.Service;

@Service
public class KonamiAgendaService {

    public Agenda getAgenda(int id) {

        Agenda agenda = new Agenda();
        agenda.setSprintId(id);
        agenda.setRefinement("09:30-10:30");
        agenda.setPlanning("11:00-12:00");
        agenda.setLunch("12:00-14:00");
        agenda.setRetrospective("14:00-15:00");
        agenda.setSharingsession("ContractTestingPOC - 15:00-17:00");

        return agenda;




    }
}
