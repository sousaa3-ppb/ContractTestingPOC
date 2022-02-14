package provider;

import org.springframework.web.bind.annotation.*;

@RestController
public class KonamiAgendaController {

    private final KonamiAgendaService konamiAgendaService;

    public KonamiAgendaController(KonamiAgendaService konamiAgendaService) {
        this.konamiAgendaService = konamiAgendaService;
    }

    @GetMapping("agendas/sprint/{id}")
    public Agenda getAgenda(@PathVariable int id) {

        return konamiAgendaService.getAgenda(id);
    }

    @GetMapping("agendas")
    public AgendaList getAllAgendas(){

        return konamiAgendaService.getAll();
    }




}
