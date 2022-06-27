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
import agendasconsumer.BetReport;
import agendasconsumer.KonamiAgendasProviderClient;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
public class FBRSearchBetsContractTests {

    private static final int accountID = 324;
    private static final String currencyCode = "GBP";
    private static final String localeCode = "en";
    private static final long numberOfMatches = 0;
    private static final boolean moreAvailable = false;

    @Pact(consumer = "agendas-consumer", provider = "fixed-odds-bet-reporting")
    public RequestResponsePact accountWithoutBets(PactDslWithProvider builder) {

        PactDslJsonBody betReport = new PactDslJsonBody().minArrayLike("bets",0).closeArray().asBody()
                .integerType("accountId", accountID)
                .stringType("currencyCode",currencyCode)
                .stringType("localeCode",localeCode)
                .numberType("numberOfMatches",numberOfMatches)
                .booleanType("moreAvailable",moreAvailable);

        Map<String, String> response_headers = new HashMap<String, String>();
        response_headers.put("Content-Type", "application/json");

        return builder
                .given("exists an account without bets")
                .uponReceiving("a search bets for that account")
                .path("/api/FixedOddsBetReporting/v1.0/searchBets")
                .method("GET")
                .matchQuery("sortDir","DESC","DESC")
                //.headerFromProviderState("X-Authentication","{$token}","MzI0")
                .willRespondWith()
                .status(200)
                .matchHeader("Content-Type","application/json;charset=utf-8")
                //.headers(response_headers)
                .body(betReport)
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "accountWithoutBets")
    void shouldProcessAccountWithoutBets(MockServer mockServer) {


        BetReport test = new KonamiAgendasProviderClient(mockServer.getUrl()).getBets();

       // AgendaList response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAllAgendas();
       // assertThat((response.agendas.get(1).getSprintId())).isEqualTo(105);
        //WIP write all assertions over this list

    }

    @Pact(consumer = "agendas-consumer", provider = "fixed-odds-bet-reporting")
    public RequestResponsePact accountWithoutBets2(PactDslWithProvider builder) {

        PactDslJsonBody betReport = new PactDslJsonBody().minArrayLike("bets",0).closeArray().asBody()
                .integerType("accountId", 355)
                .stringType("currencyCode",currencyCode)
                .stringType("localeCode",localeCode)
                .numberType("numberOfMatches",numberOfMatches)
                .booleanType("moreAvailable",moreAvailable);

        Map<String, String> response_headers = new HashMap<String, String>();
        response_headers.put("Content-Type", "application/json");

        return builder
                .given("exists an account without bets")
                .uponReceiving("a search bets for that account")
                .path("/api/FixedOddsBetReporting/v1.0/searchBets")
                .method("GET")
                .matchQuery("sortDir","DESC","DESC")
                //.headerFromProviderState("X-Authentication","{$token}","MzI0")
                .willRespondWith()
                .status(200)
                .matchHeader("Content-Type","application/json;charset=utf-8")
                //.headers(response_headers)
                .body(betReport)
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "accountWithoutBets2")
    void shouldProcessAccountWithoutBets2(MockServer mockServer) {


        BetReport test = new KonamiAgendasProviderClient(mockServer.getUrl()).getBets();

        // AgendaList response = new KonamiAgendasProviderClient(mockServer.getUrl()).getAllAgendas();
        // assertThat((response.agendas.get(1).getSprintId())).isEqualTo(105);
        //WIP write all assertions over this list

    }



}
