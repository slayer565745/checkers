import java.util.*;
import java.io.*;
public class BlackPieces
	{
		boolean alive;
		boolean king;
		int xPos;
		int yPos;
		String color;
		public BlackPieces(boolean a, boolean k, int x, int y, String c)
		{
			alive = a;
			king = k;
			xPos = x;
			yPos = y;
			color = c;
		}
		public boolean isAlive()
			{
				return alive;
			}
		public void setAlive(boolean alive)
			{
				this.alive = alive;
			}
		public boolean isKing()
			{
				return king;
			}
		public void setKing(boolean king)
			{
				this.king = king;
			}
		public int getxPos()
			{
				return xPos;
			}
		public void setxPos(int xPos)
			{
				this.xPos = xPos;
			}
		public int getyPos()
			{
				return yPos;
			}
		public void setyPos(int yPos)
			{
				this.yPos = yPos;
			}
		public String getColor()
			{
				return color;
			}
		public void setColor(String color)
			{
				this.color = color;
			}

	}
