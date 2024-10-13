package problems;

import java.util.Stack;

class Location{
    public int row;
    public int col;
    public int open;

    public Location(int row, int col, int open){
        this.row = row;
        this.col = col;
        this.open = open;
    }
}

class Solution1 {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;

        //if((m+n)%2 != 0) return false;

        Stack<Location> stack = new Stack();

        if(grid[0][0] == '(') stack.push(new Location(0, 0, 1));
        else return false;

        while(!stack.isEmpty()){
            Location track = stack.pop();
            int row = track.row;
            int col = track.col;
            int open = track.open;

            if(row==m && col==n && open==0) return true;

            if(row < m && col <n){
                //for bottom grid
                int openBottom = open;
                if(grid[row+1][col] == '('){
                    openBottom++;
                    stack.push(new Location(row+1, col, openBottom));
                }
                if(grid[row+1][col] == ')'){
                    openBottom--;
                    if(openBottom >= 0){
                        stack.push(new Location(row+1, col, openBottom));
                    }
                }

                //for right grid
                int openRight = open;
                if(grid[row][col+1] == '('){
                    openRight++;
                    stack.push(new Location(row, col+1, openRight));
                }
                if(grid[row][col+1] == ')'){
                    openRight--;
                    if(openRight >= 0){
                        stack.push(new Location(row, col+1, openRight));
                    }
                }
            }
        }

        return false;
    }
}



public class ParenthesesDFS {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] grid = {
                {'(', '(', '('},
                {')', '(', ')'},
                {'(', '(', ')'},
                {'(', '(', ')'}
        };

        boolean result = solution.hasValidPath(grid);
        System.out.println("Can form a valid path: " + result);
    }
}
