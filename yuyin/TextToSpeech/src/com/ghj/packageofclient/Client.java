package com.ghj.packageofclient;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.loon.framework.jtts.Engine;
import org.loon.framework.jtts.JTTS;

public class Client extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JTTS jtts;

	private JButton jButton1;

	private JButton jButton2;

	private JComboBox jComboBox1;

	private JLabel jLabel1;

	private JLabel jLabel2;

	private JLabel jLabel3;

	private JLabel jLabel4;

	private JScrollPane jScrollPane1;

	private JSeparator jSeparator1;

	private JSlider jSlider1;

	private JSlider jSlider2;

	private JTextArea jTextArea1;

	public Client() {

		jtts = Engine.getTTS();

		jSlider1 = new JSlider();
		jSlider2 = new JSlider();
		jComboBox1 = new JComboBox();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jSeparator1 = new JSeparator();
		jButton1 = new JButton();
		jButton2 = new JButton();

		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jLabel4 = new JLabel();

		this.setLayout(null);

		jSlider1.setName("jSlider1");
		jSlider1.setMaximum(500);
		jSlider1.setValue(150);
		jSlider1.setMinimum(0);
		this.add(jSlider1);
		jSlider1.setBounds(94, 131, 316, 24);

		jSlider2.setName("jSlider2");
		jSlider2.setMaximum(200);
		jSlider2.setValue(100);
		jSlider2.setMinimum(0);
		this.add(jSlider2);
		jSlider2.setBounds(94, 170, 316, 24);

		String[] types = new String[12];
		for (int i = 0; i < types.length; i++) {
			if (i < 5) {
				types[i] = "zh+" + "m" + (i + 1);
			} else {
				types[i] = "zh+" + "f" + (i - 4);
			}
		}
		types[10] = "zh+whisper";
		types[11] = "zh+croak";

		jtts.setLanguage("zh");//设定当前语法规范

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(types));
		jComboBox1.setName("jComboBox1");
		this.add(jComboBox1);
		jComboBox1.setBounds(100, 210, 100, 23);
		jComboBox1.addActionListener(this);

		jLabel1.setText("朗读间隔:");
		jLabel1.setName("jLabel1");
		this.add(jLabel1);
		jLabel1.setBounds(20, 125, 66, 30);

		jLabel2.setText("朗读音量:");
		jLabel2.setName("jLabel2");
		this.add(jLabel2);
		jLabel2.setBounds(20, 165, 70, 30);

		jLabel3.setText("发音规则:");
		jLabel3.setName("jLabel3");
		this.add(jLabel3);
		jLabel3.setBounds(20, 216, 80, 15);

		jLabel4.setText("目标文本:");
		jLabel4.setName("jLabel4");
		this.add(jLabel4);
		jLabel4.setBounds(20, 10, 70, 20);

		jSeparator1.setName("jSeparator1");
		this.add(jSeparator1);
		jSeparator1.setBounds(10, 268, 398, 10);

		jButton1.setText("朗读文本");
		jButton1.setName("jButton2");
		this.add(jButton1);
		jButton1.setBounds(232, 284, 83, 25);
		jButton1.addActionListener(this);

		jButton2.setText("退出应用");
		jButton2.setName("jButton3");
		this.add(jButton2);
		jButton2.setBounds(325, 284, 83, 25);
		jButton2.addActionListener(this);

		jScrollPane1.setName("jScrollPane1");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setName("jTextArea1");
		jTextArea1.setText("Hello Java！Hello World！\n前所未有啊，中国踢韩国三比零啦！\n生意兴隆，财源广进，万事如意，虎年大吉！\n吃葡萄不吐葡萄皮，不吃葡萄倒吐葡萄皮。\n我是未婚男青年，别管我要压岁钱。");
		jScrollPane1.setViewportView(jTextArea1);

		this.add(jScrollPane1);
		jScrollPane1.setBounds(98, 10, 310, 106);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			if (source == jButton1) {

				System.out.println(jSlider1.getValue());
				System.out.println(jSlider2.getValue());

				jtts.setRate(jSlider1.getValue());//设定朗读速度
				jtts.setVolume(jSlider2.getValue());//设定音量参数

				jtts.speak(jTextArea1.getText().trim());//设定朗读文本，自动朗读指定的字符串信息
			}
			if (source == jButton2) {
				System.exit(0);
			}
		} else if (source instanceof JComboBox) {
			jtts.setLanguage(jComboBox1.getSelectedItem().toString().trim());//设定朗读语言
		}
	}

	public static void createGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
		JFrame frame = new JFrame("Java版TTS组件发音测试(eSpeak封装)");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Client());
		frame.pack();
		frame.setSize(new Dimension(420, 345));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}
}