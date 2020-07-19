public class GameOfLife {


    public static void main(String[] args)
    {
        int width=10;
        int height=10;

        int[][] grid={ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }
        };
        System.out.println("Original Generation");


        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
                if (grid[i][j] == 0) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" # ");
                }
            System.out.println();

        }
        System.out.println();
        nextGen(grid,height,width);

    }
    public static void nextGen(int[][] grid, int height,int width)
    {int[][] future = new int[height][width];


        for (int l = 1; l < height - 1; l++)
        {
            for (int m = 1; m < width - 1; m++)
            {

                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];


                aliveNeighbours -= grid[l][m];




                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;


                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;


                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;


                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i <height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(" + ");
                else
                    System.out.print(" # ");
            }
            System.out.println();
        }
    }

}
