package practise2025.park;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingLot {

    private BlockingQueue<String> availableSpaces;

    public Map<String, String> getCarToSpaceMap() {
        return carToSpaceMap;
    }

    private Map<String, String> carToSpaceMap;


    public ParkingLot(int capacity) {
        availableSpaces = new LinkedBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            availableSpaces.offer("No. " + i);
        }
        carToSpaceMap = new ConcurrentHashMap<>();
    }

    public String enter(String carId) {
        try {
            String spaceId = availableSpaces.take();
            carToSpaceMap.put(carId, spaceId);
            return spaceId;
        } catch (InterruptedException e) {
            return null;
        }
    }


    public String exit(String carId) {
        String spaceId = carToSpaceMap.get(carId);
        carToSpaceMap.remove(carId);
        try {
            availableSpaces.put(spaceId);
        } catch (InterruptedException e) {
            return null;
        }
        return spaceId;
    }
}
