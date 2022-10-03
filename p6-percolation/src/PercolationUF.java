public class PercolationUF implements IPercolate {

    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size) {
        myGrid = new boolean[size][size];
        myOpenCount = 0;
        finder.initialize(size * size + 2);
        myFinder = finder;
        VTOP = size * size;
        VBOTTOM = size * size + 1;
    }

    @Override
    public void open(int row, int col) {
        if (!inBounds(row, col)) {
            throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
        }
        
        if (isOpen(row, col)) {
            return;
        }
        
        myGrid[row][col] = true;
        myOpenCount++;
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        int cell = row * myGrid.length + col;

        if (row == 0) {
            myFinder.union(cell, VTOP);
        }
        
        if (row == myGrid.length - 1) {
            myFinder.union(cell, VBOTTOM);
        }

        int newRow;
        int newCol;
        int newCell;

        for (int i = 0; i < rows.length; i++) {
            newRow = row + rows[i];
            newCol = col + cols[i];
            newCell = newRow * myGrid.length + newCol;

            if (inBounds(newRow, newCol) && isOpen(newRow, newCol)) {
                myFinder.union(cell, newCell);
            }
        }
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (!inBounds(row, col)) {
            throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (!inBounds(row, col)) {
            throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
        }
        int cell = row * myGrid.length + col;
        return myFinder.connected(cell, VTOP);
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VBOTTOM, VTOP);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    private boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }

}