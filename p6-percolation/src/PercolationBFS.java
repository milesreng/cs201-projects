import java.util.*;

public class PercolationBFS extends PercolationDFSFast {

    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    protected void search(int row, int col) {
        if (isFull(row, col) || !inBounds(row, col)) {
            return;
        }

        Queue<int[]> bq = new LinkedList<>();
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        myGrid[row][col] = FULL;
        bq.add(new int[]{row, col});

        while (bq.size() != 0) {
            int[] blob = bq.remove();
            for (int i = 0; i < rows.length; i++) {
                row = blob[0] + rows[i];
                col = blob[1] + cols[i];
                if (inBounds(row, col) && !isFull(row, col) && isOpen(row, col)) {
                    myGrid[row][col] = FULL;
                    bq.add(new int[]{row, col});
                }
            }
        }
    }
}
