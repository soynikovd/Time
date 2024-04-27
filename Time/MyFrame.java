package Time;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MyFrame extends JFrame {
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    JLabel dateLabel;
    JLabel dayLabel;
    String time;
    String day;
    String date;

    public MyFrame() {
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setSize(450, 300);
        this.setLocation(430, 200);
        this.setResizable(false);
        timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy", Locale.ENGLISH);
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Impact",Font.BOLD, 75));
        timeLabel.setForeground(new Color(0x4B9F71));
        timeLabel.setOpaque(true);
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Impact",Font.BOLD, 55));
        dayLabel.setForeground(new Color(0x499C6E));
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Impact",Font.BOLD, 45));
        dateLabel.setForeground(new Color(0x4B9F71));
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        setTime();
    }
    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayFormat.format((Calendar.getInstance().getTime()));
            dayLabel.setText(day);
            date = dateFormat.format((Calendar.getInstance().getTime()));
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
