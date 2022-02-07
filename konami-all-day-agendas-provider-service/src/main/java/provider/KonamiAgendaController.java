package provider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class KonamiAgendaController {

    private final KonamiAgendaService konamiAgendaService;

    public KonamiAgendaController(KonamiAgendaService konamiAgendaService) {
        this.konamiAgendaService = konamiAgendaService;
    }

    @GetMapping("/sprint/{id}")
    public Agenda getAgenda(@PathVariable int id) {

        System.out.println("Fui chamado");
        return konamiAgendaService.getAgenda(id);
    }

}
