import java.awt.Font;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyStopwatch implements Action{

	JFrame frame = new JFrame();
	JButton startButton = new JButton("Start");
	JButton resetButton = new JButton("Reset");
	JButton stopButtom = new JButton("Stop");
	JLabel timeLabel = new JLabel();
	int time=0;
	int seconds=0;
	int minutes=0;
	int hours=0;
	boolean started=false;
	String seconds_String = String.format("%02d", seconds);
	String minutes_String = String.format("%02d", minutes);
	String hours_String = String.format("%02d", hours);
	
	Timer timer = new Timer(1000,new Action() {

		@Override
		public void actionPerformed(ActionEvent e) {

			time=time+1000;
			hours=(time/3600000);
			minutes=(time/60000)%60;
			seconds=(time/1000)%60;

			seconds_String = String.format("%02d", seconds);
			minutes_String = String.format("%02d", minutes);
			hours_String = String.format("%02d", hours);
			timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
			
		}

		@Override
		public Object getValue(String key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void putValue(String key, Object value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setEnabled(boolean b) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removePropertyChangeListener(PropertyChangeListener listener) {
			// TODO Auto-generated method stub
			
		}
		
	});
	
	MyStopwatch(){
		
		timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setOpaque(true);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(420,420);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==startButton) {
			if(started==false) {
				started=true;
				startButton.setText("Stop");
				start();
			}else{
				started=false;
				startButton.setText("Start");
				stop();
				
			}
		}
		
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("Start");
			reset();

		}
		
	}


	private void start() {
		timer.start();
	}

	private void stop() {
		timer.stop();
	}
	
	private void reset() {

		timer.stop();
		time=0;
		seconds=0;
		minutes=0;
		hours=0;
		
		seconds_String = String.format("%02d", seconds);
		minutes_String = String.format("%02d", minutes);
		hours_String = String.format("%02d", hours);
		timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
