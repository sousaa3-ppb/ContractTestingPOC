package provider;

public class AgendaUtils {

    AgendasDataSource dataSource;

    public AgendaUtils() {
        this.dataSource = new AgendasDataSource();
    }

    public void createAgenda(Agenda newAgenda){

        dataSource.createAgendaOnDataSource(newAgenda);

    }



}
