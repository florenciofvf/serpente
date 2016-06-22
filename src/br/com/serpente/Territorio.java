package br.com.serpente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Territorio extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Random random = new Random();
	private final Visao visao;
	private Serpente serpente;

	public Territorio(Visao visao) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		this.visao = visao;
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		
		No isca = serpente.getIsca();

		if (isca != null) {
			isca.desenhar(g2);
		}

		serpente.desenhar(g2);
	}

	public void atualizarVisao() {
		repaint();
	}

	public void criarSerpente() {
		serpente = new Serpente();
		serpente.setTerritorio(this);
		serpente.setOuvinte(visao);
	}

	public int getLargura() {
		return getWidth();
	}

	public int getAltura() {
		return getHeight();
	}

	public void criarIsca() {
		visao.setTitulo("Tamanho = " + serpente.getTamanho());

		Posicao pos = criarPosicaoAleatoriaEm(getLargura(), getAltura());

		Pedaco pedaco = new Pedaco();
		pedaco.x = pos.x;
		pedaco.y = pos.y;

		serpente.setIsca(pedaco);
	}

	private Posicao criarPosicaoAleatoriaEm(int largura, int altura) {
		Posicao posicao = new Posicao();

		int aux = largura / Constantes.LADO_QUADRADO;
		int x = random.nextInt(aux);
		posicao.x = x * Constantes.LADO_QUADRADO;

		aux = altura / Constantes.LADO_QUADRADO;
		int y = random.nextInt(aux);
		posicao.y = y * Constantes.LADO_QUADRADO;

		return posicao;
	}

	public Serpente getSerpente() {
		return serpente;
	}

}

class Posicao {
	int x;
	int y;
}