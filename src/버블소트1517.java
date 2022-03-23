import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트1517 {

    private static int[] origin;
    private static int[] temp;
    private static long inversionCnt = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        origin = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()) {
            origin[i] = Integer.parseInt(st.nextToken());
            i += 1;
        }

        divide(0, N - 1);

        System.out.println(inversionCnt);
    }

    private static void divide(int left, int right) {
        if(left == right) {
            return;
        }
        int mid = left + (right - left)/2;
        divide(left, mid);
        divide(mid + 1, right);
        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;

        int tempIdx = left;
        while(s1 <= e1 && s2 <= e2) {
            if(origin[s1] > origin[s2]) {
                temp[tempIdx++] = origin[s2++];
                inversionCnt += e1 - s1 + 1;
            } else {
                temp[tempIdx++] = origin[s1++];
            }
        }

        while(s1 <= e1) {
            temp[tempIdx++] = origin[s1++];
        }
        while(s2 <= e2) {
            temp[tempIdx++] = origin[s2++];
        }

        for(int i = left; i <= right; ++i) {
            origin[i] = temp[i];
        }
    }

}
