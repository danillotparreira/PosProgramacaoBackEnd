package br.ufg.inf.backend.ioc;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {
	private NotificacaoService notificacao;
	private List<Task> tarefas;

	public TarefaService(NotificacaoService notificacao) {
		this.notificacao = notificacao;
		this.tarefas = new ArrayList<>();
	}

	public Task adicionar(String nomeTarefa) {
		Task nova = new Task(lastId() + 1, nomeTarefa);
		tarefaNaoIncluida(nova);
		tarefas.add(nova);
		String msg = String.format("Tarefa '%s' foi adicionada.\n", nova.toString());
		notificacao.enviarNotificacao(msg);
		return nova;

	}

	public Task atualizar(long id, String nomeTarefa) {
		Task tarefaEncontrada = buscaTarefa(id);
		if (tarefaEncontrada == null) {
			throw new RuntimeException(String.format("A tarefa com o index %d não está incluida na lista.", id));
		}
		if (tarefaEncontrada.getNome().equals(nomeTarefa)) {
			throw new RuntimeException("A tarefa que está tentando atualizar é igual ao inserida.");
		}
		tarefaNaoIncluida(nomeTarefa);
		tarefaEncontrada.setNome(nomeTarefa);
		notificacao.enviarNotificacao(String.format("A tarefa com o index %d foi atualizado para '%s'\n", tarefaEncontrada.getId(), tarefaEncontrada.getNome()));
		return tarefaEncontrada;
	}

	public void remover(long id) {
		Task tarefaRemover = buscaTarefa(id);
		tarefas.remove(tarefaRemover);
		notificacao.enviarNotificacao(String.format("A tarefa com o id %d foi removida.\n", id));
	}

	public List<Task> listar() {
		return tarefas;
	}

	private void tarefaNaoIncluida(String nomeTarefa) {
		Task task = new Task(nomeTarefa);
		tarefaNaoIncluida(task);
	}

	private void tarefaNaoIncluida(Task task) {
		if (tarefas.contains(task)) {
			throw new RuntimeException(String.format("A tarefa %s já está incluida!", task.getNome()));
		}
	}

	private Task buscaTarefa(long id) {
		for (Task task : tarefas) {
			if (task.getId() == id) {
				return task;
			}
		}
		throw new RuntimeException(String.format("Não foi localizado a tarefa com index %d", id));
	}

	private long lastId() {
		long id = 0l;
		for (Task task : tarefas) {
			if (id < task.getId()) {
				id = task.getId();
			}
		}
		return id;
	}

}
