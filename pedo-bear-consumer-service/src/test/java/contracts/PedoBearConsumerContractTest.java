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
import pedobear.KonamiAgendasProviderClient;
import pedobear.Agenda;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "konami-agendas-provider")
public class PedoBearConsumerContractTest{

    @Pact(consumer = "pedo-bear-consumer")
    protected RequestResponsePact createPact(PactDslWithProvider builder) {
        PactDslJsonBody body = new PactDslJsonBody()
                .integerType("sprintId",104)
                .stringType("refinement")
                .stringType("planning")
                .stringType("lunch")
                .stringType("retrospective")
                .stringType("sharingsession");

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        return builder.uponReceiving("can get Konami All-Day Agenda")
                .path(String.format("/sprint/%s", 104))
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(body)
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "createPact")
     void runTest(MockServer mockServer) {


        Agenda response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAgenda("104");
        assertThat((response.getSprintId())).isEqualTo(104);


    }

}
