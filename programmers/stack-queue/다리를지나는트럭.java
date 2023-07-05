import java.util.Queue;
import java.util.LinkedList;

class Solution {
   
  class Truck {
    int weight;
    int time;

    public Truck(int weight, int time) {
      this.weight = weight;
      this.time = time;
    }
  }

  int solution(int bridge_length, int weight, int[] truck_weights) {

    Queue<Truck> queue = new LinkedList<>();
    
    int current_weight = 0;
    int index = 0;
    int time = 0;

    while (index < truck_weights.length) {
      time++;

      if(!queue.isEmpty() && time - queue.peek().time == bridge_length) {
        Truck truck = queue.poll();
        current_weight -= truck.weight;
      }

      if(current_weight + truck_weights[index] > weight)
        continue;

      current_weight += truck_weights[index];
      queue.add(new Truck(truck_weights[index], time));
      index++;
    }

    return time + bridge_length;
  }
}