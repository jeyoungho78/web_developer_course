package JavaFirst;

import javax.swing.*;

public class WindowsExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Morph's House");
		JLabel label = new JLabel("Hello World");
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}
}
