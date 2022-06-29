package provider;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class KonamiAgendaController {

    private final KonamiAgendaService konamiAgendaService;

    public KonamiAgendaController(KonamiAgendaService konamiAgendaService) {
        this.konamiAgendaService = konamiAgendaService;
    }

    @GetMapping(value = "agendas/sprint/{id}", produces="application/json")
    public Agenda getAgenda(@PathVariable int id) {

        System.out.println("Getting agenda for sprintId: "+id);

        return konamiAgendaService.getAgenda(id);
    }

    @GetMapping(value = "agendas", produces ="application/json")
    public AgendaList getAllAgendas(){

        System.out.println("Getting all existing agendas");

        return konamiAgendaService.getAll();
    }




}
