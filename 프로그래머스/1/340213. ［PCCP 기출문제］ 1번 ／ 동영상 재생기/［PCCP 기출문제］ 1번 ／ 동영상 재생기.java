class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = toSeconds(video_len);
        int currentSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        
        if (currentSec >= opStartSec && currentSec <= opEndSec) {
            currentSec = opEndSec;
        }
        
        for (String comm : commands) {
            
            if (comm.equals("next")) {
                currentSec += 10;
            } else if (comm.equals("prev")) {
                currentSec -= 10;
            }
            
            currentSec = Math.max(0, currentSec);
            currentSec = Math.min(videoLenSec, currentSec);
            
            if (currentSec >= opStartSec && currentSec <= opEndSec) {
                currentSec = opEndSec;
            }
        }
        
        return toTimeString(currentSec);
    }
    
    private int toSeconds(String mmss) {
        String[] parts = mmss.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }
    
    private String toTimeString(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}