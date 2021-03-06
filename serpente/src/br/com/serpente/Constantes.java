package br.com.serpente;

import java.awt.Color;

public class Constantes {
	
	private Constantes() {
	}
	
	public static final boolean INICIAR_MODO_DEMO = true;
	
	public static final byte TOTAL_FASES = 10;

	public static final short TOTAL_POR_FASE = 1;

	public static final byte LADO_QUADRADO = 10;

	public static final Color COR_CABECA = Color.BLUE;

	public static final Color COR_CORPO = Color.BLACK;

	public static final short INTERVALO_MOVIMENTO = 110;

	public static final short INTERVALO_DECREMENTO = 10;

	public static final int COMPRIMENTO_SERPENTE = TOTAL_FASES * TOTAL_POR_FASE;

	public static final short LARGURA_JANELA = 800;

	public static final short ALTURA_JANELA = 600;
	
	public static final Color[] CORES = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE};
}