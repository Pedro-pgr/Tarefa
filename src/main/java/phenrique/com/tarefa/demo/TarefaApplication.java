package phenrique.com.tarefa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TarefaApplication implements CommandLineRunner{

	// Lista em memória para armazenar tarefas
	private List<Tarefa> tarefas = new ArrayList<>();
	private long proximoId = 1;

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== SISTEMA DE GERENCIAMENTO DE TAREFAS ===\n");

		// TESTE 1: ADICIONAR TAREFAS
		System.out.println("--- TESTE 1: ADICIONAR TAREFAS ---");
		adicionar("Estudar Java", Tarefa.Status.EM_ANDAMENTO,
				"Estudos", LocalDate.now(), "Estudar POO e Collections");
		adicionar("Fazer Compras", Tarefa.Status.PENDENTE,
				"Casa", LocalDate.now().plusDays(1), "Comprar frutas e verduras");
		adicionar("Projeto Spring", Tarefa.Status.EM_ANDAMENTO,
				"Trabalho", LocalDate.now().plusDays(7), "Desenvolver API REST");
		System.out.println();

		// TESTE 2: LISTAR TODAS AS TAREFAS
		System.out.println("--- TESTE 2: LISTAR TODAS AS TAREFAS ---");
		getAll();
		System.out.println();

		// TESTE 3: ATUALIZAR UMA TAREFA
		System.out.println("--- TESTE 3: ATUALIZAR TAREFA (ID=1) ---");
		update(1L, "Estudar Java Avançado", Tarefa.Status.CONCLUIDA,
				"Estudos", LocalDate.now(), "Estudar Streams e Lambda");
		getAll();
		System.out.println();

		// TESTE 4: DELETAR UMA TAREFA
		System.out.println("--- TESTE 4: DELETAR TAREFA (ID=2) ---");
		delete(2L);
		getAll();
		System.out.println();

		// TESTE 5: TENTAR BUSCAR TAREFA DELETADA
		System.out.println("--- TESTE 5: BUSCAR TAREFA DELETADA (ID=2) ---");
		Tarefa tarefaDeletada = buscarPorId(2L);
		if (tarefaDeletada == null) {
			System.out.println("Tarefa não encontrada (foi deletada corretamente)");
		}
		System.out.println();

		// TESTE 6: ADICIONAR MAIS TAREFAS
		System.out.println("--- TESTE 6: ADICIONAR NOVA TAREFA ---");
		adicionar("Academia", Tarefa.Status.PENDENTE,
				"Saúde", LocalDate.now(), "Treino de pernas");
		getAll();
		System.out.println();

		System.out.println("=== FIM DOS TESTES ===");
	}

	// Método para ADICIONAR tarefa
	public void adicionar(String nome, Tarefa.Status status, String categoria,
						  LocalDate data, String descricao) {
		Tarefa novaTarefa = new Tarefa(proximoId++, nome, status, categoria, data, descricao);
		tarefas.add(novaTarefa);
		System.out.println("✓ Tarefa adicionada: " + novaTarefa);
	}

	// Método para LISTAR todas as tarefas
	public void getAll() {
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa cadastrada.");
			return;
		}

		System.out.println("Total de tarefas: " + tarefas.size());
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
	}

	// Método para DELETAR tarefa por ID
	public void delete(long id) {
		Optional<Tarefa> tarefaParaRemover = tarefas.stream()
				.filter(t -> t.getId() == id)
				.findFirst();
		if (tarefaParaRemover.isPresent()) {
			tarefas.remove(tarefaParaRemover.get());
			System.out.println("✓ Tarefa deletada: ID=" + id);
		} else {
			System.out.println("✗ Tarefa não encontrada: ID=" + id);
		}
	}

	// Método para ATUALIZAR tarefa
	public void update(long id, String nome, Tarefa.Status status, String categoria,
					   LocalDate data, String descricao) {
		Tarefa tarefaExistente = buscarPorId(id);

		if (tarefaExistente != null) {
			tarefaExistente.setNome(nome);
			tarefaExistente.setStatus(status);
			tarefaExistente.setCategoria(categoria);
			tarefaExistente.setData(data);
			tarefaExistente.setDescricao(descricao);
			System.out.println("✓ Tarefa atualizada: " + tarefaExistente);
		} else {
			System.out.println("✗ Tarefa não encontrada: ID=" + id);
		}
	}

	// Método auxiliar para buscar tarefa por ID
	private Tarefa buscarPorId(long id) {
		return tarefas.stream()
				.filter(t -> t.getId() == id)
				.findFirst()
				.orElse(null);
	}
}

