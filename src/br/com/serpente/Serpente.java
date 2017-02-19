package br.com.serpente;

import java.awt.Graphics2D;

public class Serpente {
	private boolean demo = Constantes.INICIAR_MODO_DEMO;
	private Territorio territorio;
	private Ouvinte ouvinte;
	private THREAD thread;
	private int intervalo;
	private Cabeca cabeca;
	private int tamanho;
	private No cauda;
	private No isca;

	public Serpente() {
		ini();
	}

	public void ini() {
		intervalo = Constantes.INTERVALO_MOVIMENTO;
		cabeca = new Cabeca();
		cabeca.proximo = new Pedaco();
		cauda = cabeca.proximo;
		cabeca.leste();
		cabeca.deslocar();
		tamanho = 1;
	}

	public No getIsca() {
		return isca;
	}

	public void setIsca(No isca) {
		this.isca = isca;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void norte() {
		cabeca.norte();
	}

	public void sul() {
		cabeca.sul();
	}

	public void leste() {
		cabeca.leste();
	}

	public void oeste() {
		cabeca.oeste();
	}

	private void checarIsca() {
		if (cabeca.equals(isca)) {
			cauda.proximo = isca;
			cauda = isca;
			isca = null;
			tamanho++;
			territorio.criarIsca();

			if (tamanho % Constantes.TOTAL_POR_FASE == 0) {
				intervalo -= Constantes.INTERVALO_DECREMENTO;
			}
		}
	}

	private void processar() {
		if(demo && isca != null) {
			if(cabeca.y > isca.y) {
				cabeca.norte();
			}
			
			if(cabeca.y < isca.y) {
				cabeca.sul();
			}			

			if(cabeca.x > isca.x) {
				cabeca.oeste();
			}

			if(cabeca.x < isca.x) {
				cabeca.leste();
			}
		}
		
		cabeca.deslocar();
		checarLimites();
		checarIsca();
		territorio.atualizarVisao();
	}

	private void checarLimites() {
		if (cabeca.x < 0 || cabeca.y < 0 || cabeca.x >= territorio.getLargura()
				|| cabeca.y >= territorio.getAltura()) {
			throw new IllegalStateException();
		}
	}

	public void pausarReiniciar() {
		if (thread == null) {
			thread = new THREAD();
			thread.start();
		} else {
			thread.desativar();
			thread = null;
		}
	}

	public void desenhar(Graphics2D g2) {
		cabeca.desenhar(g2);
	}

	class THREAD extends Thread {
		private boolean ativo = true;

		void desativar() {
			ativo = false;
		}

		public void run() {
			while (ativo && tamanho < Constantes.COMPRIMENTO_SERPENTE) {
				try {
					Thread.sleep(intervalo);
					processar();
				} catch (Exception e) {
					ouvinte.limiteUltrapassado();
					ativo = false;
					break;
				}
			}

			if (ativo) {
				ouvinte.tamanhoCompletado();
			}
		}
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	public void setOuvinte(Ouvinte ouvinte) {
		this.ouvinte = ouvinte;
	}

	public boolean isDemo() {
		return demo;
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}
}