package classes;

import java.util.Random;

public class gameArea {

    gameArea(int size){
        area = new int[size][size];
        this.reset();
    }

    int[][] area;
    int size = 4;
    public void reset(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                area[i][j]=0;
            }
        }
        int l1 = (int)(Math.random() * size);
        int l2 = (int)(Math.random() * size);
        int h1 = (int)(Math.random() * size);
        int h2 = (int)(Math.random() * size);
        area[l1][h1] = 2;
        area[l2][h2] = 2;
    }

    public void moveLeft(){
        boolean moved = false;
        for (int i=0;i<size;i++){
            boolean staticIter = false;
            while(!staticIter) {
                staticIter = true;
                for (int j = 0; j < size; j++) {
                    System.out.println("cell " + Integer.toString(i) + " " + Integer.toString(j));
                    if (area[i][j]==0){
                        System.out.println("Don't move "+staticIter);
                        continue;
                    }
                    int curPos = j;
                    while (true) {
                        if (curPos == 0){
                            System.out.println("Stopped on edge "+staticIter);
                            break;
                        }
                        if ((area[i][curPos - 1] != area[i][curPos]) && (area[i][curPos - 1] != 0)) {
                            System.out.println("Stopped on stopper "+staticIter);
                            break;
                        }
                        if (area[i][curPos - 1] == 0) {
                            System.out.println("moved "+staticIter);
                            area[i][curPos - 1] = area[i][curPos];
                            area[i][curPos] = 0;
                            curPos--;
                            moved = true;
                            staticIter = false;
                        } else {
                            System.out.println("merged "+staticIter);
                            area[i][curPos - 1] *= 2;
                            area[i][curPos] = 0;
                            curPos--;
                            moved = true;
                            staticIter = false;
                        }
                    }

                }
            }
        }
        if(moved){
            this.add();
        }
    }

    public void moveRight(){
        boolean moved = false;
        for (int i=0;i<size;i++){
            boolean staticIter = false;
            while(!staticIter) {
                staticIter = true;
                for (int j = size - 1; j != -1; j--) {
                    System.out.println("cell " + Integer.toString(i) + " " + Integer.toString(j));
                    if (area[i][j]==0){
                        System.out.println("Don't move "+staticIter);
                        continue;
                    }
                    int curPos = j;
                    while (true) {
                        if (curPos == size - 1) {
                            System.out.println("Stopped on edge "+staticIter);
                            break;
                        }
                        if ((area[i][curPos + 1] != area[i][curPos]) && (area[i][curPos + 1] != 0)) {
                            System.out.println("Stopped on stopper "+staticIter);
                            break;
                        }
                        if (area[i][curPos + 1] == 0) {
                            System.out.println("moved "+staticIter);
                            area[i][curPos + 1] = area[i][curPos];
                            area[i][curPos] = 0;
                            curPos++;
                            moved = true;
                            staticIter = false;
                        } else {
                            System.out.println("merged "+staticIter);
                            area[i][curPos + 1] *= 2;
                            area[i][curPos] = 0;
                            curPos++;
                            moved = true;
                            staticIter = false;
                        }
                    }
                }
            }
        }
        if(moved){
            this.add();
        }
    }

    public void moveUp(){
        boolean moved = false;
        for (int j=0;j<size;j++){
            boolean staticIter = false;
            while(!staticIter) {
                staticIter = true;
                for (int i = 0; i < size; i++) {
                    System.out.println("cell " + Integer.toString(i) + " " + Integer.toString(j));
                    if (area[i][j]==0){
                        System.out.println("Don't move "+staticIter);
                        continue;
                    }
                    int curPos = i;
                    while (true) {
                        if (curPos == 0) {
                            System.out.println("Stopped on edge "+staticIter);
                            break;
                        }
                        if ((area[curPos - 1][j] != area[curPos][j]) && (area[curPos - 1][j] != 0)) {
                            System.out.println("Stopped on stopper "+staticIter);
                            break;
                        }
                        if (area[curPos - 1][j] == 0) {
                            System.out.println("moved "+staticIter);
                            area[curPos - 1][j] = area[curPos][j];
                            area[curPos][j] = 0;
                            curPos--;
                            moved = true;
                            staticIter = false;
                        } else {
                            System.out.println("merged "+staticIter);
                            area[curPos - 1][j] *= 2;
                            area[curPos][j] = 0;
                            curPos--;
                            moved = true;
                            staticIter = false;
                        }
                    }
                }
            }
        }
        if(moved){
            this.add();
        }
    }

    public void moveDown(){
        boolean moved = false;
        for (int j=0;j<size;j++){
            boolean staticIter = false;
            while(!staticIter) {
                staticIter = true;

                for (int i = size - 1; i != -1; i--) {
                    System.out.println("cell " + Integer.toString(i) + " " + Integer.toString(j));
                    if (area[i][j]==0){
                        System.out.println("Don't move "+staticIter);
                        continue;
                    }
                    int curPos = i;
                    while (true) {
                        if (curPos == size - 1) {
                            System.out.println("Stopped on edge "+staticIter);
                            break;
                        }
                        if ((area[curPos + 1][j] != area[curPos][j]) && (area[curPos + 1][j] != 0)) {
                            System.out.println("Stopped on stopper "+staticIter);
                            break;
                        }
                        if (area[curPos + 1][j] == 0) {
                            System.out.println("moved "+staticIter);
                            area[curPos + 1][j] = area[curPos][j];
                            area[curPos][j] = 0;
                            curPos++;
                            moved = true;
                            staticIter = false;
                        }
                        else {
                            System.out.println("merged "+staticIter);
                            area[curPos + 1][j] *= 2;
                            area[curPos][j] = 0;
                            curPos++;
                            moved = true;
                            staticIter = false;
                        }
                    }
                }
            }
        }

        if(moved){
            this.add();
        }
    }

    public void add(){
        System.out.println("\nAdded\n");
        while (true){
            int l = (int)(Math.random() * size);
            int h = (int)(Math.random() * size);
            if(area[l][h]==0){
                area[l][h]=2;
                break;
            }
        }
        return;
    }
    public void set(int l, int h, int value){
        area[l][h] = value;
    }

    public int get(int l, int h){
        return area[l][h];
    }
    public void areaPrint(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(area[i][j]+" ");
            }
            System.out.print('\n');
        }
        System.out.println();
    }
}
