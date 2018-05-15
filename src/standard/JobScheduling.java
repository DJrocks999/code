package standard;


// K -> number of processor
// T -> number of job
// a[T] -> time taken by each job
// processor can get assigned consecutive jobs only
// Find min time to finish all the jobs.
public class JobScheduling {

    static boolean canFinishInTime(int[] a, int totalTime, int k) {
        int proc = 0;
        int sum = 0;
        for (int i = 0; i < a.length; ) {

            if (sum + a[i] <= totalTime) {
                sum = sum + a[i];
                i++;
            } else {
                sum = 0;
                proc++;
            }
            if (proc > k) {
                return false;
            }
        }
        return true;
    }

    static int minTimeToFinish(int[] a, int k) {

        // if T <= K
        if (a.length <= k) {
            int ans = 0;
            for (int b : a) {
                ans = Math.max(b, ans);
            }
            return ans;
        }

        // if T > K
        int totalTime = 0;
        for (int anA : a) {
            totalTime += anA;
        }
        int start = totalTime / k; // min time to finish all the jobs
        int end = totalTime;

        int ans = 0;
        // BSearch for all the possible values
        while (start <= end) {
            int mid = (start + end) / 2;
            if (canFinishInTime(a, mid, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            ans = mid;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToFinish(new int[]{5, 6, 10, 2, 7, 4, 13}, 4));
    }
}
