package practise2025.park;

public class ParkingEnter {

    private String enterId;
    private ParkingLot parkingLot;

    public ParkingEnter(String enterId, ParkingLot parkingLot) {
        this.enterId = enterId;
        this.parkingLot = parkingLot;
    }

    public void enter(String carId) {
        System.out.println("车辆: " + carId + "准备进入停车场");
        this.parkingLot.enter(carId);
        System.out.println("车辆: " + carId + "已经进入停车场");

    }
}
