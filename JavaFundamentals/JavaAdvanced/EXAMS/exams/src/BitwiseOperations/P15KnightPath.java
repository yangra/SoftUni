package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15KnightPath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] board = new int[8];
        int[] coord = new int[2];
        board[coord[0]] ^= 1<<coord[1];
        while (true) {
            String[] jump = reader.readLine().split(" ");
            if ("stop".equals(jump[0])) {
                break;
            }
            makeMove(board, jump, coord);
        }

        boolean isEmpty= true;
        for (int i = 0; i < board.length; i++) {
            if(board[i]!=0){
                System.out.println(board[i]);
                isEmpty = false;
            }
        }

        if(isEmpty){
            System.out.println("[Board is empty]");
        }
    }

    private static void makeMove(int[] board, String[] jump, int[] coord) {
        switch (jump[0]) {
            case "left":
                coord[1]+=2;
                if ( coord[1] >= board.length) {
                    coord[1]-=2;
                    return;
                }
                if("down".equals(jump[1])){
                    coord[0]++;
                    if(coord[0]>=board.length){
                        coord[0]--;
                        coord[1]-=2;
                        return;
                    }
                }else{
                    coord[0]--;
                    if(coord[0]<0){
                        coord[0]++;
                        coord[1]-=2;
                        return;
                    }
                }
                board[coord[0]] ^= 1<<coord[1];

                break;
            case "right":
                coord[1]-=2;
                if ( coord[1] < 0) {
                    coord[1]+=2;
                    return;
                }
                if("down".equals(jump[1])){
                    coord[0]++;
                    if(coord[0]>=board.length){
                        coord[0]--;
                        coord[1]+=2;
                        return;
                    }
                }else{
                    coord[0]--;
                    if(coord[0]<0){
                        coord[0]++;
                        coord[1]+=2;
                        return;
                    }
                }
                board[coord[0]] ^= 1<<coord[1];
                break;
            case "up":
                coord[0]-=2;
                if ( coord[0] < 0) {
                    coord[0]+=2;
                    return;
                }
                if("left".equals(jump[1])){
                    coord[1]++;
                    if(coord[1]>=board.length){
                        coord[1]--;
                        coord[0]+=2;
                        return;
                    }
                }else{
                    coord[1]--;
                    if(coord[1]<0){
                        coord[1]++;
                        coord[0]+=2;
                        return;
                    }
                }
                board[coord[0]] ^= 1<<coord[1];
                break;
            case "down":
                coord[0]+=2;
                if ( coord[0] >= board.length) {
                    coord[0]-=2;
                    return;
                }
                if("left".equals(jump[1])){
                    coord[1]++;
                    if(coord[1]>=board.length){
                        coord[1]--;
                        coord[0]-=2;
                        return;
                    }
                }else{
                    coord[1]--;
                    if(coord[1]<0){
                        coord[1]++;
                        coord[0]-=2;
                        return;
                    }
                }
                board[coord[0]] ^= 1<<coord[1];
                break;
        }
    }
}

