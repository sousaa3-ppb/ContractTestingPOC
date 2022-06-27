package agendasconsumer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class KonamiAgendasProviderClient {

    private final RestTemplate restTemplate;

    public KonamiAgendasProviderClient(String baseUrl){
        this.restTemplate = new RestTemplateBuilder().
                rootUri(baseUrl).
                defaultHeader("Connection","close").
                build();
    }

    public Agenda getAgenda(String sprintID)
    {
        return restTemplate.getForObject(String.format("/agendas/sprint/%s", sprintID), Agenda.class);
    }

    public AgendaList getAllAgendas()
    {
        return restTemplate.getForObject(String.format("/agendas"), AgendaList.class);
    }

    public BetReport getBets(){
       return restTemplate.getForObject("/api/FixedOddsBetReporting/v1.0/searchBets?sortDir=DESC", BetReport.class);
    }


}
