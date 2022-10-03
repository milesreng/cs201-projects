public class PercolationDFSFast extends PercolationDFS {

    public PercolationDFSFast(int n) {
        super(n);
    }
    
    @Override
    protected void updateOnOpen(int row, int col) {
        if (row == 0) {
            search(row, col);
        } else if (inBounds(row - 1, col) && isFull(row - 1, col)) {
            search(row, col);
        } else if (inBounds(row + 1, col) && isFull(row + 1, col)) {
            search(row, col);
        } else if (inBounds(row, col - 1) && isFull(row, col - 1)) {
            search(row, col);
        } else if (inBounds(row, col + 1) && isFull(row, col + 1)) {
            search(row, col);
        }
    }
}
