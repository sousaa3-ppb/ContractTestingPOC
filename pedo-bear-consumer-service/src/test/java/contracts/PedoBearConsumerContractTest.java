package contracts;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.dsl.PactDslWithState;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pedobear.AgendaList;
import pedobear.KonamiAgendasProviderClient;
import pedobear.Agenda;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
public class PedoBearConsumerContractTest{

    @Pact(provider = "konami-agendas-provider",consumer = "pedo-bear-consumer")
    protected RequestResponsePact getAgendaBySprintID(PactDslWithProvider builder) {
        PactDslJsonBody body = new PactDslJsonBody()
                .valueFromProviderState("uuid","uuid","243f3214-58da-4223-8b1a-95aab51dce9d")
                .integerType("sprintId",105)
                .stringType("date")
                .object("ceremonies")
                .stringType("refinement")
                .stringType("planning")
                .stringType("lunch")
                .stringType("retrospective")
                .stringType("sharingsessions")
                .closeObject()
                .asBody();

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("Agenda for sprint 105")
                .uponReceiving("get Konami All-Day Agenda 105")
                .path("/agendas/sprint/105")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(body)
                .toPact();
    }

    @Pact(provider = "konami-agendas-provider",consumer = "pedo-bear-consumer")
    protected RequestResponsePact getAllAgendasPact(PactDslWithProvider builder) {

        PactDslJsonBody agendasBody = new PactDslJsonBody()
                .minArrayLike("agendas",2)
                .integerType("sprintId")
                .stringType("date")
                .object("ceremonies")
                .stringType("refinement")
                .stringType("planning")
                .stringType("lunch")
                .stringType("retrospective")
                .stringType("sharingsessions")
                .closeObject().closeArray().asBody();


        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("a list of existing agendas")
                .uponReceiving("get all agendas")
                .path("/agendas")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(agendasBody)
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getAgendaBySprintID")
     void shouldGetAgenda(MockServer mockServer) {

        Agenda response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAgenda("105");
        assertThat((response.getSprintId())).isEqualTo(105);

    }

    @Test
    @PactTestFor(pactMethod = "getAllAgendasPact")
    void shouldGetAgendasList(MockServer mockServer) {


        AgendaList response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAllAgendas();


    }

}
