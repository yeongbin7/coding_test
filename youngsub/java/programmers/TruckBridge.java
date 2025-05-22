import java.util.*;

public class TruckBridge {

    static class Truck {
        int index, weight;

        public Truck(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Truck> trucks = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(new Truck(i, truck_weights[i]));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int answer = 0;
        int currentWeight = 0; // 현재 다리 위 무게를 별도로 관리

        while (!trucks.isEmpty() || currentWeight > 0) {
            answer++;

            // 다리에서 나가는 트럭의 무게 제거
            int exitWeight = bridge.poll();
            currentWeight -= exitWeight;

            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (!trucks.isEmpty() && currentWeight + trucks.peek().weight <= weight) {
                Truck nextTruck = trucks.poll();
                bridge.offer(nextTruck.weight);
                currentWeight += nextTruck.weight;
            } else {
                bridge.offer(0); // 빈 공간
            }
        }

        return answer;
    }
}