import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpBot extends JFrame{
	private JTextField entryText = new JTextField();
	private JTextArea  chatArea  = new JTextArea();
	private JScrollPane pane = new JScrollPane(chatArea);
	
	public SimpBot() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Simplest AI");
		this.setVisible(true);
		
		entryText.setLocation(5,920);
		entryText.setSize(980,30);
		
		entryText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputText = entryText.getText(); entryText.setText("");
				chatArea.append("User: " + inputText + "\n");
				if(inputText.contains("hi") || inputText.contains("hello")) {
					Say("Greetings");
				} else if (inputText.contains("how are you")) {
					int test = randomWithRange(0,2);
					if (test == 0) {
						Say("I'm OK");
					} else if (test == 1){
						Say("I'm good");
					} else {
						Say("I'm fine");
					}
				} else if (inputText.contains("bye")) {
					dispose();
				} else {
					int test = randomWithRange(0,2);
					if (test == 0) {
						Say("What did you say?");
					} else if (test == 1){
						Say("Er?");
					} else {
						Say("Remember, this is a demonstration of BASIC AI, control your expectations...");
					}					
				}	
			}
		});
		
		pane.setVisible(true);
		pane.setLocation(5,5);
		pane.setSize(980,900);
		chatArea.setEditable(false);
		this.add(pane);
		this.add(entryText);
		
	}
	public static void main(String[] args) {
		SimpBot simpBot = new SimpBot();
	}
	
	public int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public void Say(String text) {
		chatArea.append("Bot: " + text + "\n");
	}
}
