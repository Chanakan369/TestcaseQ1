import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillCalculator extends JFrame {
    private JTextField displayField;
    private StringBuilder input;

    public BillCalculator() {
        // ตั้งค่า JFrame
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        input = new StringBuilder();

        // สร้าง TextField สำหรับแสดงผลลัพธ์
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 30));
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // สร้างแผงปุ่ม
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // ปุ่มตัวเลขและปุ่มการคำนวณ
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // เพิ่มปุ่มลงในแผง
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        // เพิ่มแผงปุ่มลงใน JFrame
        add(buttonPanel, BorderLayout.CENTER);
    }

    // ฟังก์ชันสำหรับการจัดการปุ่มที่ถูกคลิก
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                try {
                    // คำนวณผลลัพธ์
                    String result = calculate(input.toString());
                    displayField.setText(result);
                    input.setLength(0);  // เคลียร์ input หลังจากคำนวณ
                    input.append(result);  // เก็บผลลัพธ์
                } catch (Exception ex) {
                    displayField.setText("Error");
                }
            } else if (command.equals("C")) {
                input.setLength(0); // เคลียร์ข้อมูลทั้งหมด
                displayField.setText("");
            } else {
                input.append(command);  // เพิ่มปุ่มที่กดลงใน input
                displayField.setText(input.toString());
            }
        }
    }

    // ฟังก์ชันคำนวณการคำนวณ (ใช้ eval)
    private String calculate(String expression) {
        // ใช้การคำนวณจาก eval หรือใช้ ScriptEngine สำหรับคำนวณ
        try {
            javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
            return String.valueOf(engine.eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}

