package br.ufg.inf.backend.ioc;

public class EmailNotificacaoService implements NotificacaoService{

	@Override
	public void enviarNotificacao(String msg) {
		System.out.printf("Enviando Email...\n%s", msg);
	}

}
