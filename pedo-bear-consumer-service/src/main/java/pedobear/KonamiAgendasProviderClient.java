package pedobear;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class KonamiAgendasProviderClient {

    private final RestTemplate restTemplate;

    public KonamiAgendasProviderClient(String baseUrl){
        System.out.println("oi oi: "+baseUrl);
        this.restTemplate = new RestTemplateBuilder().
                rootUri(baseUrl).
                defaultHeader("Connection","close").
                build();
    }

    public Agenda getAgenda(String sprintID)
    {
        System.out.println("Passei aqui 2");
        return restTemplate.getForObject(String.format("/sprint/%s", sprintID), Agenda.class);
    }
}
