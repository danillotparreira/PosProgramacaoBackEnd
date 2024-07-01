package br.ufg.inf.backend.ioc;

import java.util.Objects;

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

	public Task(long id, String nome) {
		super();
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("id: %d - nome: %s", id, nome);
	}
}
