import java.util.*;
import java.io.*;
public class CheckersProgram
	{
		public static int xChosen;
		public static int yChosen;
		public static int xNew;
		public static int yNew;
		public static void main(String[] args)
			{
				int board[][] = new int[8][8];
				ArrayList <BlackPieces> blackPieces = new ArrayList <BlackPieces>();
				ArrayList <RedPieces> redPieces = new ArrayList <RedPieces>();
				boolean redAlive=true;
				boolean blackAlive=true;
				printInstructions();
				newGame(board);
				placeBlackPieces(blackPieces);
				placeRedPieces(redPieces);
				printBoard(board);
				//while(redAlive && blackAlive)
					{
						blackMove(blackPieces, redPieces);
						registerPlacement(blackPieces, redPieces, board);
						redMove(redPieces, blackPieces);
						registerPlacement(blackPieces, redPieces, board);
						printBoard(board);
					}
			}
		public static void printInstructions()
		{
			
		}
		public static void newGame(int map[][])
			{
				for(int column = 0; column<=7; column++)
					{
						for(int row = 0; row<=7; row++)
							{
								if(row%2==1 && column%2==0 && row<2)
									{
										map[column][row] = 0;
									}
								else if(column%2==1 && row%2==0 && row<2)
									{
										map[column][row] = 0;
									}
								else if(column%2==1 && row%2==0 && row>5)
									{
										map[column][row] = 3;
									}
								else if(row%2==1 && column%2==0 && row>5)
									{
										map[column][row] = 3;
									}
								else
									{
										map[column][row] = 1;
									}
								
							}
					}
			}
		public static void placeBlackPieces(ArrayList<BlackPieces> b)
			{
				b.add(new BlackPieces(true, false, 1, 0, "black"));
				b.add(new BlackPieces(true, false, 3, 0, "black"));
				b.add(new BlackPieces(true, false, 5, 0, "black"));
				b.add(new BlackPieces(true, false, 7, 0, "black"));
				b.add(new BlackPieces(true, false, 0, 1, "black"));
				b.add(new BlackPieces(true, false, 2, 1, "black"));
				b.add(new BlackPieces(true, false, 4, 1, "black"));
				b.add(new BlackPieces(true, false, 6, 1, "black"));
			}		
		public static void placeRedPieces(ArrayList<RedPieces> a)
			{
				a.add(new RedPieces(true, false, 1, 6, "red"));
				a.add(new RedPieces(true, false, 3, 6, "red"));
				a.add(new RedPieces(true, false, 5, 6, "red"));
				a.add(new RedPieces(true, false, 7, 6, "red"));
				a.add(new RedPieces(true, false, 0, 7, "red"));
				a.add(new RedPieces(true, false, 2, 7, "red"));
				a.add(new RedPieces(true, false, 4, 7, "red"));
				a.add(new RedPieces(true, false, 6, 7, "red"));
			}
		public static void registerPlacement(ArrayList<BlackPieces> b, ArrayList<RedPieces> a, int map[][])
			{	
						map[xNew][yNew] = map[xChosen][yChosen];
						map[xChosen][yChosen]=1;
			}
		public static void printBoard(int map[][])
			{
				System.out.println("1 2 3 4 5 6 7 8");
				for(int column = 0; column<=7; column++)
					{
						for(int row = 0; row<=8; row++)
							{
							if(row>7)
								{
									if(column == 0)
										{
											System.out.print("a");
										}
									if(column == 1)
										{
											System.out.print("b");
										}
									else if(column == 2)
										{
											System.out.print("c");
										}
									else if(column == 3)
										{
											System.out.print("d");
										}
									else if(column == 4)
										{
											System.out.print("e");
										}
									else if(column == 5)
										{
											System.out.print("f");
										}
									else if(column == 6)
										{
											System.out.print("g");
										}
									else if(column == 7)
										{
											System.out.print("h");
										}
									else if(column == 8)
										{
											System.out.print("i");
										}
								}
							else
								{
								if(map[row][column]==1)
									{
										System.out.print(" ");
										System.out.print(" ");
									}
								else if(map[row][column]==0)
									{
										System.out.print("O");
										System.out.print(" ");
									}
								else if(map[row][column]==3)
									{
										System.out.print("o");
										System.out.print(" ");
									}
								}
							}
						System.out.println();
					}
			}
		public static void blackMove(ArrayList<BlackPieces> b, ArrayList<RedPieces> a)
			{
				Scanner in = new Scanner(System.in);
				System.out.println("Please select your piece.");
				String piece = in.nextLine();
				piece = piece.toLowerCase();
				yChosen = (int)piece.charAt(0)-97;
				xChosen = Integer.parseInt(piece.substring(1))-1;
				int rememberPiece = 0;
				boolean run = false;
				for(int pieces = 0; pieces<b.size(); pieces++)
							{
								if(xChosen == b.get(pieces).getxPos() && yChosen == b.get(pieces).getyPos())
									{
										rememberPiece = pieces;
										run = true;
									}
							}
				if(run == false)
					{
						System.out.println("Sorry there isn't a piece there.");
						blackMove(b, a);
					}
						Scanner input = new Scanner(System.in);
						System.out.println("Please select your desired location.");
						String reply = in.nextLine();
						reply = reply.toLowerCase();
						yNew = (int)reply.charAt(0)-97;
						xNew = Integer.parseInt(reply.substring(1))-1;
						int tester = (xNew - yNew);
						tester = Math.abs(tester);
						tester = tester%2;
						if(tester != 0)
							{
								boolean blackPieces = true;
								for(int pieces = 0; pieces<b.size(); pieces++)
									{
										if(xNew == b.get(pieces).getxPos() && yNew == b.get(pieces).getyPos())
											{
												blackPieces = false;
												System.out.println("There is already a piece there. Please move again.");
												blackMove(b, a);
											}
									}
								if(blackPieces == true)
									{
										for(int pieces = 0; pieces<a.size(); pieces++)
											{
												if(xNew == a.get(pieces).getxPos() && yNew == a.get(pieces).getyPos())
													{
														a.remove(pieces);
													}
											}
										b.get(rememberPiece).setxPos(xNew);
										b.get(rememberPiece).setyPos(yNew);
									}
							}
						else
							{
								System.out.println("You can't move there.");
								blackMove(b, a);
							}
					}
		public static void redMove(ArrayList<RedPieces> b, ArrayList<BlackPieces> a)
			{
				System.out.println("Red Move.");
				Scanner in = new Scanner(System.in);
				System.out.println("Please select your piece.");
				String piece = in.nextLine();
				piece = piece.toLowerCase();
				yChosen = (int)piece.charAt(0)-97;
				xChosen = Integer.parseInt(piece.substring(1))-1;
				int rememberPiece = 0;
				boolean run = false;
				for(int pieces = 0; pieces<b.size(); pieces++)
							{
								if(xChosen == b.get(pieces).getxPos() && yChosen == b.get(pieces).getyPos())
									{
										rememberPiece = pieces;
										run = true;
									}
							}
				if(run == false)
					{
						System.out.println("Sorry there isn't a piece there.");
						redMove(b, a);
					}
						Scanner input = new Scanner(System.in);
						System.out.println("Please select your desired location.");
						String reply = in.nextLine();
						reply = reply.toLowerCase();
						yNew = (int)reply.charAt(0)-97;
						xNew = Integer.parseInt(reply.substring(1))-1;
						int tester = (xNew - yNew);
						tester = Math.abs(tester);
						tester = tester%2;
						if(tester != 0)
							{
								boolean blackPieces = true;
								for(int pieces = 0; pieces<b.size(); pieces++)
									{
										if(xNew == b.get(pieces).getxPos() && yNew == b.get(pieces).getyPos())
											{
												blackPieces = false;
												System.out.println("There is already a piece there. Please move again.");
												redMove(b, a);
											}
									}
								if(blackPieces == true)
									{
										for(int pieces = 0; pieces<a.size(); pieces++)
											{
												if(xNew == a.get(pieces).getxPos() && yNew == a.get(pieces).getyPos())
													{
														a.remove(pieces);
													}
											}
										b.get(rememberPiece).setxPos(xNew);
										b.get(rememberPiece).setyPos(yNew);
									}
							}
						else
							{
								System.out.println("You can't move there.");
								redMove(b, a);
							}
					}
	}