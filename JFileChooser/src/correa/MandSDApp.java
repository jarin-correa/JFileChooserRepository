package correa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**Creates an application
 * that checks the strength of a password.
 * @author jarin
 * @version 1.0
 * 
 */
public class MandSDApp {

	private JFrame frame;
	public JLabel lblMeanAndStandard;
	public JButton btnGF;
	public JScrollPane scrollPane;
	public JTextArea textAreaAns;
	public LinkedList list;

	/**
	 * 
	 * @param args The main method that launches the app
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MandSDApp window = new MandSDApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MandSDApp() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblMeanAndStandard = new JLabel("Mean and Standard Deviation App");
		lblMeanAndStandard.setBounds(130, 11, 181, 14);
		frame.getContentPane().add(lblMeanAndStandard);

		btnGF = new JButton("Get Txt File");
		btnGF.setBounds(145, 55, 139, 32);
		frame.getContentPane().add(btnGF);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 130, 354, 124);
		frame.getContentPane().add(scrollPane);

		textAreaAns = new JTextArea();
		scrollPane.setViewportView(textAreaAns);
		list = new LinkedList();
	}
	/**When button is pressed, buildOutput will run to use that JFileChooser class.
	 * 
	 */

	public void createEvents() {
		btnGF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	/**The JFileChooser class is created to get the txt file.
	 * It then puts the values in an array, the gets added into a linked list
	 * 
	 */

	public void buildOutput() {
		FileChooserClass choose = new FileChooserClass();
		try {
			choose.pick_me();
		} catch (Exception e) {
			e.printStackTrace();
		}
		textAreaAns.setText(choose.s.toString());
		String t = textAreaAns.getText();
		String[] tokens = t.split(",");
		double[] numbers = new double[tokens.length];
		for (int i = 0; i < tokens.length - 1; i++) {
			numbers[i] = Integer.parseInt(tokens[i]);
		}
		list.arrayToList(numbers, numbers.length);

		textAreaAns.setText(t + " \n Mean: " + String.valueOf(list.mean(list.getRoot(), numbers.length))
				+ " Standard Deviation: " + String.valueOf(list.calculateSD()));

	}

}
