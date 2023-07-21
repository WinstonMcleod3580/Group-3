package livechatapp;

import javax.swing.*	;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Livechat extends JFrame implements ActionListener{
	
	JTextField text;
	JPanel al;
	Box vertical = Box.createVerticalBox();
	
	Livechat(){
		
		
		setLayout(null);
		
		JPanel pl = new JPanel();
		pl.setBackground(new Color(10, 150, 235));
		pl.setBounds(0,0,450,70);
		pl.setLayout(null);
		add(pl);
		
		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icon/left.png"));
		Image im2 = im1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel back = new JLabel(im3);
		back.setBounds(5,10,50,50);
		pl.add(back);
		
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon im4 = new ImageIcon(ClassLoader.getSystemResource("icon/verticaldots.png"));
		Image im5 = im4.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
		ImageIcon im6 = new ImageIcon(im5);
		JLabel chaticon = new JLabel(im6);
		chaticon.setBounds(350,10,50,50);
		pl.add(chaticon);
		
		JLabel title = new JLabel ("TECHNICIAN");
		title.setBounds(150,2,200,50);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
		pl.add(title);
		
		JLabel status = new JLabel ("Online");
		status.setBounds(175,25,200,50);
		status.setForeground(Color.WHITE);
		status.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
		pl.add(status);
		
		al = new JPanel();
		al.setBounds(10,77,395,425);
		add(al);
		
		text = new JTextField();
		text.setBounds(10,510,290,40);
		text.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
		add(text);
		
		JButton send = new JButton("Send");
		send.setBounds(315,510,90,40);
		send.setBackground(new Color(10, 150, 235));
		send.setForeground(Color.WHITE);
		send.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
		send.addActionListener(this);
		add(send);
		
		setSize(415,565);
		setLocation(200,50);
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String out = text.getText();
		
		JLabel output = new JLabel(out);
		
		JPanel pan2 = formatLabel(out);
		
		al.setLayout(new BorderLayout());
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(pan2, BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createVerticalStrut(15));
		
		al.add(vertical, BorderLayout.PAGE_START);
		
		text.setText("");
		
		repaint();
		invalidate();
		validate();
		
}
	
	public static JPanel formatLabel(String out) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout (panel, BoxLayout.Y_AXIS));
		
		JLabel output = new JLabel("<html><p style=\"width: 150px\">"+ out + "</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(10, 150, 235));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,15));
		
		panel.add(output);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		
		panel.add(time);
		
		return panel;
	}
	
	public static void main(String[] args) {
		new Livechat();
	}
	
	public interface ActionListener extends EventListener {
		public void actionPerformed(ActionEvent e);
	}
}
