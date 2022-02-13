package provider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.StateChangeAction;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRestPactRunner.class)
@Provider("konami-agendas-provider")
@PactBroker(host = "localhost",port = "80")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AgendaDataProviderContractTest {

    AgendaUtils utils = new AgendaUtils();

@TestTarget
public final Target target = new SpringBootHttpTarget();

@State(value = "Agenda for sprint 105",action = StateChangeAction.SETUP)
    public void createAgenda(){

       Agenda agenda = new Agenda();
       agenda.setSprintId(105);
       agenda.setDescription("Konami All Day Agenda for sprint 105");
       agenda.setDate("18/02/2022");
       Map<String,String> ceremoniesData = new LinkedHashMap();
       ceremoniesData.put("refinement","09:30");
       ceremoniesData.put("planning","10:30");
       ceremoniesData.put("lunch","12:00");
       ceremoniesData.put("retrospective","14:00");
       ceremoniesData.put("sharingsessions","15:00");
       agenda.setCeremonies(ceremoniesData);

       utils.createAgenda(agenda);


}

    @State(value = "a list of existing agendas",action = StateChangeAction.SETUP)
    public void createAgendasList(){

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

        utils.createAgenda(agenda1);
        utils.createAgenda(agenda2);


    }


}

