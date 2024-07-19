package br.ufg.inf.backend.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.backend.utils.BackEndUtils;
import br.ufg.inf.backend.utils.ParreiraException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tarefa")
public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<Task> tarefas = new ArrayList<>();

	private long lastId() {
		long id = 0l;
		for (Task task : tarefas) {
			if (id < task.getId()) {
				id = task.getId();
			}
		}
		return id;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Lista de Tarefas\n");
		if (!tarefas.isEmpty()) {
			for (Task task : tarefas) {
				resp.getWriter().append(String.format("%d - %s\n", task.getId(), task.getNome()));
			}
		} else {
			resp.getWriter().append("Nenhuma tarefa cadastrada!");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String task = BackEndUtils.validaCampoString(req.getParameter("task"), "task");
			Task nova = new Task(lastId() + 1, task);
			validaTask(nova);
			tarefas.add(nova);
			resp.getWriter()
					.append(String.format("A tarefa '%s' foi adicionado com o id %d.", nova.getNome(), nova.getId()));
		} catch (ParreiraException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	private void validaTask(Task task) {
		if (tarefas.contains(task)) {
			throw new ParreiraException(String.format("A tarefa '%s' já está incluida!", task.getNome()));
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String task = BackEndUtils.validaCampoString(req.getParameter("task"), "task");
			long id = BackEndUtils.validaInteger(req.getParameter("index"), "index");
			for (Task tarefa : tarefas) {
				if (tarefa.getId() == id) {
					validaTask(new Task(task));
					String nomeAnterior = tarefa.getNome();
					tarefa.setNome(task);
					resp.getWriter().append(String.format("A tarefa com o index %d '%s' foi atualizado para '%s'.",
							tarefa.getId(), nomeAnterior, tarefa.getNome()));
					return;
				}
			}
			resp.getWriter().append(String.format("A tarefa com o id %d não está incluida na lista.", id));
		} catch (ParreiraException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			long id = BackEndUtils.validaInteger(req.getParameter("id"), "id");
			tarefas.remove(buscaTask(id));
			resp.getWriter().append(String.format("A tarefa com o id %d foi removida.", id));
		} catch (ParreiraException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	private Task buscaTask(long id) {
		for (Task task : tarefas) {
			if (task.getId() == id) {
				return task;	
			}
		}
		throw new ParreiraException(String.format("Não foi localizado a tarefa com index %d", id));
	}

}
