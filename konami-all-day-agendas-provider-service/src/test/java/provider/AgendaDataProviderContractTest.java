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

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRestPactRunner.class)
@Provider("konami-agendas-provider")
@PactBroker(host = "localhost",port = "80")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AgendaDataProviderContractTest {

    AgendaUtils utils = new AgendaUtils();

@TestTarget
public final Target target = new SpringBootHttpTarget();

@State(value = "Agenda for sprint 105",action = StateChangeAction.SETUP)
    public Map<String,Object> createAgenda(Map<String,Object> params){

       Map<String,Object> mapUUID = new HashMap<>();
            String uuid = utils.createAgendaWithId(105);
       mapUUID.put("uuid",uuid);

       System.out.println("UUID generated at callback provider state: "+uuid);
       return mapUUID;
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

