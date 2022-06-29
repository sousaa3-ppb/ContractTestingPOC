package provider;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.StateChangeAction;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Provider("konami-agendas-provider")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PactBroker(host = "localhost")
public class AgendaDataProviderContractTest {

    @LocalServerPort
    private int port;

    AgendaUtils utils = new AgendaUtils();


    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", 8090));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State(value = "exists an Agenda for a given sprint", action = StateChangeAction.SETUP)
    public Map<String, Object> createAgenda(Map<String, Object> params) {

        System.out.println("Setting up an Agenda");
        Map<String, Object> mapSprintID = new HashMap<>();
        int sprintID = utils.createAgenda();
        mapSprintID.put("id", 300);
        System.out.println("SprintID generated at callback provider state: " + sprintID);
        return mapSprintID;
    }

    @State(value = "exists an Agenda for a given sprint", action = StateChangeAction.TEARDOWN)
    public void deleteAgenda(Map<String, Object> params) {

        System.out.println("Deleting agenda...");

    }

    @State(value = "a list of existing agendas", action = StateChangeAction.SETUP)
    public void createAgendasList() {

        System.out.println("Setting up a list of Agendas");
        utils.createAgendasList();


    }

    @State(value = "a list of existing agendas", action = StateChangeAction.TEARDOWN)
    public void deleteAgendasList() {

        System.out.println("Deleting a list of Agendas");

    }


}

