package br.ufg.inf.backend.utils;

public class ParreiraException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String titulo;

	public ParreiraException(String msg) {
		super(msg);
	}

	public ParreiraException(String titulo, String msg) {
		super(msg);
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
	
}
