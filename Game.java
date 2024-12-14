//import scanner and inputmismatchexception
import java.util.Scanner;
import java.util.InputMismatchException;
public class Game{
  //create 2d array
  public static String[][]board = new String [7][15];
  //set a various varables
  int count = 0;
  final String ColorReset = "\u001B[0m";
  final String RedR = "\u001B[31m";
  final String YellowY = "\u001B[33m";
  public void CreateBoard(){
    for (int x = 0;x<board.length;x++){
      for (int y=0;y<board[x].length;y++){
        if (y%2==0){
          //the even y values print out |
          board[x][y] = "|";
        }else{
          //the odd y values print out " "
          board[x][y] = " ";
        }
      }
    }
  }
  public void printBoard(){
    for(int x = 0;x<board.length;x++){
      for (int y=0;y<board[x].length;y++){
        //print out each coordinate to create board
        System.out.print(board[x][y]);
      }
      System.out.println();
    } 
  }
  public void p1turn(){
    int number = 0;
    //set a while statement
    while (true){
      System.out.print("\nPlayer 1: Drop disk in column(1-7): ");
      try{
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();
        //if the number is less than 0 and more than 7
        if ((number>7||number<=0)){
          System.out.println("Only enter numbers from (1-7)");
        }else if (number==1){//Set up if statements where each number corresponds to a different column. We do this because the first column is actually 0
          number = 0;
          break;
        }else if (number==2){
          number = 1;
          break;
        }else if (number==3){
          number = 2;
          break;
        }else if (number==4){
          number = 3;
          break;
        }else if (number==5){
          number = 4;
          break;
        }else if (number==6){
          number = 5;
          break;
        }else if (number==7){
          number = 6;
          break;
        }else{
          break;
        }
      }
      catch(InputMismatchException e){
        System.out.println("Only numbers allowed");
        //Catch all letters
      }
    }
    int coinslot = 2*number+1;
    for (int x=6;x>=0;x--){
      if (board[x][coinslot] == " "){
        //If the spot is free then we will make the R Red
        board[x][coinslot] = RedR+"R"+ColorReset;
        count++;
        break; 
      }
    }
  }public void p2turn(){//same comments apply to p2turn
    int number;
    while(true){
      try{
        System.out.print("\nPlayer 2: Drop disk in column(1-7): ");
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();
        if (number>7){
          System.out.println("Only enter numbers from (1-7)");
        }else if (number==1){
          number = 0;
          break;
        }else if (number==2){
          number = 1;
          break;
        }else if (number==3){
          number = 2;
          break;
        }else if (number==4){
          number = 3;
          break;
        }else if (number==5){
          number = 4;
          break;
        }else if (number==6){
          number = 5;
          break;
        }else if (number==7){
          number = 6;
          break;
        }else{
          break;
        }
      }catch(InputMismatchException e){
        System.out.println("Only numbers allowed");
      }
    }while(number>6);
    int coinslot = 2*number+1;
    for (int x=6;x>=0;x--){
      if (board[x][coinslot]== " "){
        board[x][coinslot] = YellowY+"Y"+ColorReset;
        count++;
        break; 
      }
    }
  }public int counter(){
    return count;//return count
  }public Boolean winconditons(){//find if anyone wins
    for (int x=0;x<7;x++){//Vertical Line
      for (int y=0;y<8;y+=2){
        //if 4 spots vertically are not open and have the same letter then it will detect that someone won
        if ((board[x][y+1] != " ")&&(board[x][y+3] != " ")&&(board[x][y+5] != " ")&&(board[x][y+7] != " ")&&(board[x][y+1] == board[x][y+3])&&(board[x][y+3] == board[x][y+5])&&(board[x][y+5] == board[x][y+7])){
          return(true);
        }
      }
    }for(int x=1;x<15;x+=2){
      for (int y=0;y<4;y++){//Horizontal Line
        //if 4 spots horizontally are not open and have the same letter then it will detect that someone won
        if ((board[y][x] != " ")&&(board[y+1][x] != " ")&&(board[y+2][x] != " ")&&(board[y+3][x] != " ")&&(board[y][x] == board[y+1][x])&&(board[y+1][x] == board[y+2][x])&&(board[y+2][x] == board[y+3][x])){
          return(true);//return true so we can detect a winner in the if statement in the Menu file
        }
      }
    }for(int x=0;x<3;x++){//For any diagonal line that looks like this \
      for (int y=1;y<9;y+=2){
        //if 4 spots downwards diagonally are not open and have the same letter then it will detect that someone won
        if ((board[x][y] != " ")&&(board[x+1][y+2] != " ")&&(board[x+2][y+4] != " ")&&(board[x+3][y+6] != " ")&&(board[x][y] == board[x+1][y+2])&&(board[x+1][y+2] == board[x+2][y+4])&&(board[x+2][y+4] == board[x+3][y+6])){
          return(true);
        }
      }
    }for (int x=0;x<4;x++){//For any diagonal line that looks like this /
      for (int y=7;y<15;y+=2){
        //if 4 spots upwards diagonally are not open and have the same letter then it will detect that someone won
        if ((board[x][y] != " ")&&(board[x+1][y-2] != " ")&&(board[x+2][y-4] != " ")&&(board[x+3][y-6] != " ")&&(board[x][y] == board[x+1][y-2])&&(board[x+1][y-2] == board[x+2][y-4])&&(board[x+2][y-4] == board[x+3][y-6])){
          return(true);
        }
      }
