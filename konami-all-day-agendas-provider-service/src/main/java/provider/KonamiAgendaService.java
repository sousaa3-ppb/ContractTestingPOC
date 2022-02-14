package provider;

import org.springframework.stereotype.Service;

@Service
public class KonamiAgendaService {

    private AgendasDataSource dataSource;

    public KonamiAgendaService(){
        this.dataSource = new AgendasDataSource();
    }

    public Agenda getAgenda(int id) {

        return dataSource.getAgendaFromDataBaseByID(id);

    }

    public AgendaList getAll()
    {
        return dataSource.getAllAgendas();
    }

}
