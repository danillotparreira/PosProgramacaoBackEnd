package br.ufg.inf.backend.ioc;

public class SMSNotificacaoService implements NotificacaoService{

	@Override
	public void enviarNotificacao(String msg) {
		System.out.printf("Enviando SMS...\n%s", msg);	
	}

}
