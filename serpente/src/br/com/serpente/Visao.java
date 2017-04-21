package br.com.serpente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Visao extends JFrame implements Ouvinte {
	private static final long serialVersionUID = 1L;
	private final Territorio territorio;

	private final JLabel[] rotulos = new JLabel[] { new JLabel("COMANDOS"),
			new JLabel("Seta acima"), new JLabel("Seta abaixo"),
			new JLabel("Seta esquerda"), new JLabel("Seta direita"),
			new JLabel("Espaço (PAUSAR/REINICIAR)"),
			new JLabel("Enter (MODO DEMO)")
			};

	public Visao() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		territorio = new Territorio(this);
		territorio.criarSerpente();
		montarLayout();
		registrarEvento();
	}

	private void montarLayout() {
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, territorio);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		for (JLabel label : rotulos) {
			panel.add(label);
		}

		add(BorderLayout.EAST, panel);
	}

	private void registrarEvento() {
		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					territorio.getSerpente().norte();
					break;

				case KeyEvent.VK_DOWN:
					territorio.getSerpente().sul();
					break;

				case KeyEvent.VK_RIGHT:
					territorio.getSerpente().leste();
					break;

				case KeyEvent.VK_LEFT:
					territorio.getSerpente().oeste();
					break;

				case KeyEvent.VK_SPACE:
					territorio.getSerpente().pausarReiniciar();
					break;

				case KeyEvent.VK_ENTER:
					territorio.getSerpente().setDemo(!territorio.getSerpente().isDemo());
					fonteLabelDemo();
					break;
				}
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				ini();
			}
		});
	}

	public void setTitulo(String s) {
		setTitle(s);
	}

	private void ini() {
		territorio.getSerpente().ini();
		territorio.criarIsca();
		fonteLabelDemo();
		//territorio.getSerpente().pausarReiniciar();
	}
	
	private void fonteLabelDemo() {
		JLabel label = rotulos[rotulos.length - 1];
		label.setForeground(territorio.getSerpente().isDemo() ? Color.RED : Color.BLACK);
	}

	@Override
	public void limiteUltrapassado() {
		JOptionPane.showMessageDialog(this, "Perdeu!");
		ini();
	}

	@Override
	public void tamanhoCompletado() {
		JOptionPane.showMessageDialog(this, "Ganhou!");
		ini();
	}
}