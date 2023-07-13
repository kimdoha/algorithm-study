import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public class Job implements Comparable<Job> {
    int request;
    int work;

    public Job(int request, int work) {
      this.request = request;
      this.work = work;
    }
    public String toString() {
      return "request : " + this.request + " and work : " + this.work;
    }
    @Override
    public int compareTo(Job o) {
      if(work != o.work) return work - o.work;
      return request - o.request;
    }
  }

  public int solution(int[][] jobs) {
    int answer = 0;

    PriorityQueue<Job> heap = new PriorityQueue<>();
    List<Job> list = new ArrayList<>();
    
    for(int[] job : jobs) {
      heap.add(new Job(job[0], job[1]));
    }
    for(int i = 0; i < jobs.length; i++) {
      list.add(heap.poll());
    }

    int current_time = 0;
    while(list.size() > 0) {
      for(int i = 0; i < list.size(); i++) {
        Job job = list.get(i);
        if(job.request <= current_time) {
          answer += current_time + job.work - job.request;
          current_time += job.work;
          list.remove(i);
          break;
        }
        if(i == list.size() - 1) current_time++;
      }
    }

    return (int) Math.floor(answer / jobs.length);
  }
}