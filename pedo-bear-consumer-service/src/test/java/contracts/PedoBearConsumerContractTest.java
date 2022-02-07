package contracts;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import pedobear.KonamiAgendasProviderClient;
import pedobear.Agenda;
import static org.assertj.core.api.Assertions.assertThat;


public class PedoBearConsumerContractTest extends ConsumerPactTestMk2{

    @Override
    protected String providerName() {
        return "konami-agendas-provider";
    }

    @Override
    protected String consumerName() {
        return "pedo-bear-consumer";
    }

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider builder) {
        PactDslJsonBody body = new PactDslJsonBody()
                .integerType("sprintId",104)
                .stringType("refinement")
                .stringType("planning")
                .stringType("lunch")
                .stringType("retrospective")
                .stringType("sharingsession");

        return builder.uponReceiving("can get Konami All-Day Agenda")
                .path(String.format("/sprint/%s", 104))
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(body)
                .toPact();
    }

    @Override
    protected void runTest(MockServer mockServer) {

        System.out.println("Passei aqui");
        Agenda response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAgenda("104");
        assertThat((response.getSprintId())).isEqualTo(104);


    }

}
