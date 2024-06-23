package br.ufg.inf.backend.calculadora;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Danillo Tomaz Parreira
 */
@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String operacao = validaCampoString(req.getParameter("operacao"), "operacao");
			Double num1 = validaDouble(req.getParameter("num1"), "num1");
			Double num2 = validaDouble(req.getParameter("num2"), "num2");
			Double total;
			String msg;
			switch (operacao) {
			case "somar":
				total = Calculadora.somar(num1, num2);
				msg = String.format("%.2f + %.2f = %.2f\n", num1, num2, total);
				break;
			case "subtrair":
				total = Calculadora.subtrair(num1, num2);
				msg = String.format("%.2f - %.2f = %.2f\n", num1, num2, total);
				break;
			case "multiplicar":
				total = Calculadora.multiplicar(num1, num2);
				msg = String.format("%.2f * %.2f = %.2f\n", num1, num2, total);
				break;
			case "dividir":
				total = Calculadora.dividir(num1, num2);
				msg = String.format("%.2f / %.2f = %.2f\n", num1, num2, total);
			default:
				throw new RuntimeException(
						"A operação não existe, escolha entre as operações: somar, subtrair, multiplicar e dividir");
			}
			resp.getWriter().append(msg);
		} catch (RuntimeException e) {
			resp.getWriter().append(e.getMessage());
		}
	}

	private String validaCampoString(String operacao, String nomeCampo) {
		if (operacao == null || operacao.isBlank()) {
			throw new RuntimeException(String.format("O campo '%s' deve ser preenchido.", nomeCampo));
		}
		return operacao.trim();
	}

	private Double validaDouble(String numero, String nomeCampo) {
		validaCampoString(numero, nomeCampo);
		try {
			return Double.valueOf(numero);
		} catch (NumberFormatException e) {
			throw new RuntimeException(String.format("O campo '%s' deve ser um número válido.", nomeCampo));
		}
	}

}