package br.com.serpente;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class No {
	protected No proximo;
	protected Color cor;
	protected int x;
	protected int y;

	public void deslocar(int novoX, int novoY) {
		int bkpX = x;
		int bkpY = y;

		x = novoX;
		y = novoY;

		if (proximo != null) {
			proximo.deslocar(bkpX, bkpY);
		}
	}

	public abstract void desenhar(Graphics2D g2);

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof No) {
			No outro = (No) obj;
			return x == outro.x && y == outro.y;
		}

		return false;
	}
}