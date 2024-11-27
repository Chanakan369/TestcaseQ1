public class first {
    public static int waterM, ElectM;
    public static int resultBill;
    public static int currentWaterMeter, lastWaterMeter;
    public static int currentElectMeter, lastElectMeter;
    // คำนวณค่าน้ำ
    public static int calculateWaterBill() {
        if (currentWaterMeter >= lastWaterMeter) {
            waterM = (currentWaterMeter - lastWaterMeter) * 5;
        }
        return waterM;
    }
    // คำนวณค่าไฟ
    public static int calculateElectBill() {
        if (currentElectMeter >= lastElectMeter) {
            ElectM = (currentElectMeter - lastElectMeter) * 6;
        }
        return ElectM;
    }
    // คำนวณบิลทั้งหมดตามประเภทห้อง
    public static int calculateResultBill(String roomType) {
        if (roomType.equals("S")) {
            resultBill = 1500 + calculateElectBill() + calculateWaterBill();
        } else if (roomType.equals("D")) {
            resultBill = 2000 + calculateElectBill() + calculateWaterBill();
        }
        return resultBill;
    }
    public static void main(String[] args) {
        currentElectMeter = 50;
        lastElectMeter = 20;
        currentWaterMeter = 100;
        lastWaterMeter = 50;
        System.out.println("Your bill is: " + calculateResultBill("D"));
    }
}