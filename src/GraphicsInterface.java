import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

/**
 * Created by Icamer on 11.09.2016.
 */
public class GraphicsInterface{//test potęgi linuxa xD i nic więcej
    //tak w ogóle ciekawym jest jak płynnie to wszystko może chulać i jak cicho chodzić no bo
//    jednak z jakiegoś powodu z reguły klepię w te wszystkie literki dość mocno, a wcale nie trzeba po prostu tak o

    //declaring components and their hierarchy
    JFrame jFrame;
    JPanel jPanel;
        Box leftBox;
            JLabel jLabelOne;
            JLabel jLabelTwo;
        JTextArea jTextArea;
            JScrollPane jScrollPane;
        Box centerBox;
        Box rightBox;
        JTextField jTextField;
    Thread threadJFrame;
        


    public GraphicsInterface(){
        System.out.println("STARTING WORLD, GraphicsInterface constructor on"); //start console message
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creating components
                jFrame = new JFrame("RolePlaySim");
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jPanel = new JPanel();
                jLabelOne = new JLabel("Im jLabelOne");
                jLabelTwo = new JLabel("Im jLabelTwo");
                jTextArea = new JTextArea(5,20);
                jTextField = new JTextField();
                jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                jScrollPane.getVerticalScrollBar().setValue(jScrollPane.getVerticalScrollBar().getMaximum());
                leftBox = createBox("leftBox");
                rightBox = createBox("rightBox");
                centerBox = createBox("centerBox");

                //listeners
                ListenForEnterOnTextField listenForEnterOnTextField = new ListenForEnterOnTextField();
                jTextField.addKeyListener(listenForEnterOnTextField);

                //setting components
                jScrollPane.setVerticalScrollBar(jScrollPane.createVerticalScrollBar());
                jFrame.setMinimumSize(new Dimension(400,200));
                jPanel.setLayout(new GridBagLayout());
                centerBox.add(new JLabel("Trzeci dalej trzeci"));
                jTextArea.setEditable(false);
                jTextArea.append("This is my not editable tex area\n");

                //adding components
                addComponentToPanel(jPanel, leftBox, 0, 0, 1, 2, GridBagConstraints.WEST, GridBagConstraints.BOTH);
                addComponentToPanel(jPanel, rightBox, 2, 0, 1, 2, GridBagConstraints.WEST, GridBagConstraints.BOTH);
                addComponentToPanel(jPanel, centerBox, 1, 0, 1, 2, GridBagConstraints.WEST, GridBagConstraints.BOTH);
                addComponentToPanel(jPanel, jScrollPane, 0, 2, 5, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH);
                addComponentToPanel(jPanel, jTextField, 0, 3, 5, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH);

                //finish
                jFrame.add(jPanel);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });

        threadJFrame = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
//a
        threadJFrame.start();

    }

    private void addComponentToPanel (JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;
        thePanel.add(comp, gridConstraints);
    }
    private Box createBox (String nameOfBox){
        Box box = Box.createVerticalBox();
        box.add(new JLabel("PierwszyLabel"));
        box.add(new JLabel("DrugiLabel"));
        box.setBorder(BorderFactory.createTitledBorder(nameOfBox));
        return box;
    }

    private class ListenForEnterOnTextField implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==10){
                System.out.println("Enter Pressed");
                onEnterPressed();
            }
            else{
                System.out.println("key pressed: " + e.getKeyChar() + "of code: " + e.getKeyCode());
            }
        }
    }
    private void onEnterPressed(){
        String consoleText = jTextField.getText();
        jTextArea.append(consoleText+"\n");
        jTextField.setText("");
        System.out.println(consoleText);
        jScrollPane.getVerticalScrollBar().setValue(jScrollPane.getVerticalScrollBar().getMaximum()); //przewija jScrollPane na dol


    }



}
