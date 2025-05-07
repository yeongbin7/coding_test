import java.util.*;

public class Cache {

    public int solution(int cacheSize, String[] cities) {
        int executionTime = 0;
        LinkedList<String> queue = new LinkedList<>();

        if (cacheSize == 0) return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (queue.isEmpty()) {
                queue.offer(city);
                executionTime += 5;
                continue;
            }

            boolean isExisted = queue.contains(city);
            if (isExisted) {
                for (int j = 0; j < queue.size(); j++) {
                    queue.remove(city);
                    queue.offer(city);
                    break;
                }
            }
            if (isExisted) {
                executionTime += 1;
                continue;
            }
            if (queue.size() < cacheSize) {
                queue.offer(city);
            } else {
                queue.poll();
                queue.offer(city);
            }
            executionTime += 5;

        }

        return executionTime;
    }
}