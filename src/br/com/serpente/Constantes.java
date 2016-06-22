package br.com.serpente;

import java.awt.Color;

public interface Constantes {
	public static final byte TOTAL_FASES = 2;

	public static final byte TOTAL_POR_FASE = 5;

	public static final byte LADO_QUADRADO = 10;

	public static final Color COR_CABECA = Color.BLUE;

	public static final Color COR_CORPO = Color.BLACK;

	public static final short INTERVALO_MOVIMENTO = 200;

	public static final short INTERVALO_DECREMENTO = 50;

	public static final int COMPRIMENTO_SERPENTE = TOTAL_FASES * TOTAL_POR_FASE;

	public static final short LARGURA_JANELA = 500;

	public static final short ALTURA_JANELA = 400;
}