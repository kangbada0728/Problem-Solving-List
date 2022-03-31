import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집1766 {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> outdegree = new ArrayList<>();
        for(int i = 0; i <= N; ++i) {
            outdegree.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];

        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            outdegree.get(A).add(B);
            indegree[B] += 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; ++i) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

        int[] answer = new int[N];
        int idx = 0;
        while (!pq.isEmpty()) {
            int currentNum = pq.poll();

            answer[idx++] = currentNum;

            int len = outdegree.get(currentNum).size();
            for(int i = 0; i < len; ++i) {
                int B = outdegree.get(currentNum).get(i);
                indegree[B] -= 1;
                if (indegree[B] == 0) {
                    pq.add(B);
                }
            }
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
