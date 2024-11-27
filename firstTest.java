import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FirstTest {

    @Test
    public void testCalculateWaterBill() {
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        int expectedWaterBill = (100 - 50) * 5;
        int actualWaterBill = first.calculateWaterBill();
        assertEquals("Water bill calculation failed", expectedWaterBill, actualWaterBill);
    }

    @Test
    public void testCalculateElectBill() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        int expectedElectBill = (50 - 20) * 6;
        int actualElectBill = first.calculateElectBill();
        assertEquals("Electricity bill calculation failed", expectedElectBill, actualElectBill);
    }

    @Test
    public void testCalculateResultBillSingleRoom() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        String roomType = "S";
        int expectedResult = 1500 + (50 - 20) * 6 + (100 - 50) * 5;
        int actualResult = first.calculateResultBill(roomType);
        assertEquals("Single room bill calculation failed", expectedResult, actualResult);
    }

    @Test
    public void testCalculateResultBillDoubleRoom() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        String roomType = "D";
        int expectedResult = 2000 + (50 - 20) * 6 + (100 - 50) * 5;
        int actualResult = first.calculateResultBill(roomType);
        assertEquals("Double room bill calculation failed", expectedResult, actualResult);
    }

    @Test
    public void testInvalidMeterReadings() {
        first.currentElectMeter = 10;  // Invalid case, current meter is less than the last meter
        first.lastElectMeter = 20;
        first.currentWaterMeter = 30;
        first.lastWaterMeter = 50;
        String roomType = "S";
        int expectedResult = 1500;  // Assuming the program handles this gracefully and just returns the base price
        int actualResult = first.calculateResultBill(roomType);
        assertEquals("Invalid meter readings should be handled gracefully", expectedResult, actualResult);
    }
}
