/**
* Marcus's Text Tool
* 
* @author  Marcus Wynwood
* 
* Started on:  5th July 2003
* Modified: 5th July 2003
*/
import java.awt.*;
import java.awt.event.*;
import java.lang.String;

public class mTextTool extends Frame implements ActionListener, WindowListener {
 
  Button quitButton, encodeButton, clearButton, l33tEncodeButton, l33tDecodeButton;
  TextArea textArea;
  Panel buttonPanel;
  
 public static void main(String[] args) {
  mTextTool f = new mTextTool();
  f.setSize(600,300);
  f.setVisible(true);
 }
 
 public mTextTool() {
  
  setTitle("mTextTool");
  setLayout(new BorderLayout());

  buttonPanel = new Panel();
  buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
  buttonPanel.setBackground(Color.LIGHT_GRAY);
   
  encodeButton = new Button("Rot13 Encode/Decode");
  buttonPanel.add(encodeButton);
  encodeButton.addActionListener(this);

  l33tEncodeButton = new Button("l33t Encode");
  buttonPanel.add(l33tEncodeButton);
  l33tEncodeButton.addActionListener(this);
  
  l33tDecodeButton = new Button("l33t Decode");
  buttonPanel.add(l33tDecodeButton);
  l33tDecodeButton.addActionListener(this);  
  
  clearButton = new Button("Clear Text");
  buttonPanel.add(clearButton);
  clearButton.addActionListener(this);
  
  quitButton = new Button("Quit");
  buttonPanel.add(quitButton);
  quitButton.addActionListener(this);
  
  add(buttonPanel, BorderLayout.NORTH);
  
  textArea = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  add(textArea);
  
  this.addWindowListener(this);
 }
 
 public void actionPerformed(ActionEvent event) {
  if (event.getSource() == quitButton) {
	System.exit(0);
  }
  if (event.getSource() == encodeButton) {
	textArea.setText(rot13Encode(textArea.getText()));
  }
  if (event.getSource() == l33tEncodeButton) {
	textArea.setText(l33tEncode(textArea.getText()));
  }
  if (event.getSource() == l33tDecodeButton) {
	textArea.setText(l33tDecode(textArea.getText()));
  }  
  if (event.getSource() == clearButton) {
	textArea.setText("");
  }
  repaint();
 }

// takes a string and rot13 encodes it char by char using another method
public static String rot13Encode(String text) {
    String result = "";

    for (int i = 0; i < text.length(); i++) {
     result += rot13char(text.charAt(i)); // is charAt depreciated??
    }
    return result;
}

// this method takes one char and rot13 encodes it
public static char rot13char(char c) {
	int position;
    final int ROTATION = 13; //this number 13 is what makes Rot13, Rot13...

    // if the char is between a and z, do the encoding
    if (('a' <= c) && (c <= 'z')) {
    	position = c - 'a';
        position = (position + ROTATION)%26;
        c = (char)(position + 'a');
    }
    // else if the char is between A and Z do the encoding
    else if (('A' <= c) && (c <= 'Z')) {
        position = c - 'A';
        position = (position + ROTATION)%26;
        c = (char)(position + 'A');
    }
    return c;
}     

// this method makes the text |eet!
public static String l33tEncode(String text) {
	String newText = new String();
	char[] charArray = text.toCharArray();
  
	for (int i = 0; i < charArray.length; i++){	
		Character.toLowerCase(charArray[i]);
		switch (charArray[i]) {
            case 'a':  charArray[i] = '@'; break;
            case 'b':  charArray[i] = 'b'; break;
            case 'c':  charArray[i] = 'C'; break;
            case 'd':  charArray[i] = 'd'; break;
            case 'e':  charArray[i] = '3'; break;
            case 'f':  charArray[i] = 'f'; break;
            case 'g':  charArray[i] = 'G'; break;
            case 'h':  charArray[i] = 'h'; break;
            case 'i':  charArray[i] = '1'; break;
            case 'j':  charArray[i] = 'j'; break;
            case 'k':  charArray[i] = 'k'; break;
            case 'l':  charArray[i] = '|'; break;
            case 'm':  charArray[i] = 'm'; break;
            case 'n':  charArray[i] = 'n'; break;
            case 'o':  charArray[i] = '0'; break;
            case 'p':  charArray[i] = 'P'; break;
            case 'q':  charArray[i] = 'Q'; break;
            case 'r':  charArray[i] = 'r'; break;
            case 's':  charArray[i] = '5'; break;
            case 't':  charArray[i] = '+'; break;
            case 'u':  charArray[i] = 'u'; break;
            case 'v':  charArray[i] = 'v'; break;
            case 'w':  charArray[i] = 'W'; break;
            case 'x':  charArray[i] = 'X'; break;
            case 'y':  charArray[i] = 'Y'; break;
            case 'z':  charArray[i] = '2'; break;
			default:   charArray[i] = charArray[i];
        }
		newText += charArray[i]; // adds the char to the new string that will be returned
	}
	return newText;
}

// this method translates the |eet text back to english
// it doesn't preserve case though
public static String l33tDecode(String text) {
	String newText = new String();
	char[] charArray = text.toCharArray();
  
	for (int i = 0; i < charArray.length; i++){	
		//Character.toLowerCase(charArray[i]);
		switch (charArray[i]) {
            case '@':  charArray[i] = 'a'; break;
            case 'b':  charArray[i] = 'b'; break;
            case 'C':  charArray[i] = 'c'; break;
            case 'd':  charArray[i] = 'd'; break;
            case '3':  charArray[i] = 'e'; break;
            case 'f':  charArray[i] = 'f'; break;
            case 'G':  charArray[i] = 'g'; break;
            case 'h':  charArray[i] = 'h'; break;
            case '1':  charArray[i] = 'i'; break;
            case 'j':  charArray[i] = 'j'; break;
            case 'k':  charArray[i] = 'k'; break;
            case '|':  charArray[i] = 'l'; break;
            case 'm':  charArray[i] = 'm'; break;
            case 'n':  charArray[i] = 'n'; break;
            case '0':  charArray[i] = 'o'; break;
            case 'P':  charArray[i] = 'p'; break;
            case 'Q':  charArray[i] = 'q'; break;
            case 'r':  charArray[i] = 'r'; break;
            case '5':  charArray[i] = 's'; break;
            case '+':  charArray[i] = 't'; break;
            case 'u':  charArray[i] = 'u'; break;
            case 'v':  charArray[i] = 'v'; break;
            case 'W':  charArray[i] = 'w'; break;
            case 'X':  charArray[i] = 'x'; break;
            case 'Y':  charArray[i] = 'y'; break;
            case '2':  charArray[i] = 'z'; break;
			default:   charArray[i] = charArray[i];
        }
		newText += charArray[i]; // adds the char to the new string that will be returned
	}
	return newText;
}

// un-used methods 
 public void windowClosing(WindowEvent event) {
  System.exit(0);
 }
 
 public void windowIconified(WindowEvent event) {
 }
 
 public void windowOpened(WindowEvent event) {
 }
 
 public void windowClosed(WindowEvent event) {
 }
 
 public void windowDeiconified(WindowEvent event) {
 }
 
 public void windowActivated(WindowEvent event) {
 }
 
 public void windowDeactivated(WindowEvent event) {
 }
}
