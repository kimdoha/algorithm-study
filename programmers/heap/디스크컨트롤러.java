import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
 public class Job implements Comparable<Job> {
    int request;
    int time;

    public Job(int request, int time) {
      this.request = request;
      this.time = time;
    }

    @Override
    public String toString() {
      return "request : " + this.request + ", time : " + time;
    }

    @Override
    public int compareTo(Job o) {
      if(time != o.time) return time - o.time;
      return request - o.request;
    }
  }

  public int solution(int[][] jobs) {
    int answer = 0;

    PriorityQueue<Job> heap = new PriorityQueue<>();
    for(int[] job : jobs) {
      heap.add(new Job(job[0], job[1]));
    }

    ArrayList<Job> priority_lists = new ArrayList<>();
    while(heap.size() > 0) {
      priority_lists.add(heap.poll());
    }

    int current_time = 0;
    while(priority_lists.size() > 0) {
      for(int i = 0; i < priority_lists.size(); i++) {
        Job job = priority_lists.get(i);

        if(job.request <= current_time){
          answer += current_time + job.time - job.request;
          current_time += job.time;
          priority_lists.remove(i);
          break;
        }

        if(i == priority_lists.size() - 1) current_time++;
      }
    }

    return answer / jobs.length;
  }
}