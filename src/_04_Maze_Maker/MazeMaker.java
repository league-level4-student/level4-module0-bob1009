package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int ranx = randGen.nextInt(maze.getWidth());
		int rany = randGen.nextInt(maze.getHeight());
		Cell rancell = maze.getCell(ranx, rany);
		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(rancell);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. Get an ArrayList of unvisited neighbors using the current cell and the
		// method below
		ArrayList<Cell> list = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,

		if (list.size() > 0) {
			Cell newcell = list.get(randGen.nextInt(list.size()));
			uncheckedCells.push(newcell);
			removeWalls(currentCell, newcell);
			currentCell = newcell;
			newcell.setBeenVisited(true);
			selectNextPath(currentCell);
		} else {
			if (!uncheckedCells.isEmpty()) {
				Cell popped = uncheckedCells.pop();
				currentCell = popped;
				selectNextPath(currentCell);
			}
		}

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getX() == c2.getX()) {
			if (c1.getY() > c2.getY()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		} else {
			if (c1.getX() > c2.getX()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			} else {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		int x = c.getX();
		int y = c.getY();
		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();
		if (x > 0 && !maze.getCell(x - 1, y).hasBeenVisited())
			unvisitedNeighbors.add(maze.getCell(x - 1, y));
		if (y > 0 && !maze.getCell(x, y - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x, y - 1));
		}
		if (x < width - 1 && !maze.getCell(x - 1, y).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x - 1, y));
		}
		if (y < height - 1 && !maze.getCell(x, y - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x, y - 1));
		}
		return unvisitedNeighbors;

	}

}
