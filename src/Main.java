import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main extends Frame {



    JLabel lospi;
    JButton no = new JButton("NO :c");
    JButton si = new JButton("SI ;3");
    JLabel uw = new JLabel("");
    int x1 = 170;
    int y1 = 90;
    int x2 = 200;
    int y2 = 120;
    int x3 = 120;
    int y3 = 50;
    int contadorPosicion = 0;


    public Main(){
        setTitle(JOptionPane.showInputDialog(null, "Ingresa el titulo de la aplicacion: "));
        lospi = new JLabel(JOptionPane.showInputDialog(null, "Ingresa la pregunta a la que tendra que decir yes "));
        String message = JOptionPane.showInputDialog(null, "Ingresa el mensaje que se mostrara cuando responda si");
        JOptionPane.showMessageDialog(null, "A romper corazones, o lo que sea by safrax");


        //setTitle("me gane los pi");
        lospi.setBounds(100, 20, 500, 40);
        si.setBounds(40, 70, 100, 30);
        no.setBounds(150, 70, 100, 30);


        si.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(uw);
                uw = new JLabel("sabia que dirias que si");
                uw.setBounds(40, 120, 200, 30);
                //add(uw);
                //repaint();
                dispose();
                JOptionPane.showMessageDialog(null, message);
            }
        });


        ArrayList<Point> posiciones = new ArrayList<>();
        posiciones.add(new Point(x1, y1));
        posiciones.add(new Point(x2, y2));
        posiciones.add(new Point(x3, y3));


        no.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Point siguientePosicion = (Point) ((ArrayList<?>) posiciones).get(contadorPosicion);
                no.setBounds(siguientePosicion.x, siguientePosicion.y, 100, 30);
                repaint();
                contadorPosicion = (contadorPosicion + 1) % posiciones.size();
            }
        });


        add(uw);
        add(lospi);
        add(no);
        add(si);
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Main();

    }
}