import java.awt.*;        // Uses AWT's Layout Managers
import java.awt.event.*;  // Uses AWT's Event Handlers
import javax.swing.*;     // Uses Swing's Container/Components

public class BoardSetupUI extends JFrame {
	// Name-constants for UI control (sizes, colors and fonts)
	public static final int CELL_SIZE = 60;   // Cell width/height in pixels
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
	private JTextField[][] boardFrame;
	
	/*public BoardSetupUI(Space[] board, int size) {
		boardFrame = new JTextField[size][size];
		Container cp = getContentPane();
	    cp.setLayout(new GridLayout(size, size + 30));
	    for (int row = 0; row < size; ++row) {
	    	for (int col = 0; col < size; ++col) {
	    		boardFrame[row][col] = new JTextField(); 
	    		cp.add(boardFrame[row][col], BorderLayout.NORTH);            // ContentPane adds JTextField
	    		boardFrame[row][col].setText("");
	    		boardFrame[row][col].setEditable(true);
	    		boardFrame[row][col].setBackground(Color.WHITE);
	    		// Clean up all the cells
	    		boardFrame[row][col].setHorizontalAlignment(JTextField.CENTER);
	    		boardFrame[row][col].setFont(FONT_NUMBERS);
	    	}
	   }
	  
       // Set the size of the content-pane and pack all the components
       //  under this container.
       cp.setPreferredSize(new Dimension(CELL_SIZE * size, CELL_SIZE * size + 30));
       pack();
       
       //JPanel buttons = new JPanel();
       //buttons.setSize(new Dimension(CELL_SIZE * size, 30));
       //JButton done = new JButton();
       //done.setText("Done");
       //done.setEnabled(true);
       //buttons.add(done);
       //cp.add(buttons, BorderLayout.SOUTH);
       	//buttons.add
  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
       setTitle("Scrabble");
       setVisible(true);
	}*/
	
	public BoardSetupUI(Space[] board, int size) {
		JPanel BoardSetupUI = new JPanel();
		JPanel frame = new JPanel();
		frame.setLayout(new GridLayout(size, size));
		boardFrame = new JTextField[size][size];
	    for (int row = 0; row < size; ++row) {
	    	for (int col = 0; col < size; ++col) {
	    		boardFrame[row][col] = new JTextField();
	    		frame.add(boardFrame[row][col], BorderLayout.NORTH);
	    		boardFrame[row][col].setText("");
	    		boardFrame[row][col].setEditable(true);
	    		boardFrame[row][col].setBackground(Color.WHITE);
	    		// Clean up all the cells
	    		boardFrame[row][col].setHorizontalAlignment(JTextField.CENTER);
	    		boardFrame[row][col].setFont(FONT_NUMBERS);
	    	}
	   }
	   frame.setPreferredSize(new Dimension(CELL_SIZE * size, CELL_SIZE * size));
	    
	   JPanel buttons = new JPanel();
	   JButton done = new JButton();
	   done.setText("Done");
	   done.setEnabled(true);
	   done.addActionListener(e -> {
		   for (int row = 0; row < size; ++row) { //y
		    	for (int col = 0; col < size; ++col) { //x
		    		board[col + size * (size - 1 - row)].setMultiplier(boardFrame[row][col].getText());
		    	}
		   }
		   this.dispose();
	   });
	   JButton reset = new JButton();
	   reset.setText("Reset");
	   reset.setEnabled(true);
	   reset.addActionListener(e -> {
		   for (int row = 0; row < size; ++row) {
		    	for (int col = 0; col < size; ++col) {
		    		boardFrame[row][col].setText("");
		    	}
		   }
	   });
	   buttons.add(reset);
	   buttons.add(done);
	   
	   frame.setVisible(true);
	   
	   BoardSetupUI.add(frame, BorderLayout.NORTH);
	   BoardSetupUI.add(buttons, BorderLayout.SOUTH);
	   
	   setPreferredSize(new Dimension(CELL_SIZE * size + 50, CELL_SIZE * size + 100));
       pack();
       setContentPane(BoardSetupUI);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
       setTitle("Scrabble");
       setVisible(true);
	}
	
}
