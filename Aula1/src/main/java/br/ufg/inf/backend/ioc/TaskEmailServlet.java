package br.ufg.inf.backend.ioc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.backend.utils.BackEndUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tarefaEmail")
public class TaskEmailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TarefaService tarefaService;

	public TaskEmailServlet() {
		this.tarefaService = new TarefaService(new EmailNotificacaoService());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		List<Task> tarefas = tarefaService.listar();
		sb.append("Lista de Tarefas\n");
		if (!tarefas.isEmpty()) {
			for (Task task : tarefas) {
				sb.append(String.format("%d - %s\n", task.getId(), task.getNome()));
			}
		} else {
			sb.append("Nenhuma tarefa cadastrada!");
		}
		resp.getWriter().append(sb.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String task = BackEndUtils.validaCampoString(req.getParameter("task"), "task");
			Task nova = tarefaService.adicionar(task);
			resp.getWriter()
					.append(String.format("A tarefa %s foi adicionado com o id %d.", nova.getNome(), nova.getId()));
		} catch (RuntimeException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String task = BackEndUtils.validaCampoString(req.getParameter("task"), "task");
			long id = BackEndUtils.validaInteger(req.getParameter("index"), "index");
			Task tarefa = tarefaService.atualizar(id, task);
			resp.getWriter().append(String.format("A tarefa com o index %d foi atualizado para '%s'.",
					tarefa.getId(), tarefa.getNome()));
		} catch (RuntimeException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			long id = BackEndUtils.validaInteger(req.getParameter("index"), "index");
			tarefaService.remover(id);
			resp.getWriter().append(String.format("A tarefa com o id %d foi removida.", id));
		} catch (RuntimeException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

}
