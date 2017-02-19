package br.com.serpente;

import java.awt.Color;

public interface Constantes {
	public static final boolean INICIAR_MODO_DEMO = true;
	
	public static final byte TOTAL_FASES = 1;

	public static final short TOTAL_POR_FASE = 500;

	public static final byte LADO_QUADRADO = 10;

	public static final Color COR_CABECA = Color.BLUE;

	public static final Color COR_CORPO = Color.BLACK;

	public static final short INTERVALO_MOVIMENTO = 100;

	public static final short INTERVALO_DECREMENTO = 0;

	public static final int COMPRIMENTO_SERPENTE = TOTAL_FASES * TOTAL_POR_FASE;

	public static final short LARGURA_JANELA = 1000;

	public static final short ALTURA_JANELA = 800;
	
	public static final Color[] CORES = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE};
}