package phenrique.com.tarefa.demo.modelTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phenrique.com.tarefa.demo.TarefaApplication;
import phenrique.com.tarefa.demo.model.Tarefa;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    @Test
    public void adicionarNovaTarefa(){
        TarefaApplication novaTarefa = new TarefaApplication();
        boolean resultado = novaTarefa.adicionar(
                "TarefaValida", Tarefa.Status.EM_ANDAMENTO, "Testa", LocalDate.now(), "Testando Tarefa");
        assertTrue(resultado); 

    }
    @Test
    public void adcionandoErroTarefa(){
        TarefaApplication novaTarefa = new TarefaApplication();
        boolean resultado = novaTarefa.adicionar("",Tarefa.Status.EM_ANDAMENTO,"Testa",LocalDate.now(),"Testando Tarefa");
        assertFalse(resultado);
    }

}
