package practise2025.park;

public class ParkingExit {

    private String exitId;
    private ParkingLot parkingLot;

    public ParkingExit(String exitId, ParkingLot parkingLot) {
        this.exitId = exitId;
        this.parkingLot = parkingLot;
    }

    public void exit(String carId) {
        System.out.println("车辆: " + carId + "准备离开停车场");
        this.parkingLot.exit(carId);
        System.out.println("车辆: " + carId + "已经离开停车场");

    }

}
