package br.com.serpente;

import java.awt.Graphics2D;

import static br.com.serpente.Constantes.*;

public class Pedaco extends No {

	@Override
	public void desenhar(Graphics2D g2) {
		g2.setColor(cor);
		g2.fillRect(x, y, LADO_QUADRADO, LADO_QUADRADO);

		if (proximo != null) {
			proximo.desenhar(g2);
		}
	}

}