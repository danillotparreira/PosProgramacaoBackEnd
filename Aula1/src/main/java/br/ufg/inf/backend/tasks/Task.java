package br.ufg.inf.backend.tasks;

public class Task {
	private long id;
	private String nome;

	public Task() {
		super();
	}

	public Task(String nome) {
		super();
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
