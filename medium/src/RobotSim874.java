import java.util.HashSet;
import java.util.Set;

public class RobotSim874 {
    public static void main(String[] args) {

        RobotSim874 obj = new RobotSim874();
        System.out.println(obj.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i]);
        }

        int x = 0, y = 0;
        int res = 0;
        int dir = 0;
        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];
            if (cmd == -2) {
                dir = dir==0 ? dirs.length-1 : dir-1;
            }
            else if (cmd == -1) {
                dir = (dir+1) % dirs.length;
            }
            else {
                for (int d = 1; d <= cmd; d++) {
                    int x1 = x + dirs[dir][0];
                    int y1 = y + dirs[dir][1];
                    if (set.contains(new int[]{x1, y1})) {
                        break;
                    }
                    else {
                        x = x1;
                        y = y1;
                        res = Math.max(res, x1*x1 + y1*y1);
                    }
                }
            }
        }
        return res;
    }
}





