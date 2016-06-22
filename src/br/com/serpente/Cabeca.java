package br.com.serpente;

import java.awt.Graphics2D;

public class Cabeca extends No {
	private int deltaX;
	private int deltaY;

	public void deslocar() {
		deslocar(x + deltaX, y + deltaY);
	}

	public void norte() {
		deltaX = 0;
		deltaY = -LADO_QUADRADO;
	}

	public void sul() {
		deltaX = 0;
		deltaY = LADO_QUADRADO;
	}

	public void leste() {
		deltaX = LADO_QUADRADO;
		deltaY = 0;
	}

	public void oeste() {
		deltaX = -LADO_QUADRADO;
		deltaY = 0;
	}

	@Override
	public void desenhar(Graphics2D g2) {
		g2.setColor(Constantes.COR_CABECA);
		g2.fillRect(x, y, LADO_QUADRADO, LADO_QUADRADO);

		if (proximo != null) {
			g2.setColor(Constantes.COR_CORPO);
			proximo.desenhar(g2);
		}
	}

}