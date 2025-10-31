class Solution {
    private boolean check(long level, long limit, int[] diffs, int[] times) {
        long totalTime = 0L;
        int n = diffs.length;
        
        totalTime += times[0];
        
        for (int i = 1; i < n; i++) {
            long diff = diffs[i];
            long timeCur = times[i];
            long timePrev = times[i - 1];
            
            if (diff <= level) {
                totalTime += timeCur;
            } else {
                long k = diff - level;
                long wrongTime = (timeCur + timePrev) * k;
                totalTime += wrongTime + timeCur;
            }
            
            if (totalTime > limit) return false;
        }
        
        return totalTime <= limit;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        long start = 1L;
        long end = 100000L;
        
        int minLevel = (int) end;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            if (check(mid, limit, diffs, times)) {
                minLevel = (int) mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return minLevel;
    }
}