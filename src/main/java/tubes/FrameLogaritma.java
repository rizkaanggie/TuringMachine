package tubes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameLogaritma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textSteps;
	private JTextArea txtArea;
	private JButton btnResult;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnLeft;
	private JButton btnMostLeft;
	private JButton btnRight;
	private JButton btnMostRight;
	
	static TuringMachine output;
	static int currentStep;
	static boolean play; 

	public FrameLogaritma() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogaritma.class.getResource("/img/logo.png")));
		setTitle("Operasi Logaritma");
		setBounds(100, 100, 640, 480);
		setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Simulator.simulator.setVisible(true);
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		currentStep = 0;
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Logaritma Biner", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 8, 600, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 600, 272);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		scrollPane.setViewportView(txtArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(124, 31, 342, 20);
		panel.add(textField);

		textSteps = new JTextField();
		textSteps.setEnabled(false);
		textSteps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (Integer.valueOf(textSteps.getText()) > output.totalSteps) {
					textSteps.setText(String.valueOf(output.totalSteps));
				}
			}
		});
		textSteps.setHorizontalAlignment(SwingConstants.CENTER);
		textSteps.setBounds(516, 407, 43, 23);
		contentPane.add(textSteps);
		textSteps.setColumns(10);
		
		btnLeft = new JButton("???");
		btnMostLeft = new JButton("???");
		btnRight = new JButton("???");
		btnMostRight = new JButton("???");

		btnLeft.setEnabled(false);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");
				currentStep--;
				setView(currentStep);
				textSteps.setText(String.valueOf(currentStep));
				System.out.println(currentStep);
				if (currentStep <= 0) {
					currentStep = 0;
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(false);
					btnMostLeft.setEnabled(false);
				} else if (currentStep == output.totalSteps - 1) {
					textSteps.setText(String.valueOf(output.totalSteps - 1));
					btnRight.setEnabled(false);
				} else {
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(true);
					btnMostLeft.setEnabled(true);
					btnRight.setEnabled(true);
					btnMostRight.setEnabled(true);
				}
			}
		});
		btnLeft.setBounds(180, 407, 60, 23);
		contentPane.add(btnLeft);
		
		btnMostLeft.setEnabled(false);
		btnMostLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlay.setEnabled(true);
				txtArea.setText("");
				currentStep = 0;
				setView(currentStep);
				textSteps.setText(String.valueOf(currentStep));
				System.out.println(currentStep);
				btnLeft.setEnabled(false);
				btnMostLeft.setEnabled(false);
				if (currentStep == output.totalSteps - 1) {
					textSteps.setText(String.valueOf(output.totalSteps - 1));
					btnRight.setEnabled(false);
				} else if (currentStep == 0) {
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(false);
					btnMostLeft.setEnabled(false);
					btnRight.setEnabled(true);
					btnMostRight.setEnabled(true);
				}	else {
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(true);
					btnMostLeft.setEnabled(true);
					btnRight.setEnabled(true);
					btnMostRight.setEnabled(true);
				}
			}
		});
		btnMostLeft.setBounds(110, 407, 60, 23);
		contentPane.add(btnMostLeft);
		
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");
				currentStep++;
				setView(currentStep);
				textSteps.setText(String.valueOf(currentStep));
				System.out.println(currentStep);
				if (currentStep >= output.totalSteps - 1) {
					currentStep = output.totalSteps;
					textSteps.setText(String.valueOf(output.totalSteps - 1));
					btnRight.setEnabled(false);
					btnMostRight.setEnabled(false);
				} else {
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(true);
					btnMostLeft.setEnabled(true);
					btnRight.setEnabled(true);
					btnMostRight.setEnabled(true);
				}
			}
		});
		btnRight.setBounds(360, 407, 60, 23);
		contentPane.add(btnRight);
		
		btnMostRight.setEnabled(false);
		btnMostRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");
				currentStep = output.totalSteps - 1;
				setView(currentStep);
				textSteps.setText(String.valueOf(currentStep));
				System.out.println(currentStep);
				btnLeft.setEnabled(true);
				btnMostLeft.setEnabled(true);
				btnRight.setEnabled(false);
				btnMostRight.setEnabled(false);
				if (currentStep < output.totalSteps - 1) {
					textSteps.setText(String.valueOf(currentStep));
					btnLeft.setEnabled(true);
					btnMostLeft.setEnabled(true);
					btnRight.setEnabled(true);
					btnMostRight.setEnabled(true);
				}
			}
		});
		btnMostRight.setBounds(430, 407, 60, 23);
		contentPane.add(btnMostRight);
		
		JLabel lblNewLabel = new JLabel("/ -");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(567, 411, 43, 14);
		contentPane.add(lblNewLabel);
		
		btnPause = new JButton("???");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPause.setEnabled(false);
				btnPlay.setEnabled(true);
				play = false;
			}
		});
		btnPause.setEnabled(false);
		btnPause.setBounds(250, 407, 45, 23);
		contentPane.add(btnPause);
		
		btnPlay = new JButton("???");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play = true;
				btnLeft.setEnabled(true);
				btnMostLeft.setEnabled(true);
				btnPause.setEnabled(true);
				btnPlay.setEnabled(false);
				Thread thread = new Thread(() -> {
				    while (currentStep < output.totalSteps - 1) {
				    	if(play == true) {						
							transition();
						}
				    }
				    btnRight.setEnabled(false);
				    btnMostRight.setEnabled(false);
				});
				thread.start();
			}
		});
		btnPlay.setEnabled(false);
		btnPlay.setBounds(305, 407, 45, 23);
		contentPane.add(btnPlay);
		
		btnResult = new JButton("Hitung");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setEnabled(true);
				txtArea.setText("");
				textSteps.setEnabled(true);
				btnPlay.setEnabled(true);
				btnLeft.setEnabled(false);
				btnMostLeft.setEnabled(false);
				btnRight.setEnabled(true);
				btnMostRight.setEnabled(true);
				
				play = false;
				currentStep = 0;
				
				String input = textField.getText();
				
				output = Logaritma.start(Integer.valueOf(input));
				textSteps.setText(String.valueOf(currentStep));
				
				lblNewLabel.setText("/ " + (output.totalSteps - 1));
				setView(currentStep);
			}
		});
		btnResult.setBounds(124, 62, 342, 23);
		panel.add(btnResult);
	}
	
	public void setView(int stepAt) {
		txtArea.append("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n");
		txtArea.append("                                       STEP " + (stepAt) + "\n");
		txtArea.append("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n\n");
		if (stepAt == 0 ) {
			txtArea.append("States: -\t\t");
			txtArea.append("Current state: Q0 \t\tStarting State\n");
			txtArea.append("Symbol: -\t\t");
			txtArea.append("Current symbol: 0BB\n\n");
		} else if (stepAt == output.totalSteps - 1) {
			txtArea.append("States: " + output.getStateBefore(stepAt)+ " ??? " + output.getStateAfter(stepAt) + "\t\t");
			txtArea.append("Current state: " + output.getStateAfter(stepAt) + "\t\tEnding State\n");
			txtArea.append("Symbol: " + output.getSymbolBefore(stepAt) + " ??? " + output.getSymbolAfter(stepAt) + "\t\t");
			txtArea.append("Current symbol: " + output.getNextSymbolTape1(stepAt) + "\n\n");
		} else {
			txtArea.append("States: " + output.getStateBefore(stepAt)+ " ??? " + output.getStateAfter(stepAt) + "\t\t");
			txtArea.append("Current state: " + output.getStateAfter(stepAt) + "\n");
			txtArea.append("Symbol: " + output.getSymbolBefore(stepAt) + " ??? " + output.getSymbolAfter(stepAt) + "\t\t");
			txtArea.append("Current symbol: " + output.getNextSymbolTape1(stepAt) + "\n\n");
		}
		String pointer_1 = "\t";
		for (int i = 0; i < output.getHead1Record(stepAt); i++) {
			pointer_1 = pointer_1.concat(" ");
		}
		txtArea.append(pointer_1.concat("???") + "\n");
		txtArea.append("Tape 1  " + output.getTape1Record(stepAt) + "\n");
		txtArea.append("\n");	
		int result = output.getResultTape1();
		txtArea.append("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n");
		txtArea.append("                                     Result = " + result + "\n");
		txtArea.append("????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
	}
	
	public void transition() {
		try {
			Thread.sleep(300);
			currentStep++;
			if(currentStep >= output.totalSteps) {
				play = false;
				btnRight.setEnabled(false);
				btnMostRight.setEnabled(false);
			} else {
				txtArea.setText("");
				setView(currentStep);
				textSteps.setText(String.valueOf(currentStep));				
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
