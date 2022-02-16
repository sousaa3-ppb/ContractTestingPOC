package contracts;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
public class PedoBearConsumerContractTest{

    private static final String regex_ceremonies = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";
    private static final String regex_date = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    private static final int sprintID = 105;

    @Pact(consumer = "pedo-bear-consumer",provider = "konami-agendas-provider")
    public RequestResponsePact getAgendaBySprintID(PactDslWithProvider builder) {
        PactDslJsonBody body = new PactDslJsonBody()
                .integerType("sprintId",sprintID)
                .stringMatcher("date",regex_date,"01/01/2022")
                .object("ceremonies")
                .stringMatcher("refinement",regex_ceremonies,"09:30")
                .stringMatcher("planning",regex_ceremonies,"10:30")
                .stringMatcher("lunch",regex_ceremonies,"12:00")
                .stringMatcher("retrospective",regex_ceremonies,"14:00")
                .stringMatcher("sharingsessions",regex_ceremonies,"15:30")
                .closeObject()
                .asBody();

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("exists an Agenda for a given sprint")
                .uponReceiving("a request to retrieve an agenda")
                .pathFromProviderState("/agendas/sprint/${id}","/agendas/sprint/105")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(body)
                .toPact();
    }

    @Pact(consumer = "pedo-bear-consumer",provider = "konami-agendas-provider")
    public RequestResponsePact getAllAgendasPact(PactDslWithProvider builder) {

        PactDslJsonBody agendasBody = new PactDslJsonBody()
                .minArrayLike("agendas",2)
                .integerType("sprintId",sprintID)
                .stringMatcher("date",regex_date,"01/01/2022")
                .object("ceremonies")
                .stringMatcher("refinement",regex_ceremonies,"09:30")
                .stringMatcher("planning",regex_ceremonies,"10:30")
                .stringMatcher("lunch",regex_ceremonies,"12:00")
                .stringMatcher("retrospective",regex_ceremonies,"14:00")
                .stringMatcher("sharingsessions",regex_ceremonies,"15:30")
                .closeObject()
                .closeArray()
                .asBody();


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
        assertThat((response.getDate())).isEqualTo("01/01/2022");
        assertThat((response.getCeremonies().get("refinement"))).isEqualTo("09:30");
        assertThat((response.getCeremonies().get("planning"))).isEqualTo("10:30");
        assertThat((response.getCeremonies().get("lunch"))).isEqualTo("12:00");
        assertThat((response.getCeremonies().get("retrospective"))).isEqualTo("14:00");
        assertThat((response.getCeremonies().get("sharingsessions"))).isEqualTo("15:30");



    }

    @Test
    @PactTestFor(pactMethod = "getAllAgendasPact")
    void shouldGetAgendasList(MockServer mockServer) {


        AgendaList response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAllAgendas();
        assertThat((response.agendas.get(1).getSprintId())).isEqualTo(105);
        //WIP write all assertions over this list


    }

}
