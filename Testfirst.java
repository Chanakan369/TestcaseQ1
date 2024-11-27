import static org.junit.Assert.*;
import org.junit.Test;

public class Testfirst {
    
    // ทดสอบคำนวณค่าน้ำ
    @Test
    public void testCalculateWaterBill() {
        First.currentWaterMeter = 100;
        First.lastWaterMeter = 50;
        assertEquals(first.calculateWaterBill(), 250);  // ค่าน้ำ (50 * 5 = 250)
    }
    
    // ทดสอบคำนวณค่าไฟ
    @Test
    public void testCalculateElectBill() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        assertEquals(first.calculateElectBill(), 180);  // ค่าไฟ (30 * 6 = 180)
    }

    // ทดสอบคำนวณบิลรวม (ห้องคู่)
    @Test
    public void testCalculateResultBillDouble() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        assertEquals(first.calculateResultBill("D"), 2670);  // คำนวณค่าบิลทั้งหมด (2000 + 180 + 250 = 2670)
    }

    // ทดสอบคำนวณบิลรวม (ห้องเดี่ยว)
    @Test
    public void testCalculateResultBillSingle() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        assertEquals(first.calculateResultBill("S"), 2170);  // คำนวณค่าบิลทั้งหมด (1500 + 180 + 250 = 2170)
    }
}
