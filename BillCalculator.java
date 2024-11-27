import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class BillCalculator {

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {

        // สร้างหน้าต่างหลัก

        JFrame frame = new JFrame("Electricity & Water Bill Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(450, 300);

        frame.setLayout(new GridLayout(7, 2, 10, 10)); // เพิ่มช่องว่างระหว่างองค์ประกอบ

        // ส่วนประกอบในหน้าต่าง

        JLabel currentElectricLabel = new JLabel("Current Electric Meter:");

        JTextField currentElectricField = new JTextField();

        JLabel lastElectricLabel = new JLabel("Last Electric Meter:");

        JTextField lastElectricField = new JTextField();

        JLabel currentWaterLabel = new JLabel("Current Water Meter:");

        JTextField currentWaterField = new JTextField();

        JLabel lastWaterLabel = new JLabel("Last Water Meter:");

        JTextField lastWaterField = new JTextField();

        JLabel roomTypeLabel = new JLabel("Room Type:");

        String[] roomTypes = {"Single Bed", "Double Bed"};

        JComboBox<String> roomTypeCombo = new JComboBox<>(roomTypes);

        JButton calculateButton = new JButton("Calculate");

        JButton resetButton = new JButton("Reset");

        JProgressBar progressBar = new JProgressBar(0, 100);

        progressBar.setValue(0);

        progressBar.setStringPainted(true);

        JLabel resultLabel = new JLabel("Your bill is: ");

        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // จัดข้อความให้อยู่กลาง

        // เพิ่มส่วนประกอบลงในหน้าต่าง

        frame.add(currentElectricLabel);

        frame.add(currentElectricField);

        frame.add(lastElectricLabel);

        frame.add(lastElectricField);

        frame.add(currentWaterLabel);

        frame.add(currentWaterField);

        frame.add(lastWaterLabel);

        frame.add(lastWaterField);

        frame.add(roomTypeLabel);

        frame.add(roomTypeCombo);

        frame.add(calculateButton);

        frame.add(resetButton);

        frame.add(progressBar);

        frame.add(resultLabel);

        // กำหนด Action เมื่อกดปุ่ม Calculate

        calculateButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    int currentElectric = Integer.parseInt(currentElectricField.getText());

                    int lastElectric = Integer.parseInt(lastElectricField.getText());

                    int currentWater = Integer.parseInt(currentWaterField.getText());

                    int lastWater = Integer.parseInt(lastWaterField.getText());

                    if (currentElectric < lastElectric || currentWater < lastWater) {

                        JOptionPane.showMessageDialog(frame,

                                "Current Meter values must be greater than Last Meter values!",

                                "Error", JOptionPane.ERROR_MESSAGE);

                        return;

                    }

                    int electricBill = (currentElectric - lastElectric) * 6;

                    int waterBill = (currentWater - lastWater) * 5;

                    String roomType = (String) roomTypeCombo.getSelectedItem();

                    int basePrice = roomType.equals("Single Bed") ? 1500 : 2000;

                    int totalBill = basePrice + electricBill + waterBill;

                    progressBar.setValue(100); // ตั้งค่า ProgressBar

                    resultLabel.setText("Your bill is: " + totalBill + " THB"); // แสดงผลบิลรวม

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame,

                            "Please enter valid numeric values!",

                            "Input Error", JOptionPane.ERROR_MESSAGE);

                }

            }

        });

        // กำหนด Action เมื่อกดปุ่ม Reset

        resetButton.addActionListener((var e) -> {
            currentElectricField.setText("");
            
            lastElectricField.setText("");
            
            currentWaterField.setText("");
            
            lastWaterField.setText("");
            
            roomTypeCombo.setSelectedIndex(0);
            
            progressBar.setValue(0);
            
            resultLabel.setText("Your bill is: ");
        });

        // แสดงหน้าต่าง

        frame.setVisible(true);

    }

}


