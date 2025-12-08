package practise2025.park;

public class Test {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(5);

        ParkingEnter enter1 = new ParkingEnter("入口1", parkingLot);
        ParkingEnter enter2 = new ParkingEnter("入口2", parkingLot);
        ParkingExit exit1 = new ParkingExit("出口1", parkingLot);

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                enter1.enter("Car-" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                enter2.enter("Car-" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {

                parkingLot.getCarToSpaceMap().keySet().stream().findAny().ifPresent((carId) -> {

                    exit1.exit(carId);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }).start();


    }
}
