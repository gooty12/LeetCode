public class Search2DMatrix74 {
    public static void main(String[] args) {

        Search2DMatrix74 obj = new Search2DMatrix74();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            if (n > 0) {
                int st = 0, end = m-1;
                int rw = -1;
                while (st <= end) {
                    int mid = st + (end-st)/2;
                    int v1 = matrix[mid][0];
                    int v2 = matrix[mid][n-1];
                    if (target < v1) {
                        end = mid-1;
                    }
                    else if (target > v2) {
                        st = mid+1;
                    }
                    else {
                        rw = mid;
                        break;
                    }
                }

                st = 0; end = n-1;
                if (rw != -1) {
                    while (st <= end) {
                        int mid = st + (end-st)/2;
                        int v = matrix[rw][mid];
                        if (v==target) {
                            res = true;
                            break;
                        }
                        else if (target < v) {
                            end = mid-1;
                        }
                        else {
                            st = mid+1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
