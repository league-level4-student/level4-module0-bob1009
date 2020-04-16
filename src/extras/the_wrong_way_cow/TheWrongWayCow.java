//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {
	int[] moo = new int[2];
	int[] moo2 = new int[2];
	int[] moo3 = new int[2];
	int[] moo4 = new int[2];

	public static int[] findWrongWayCow(final char[][] field) {

		return null;
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!
	}

	int[] checkWest(final char[][] field) {
		int rightwaywest = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 'c' && field[i + 1][j] == 'o' && field[i + 2][j] == 'w') {
					rightwaywest += 1;
				} else {
					moo[0] = i;
					moo[1] = j;

				}
			}
		}
		return moo;
	}

	int[] checkEast(final char[][] field) {
		int rightwayEast = 0;
		int wrongwayEast = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 'w' && field[i + 1][j] == '0' && field[i + 1][j] == 'c') {
					rightwayEast += 1;
				} else {
					moo2[0] = i;
					moo2[i] = j;
				}

			}

		}
		return moo2;
	}

	int[] checkNorth(final char[][] field) {
		int rightwayNorth = 0;
		int wrongwayNorth = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j + 1] == 'c' && field[i][j + 1] == 'o' && field[i][j + 1] == 'w') {
					rightwayNorth += 1;
				} else {
					moo3[0]=i;
					moo3[1]=j;
				}
			}
		}
		return moo3;
	}

	int[] checkSouth(final char[][] field) {
		int rightwaySouth = 0;
		int wrongwaySouth = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j + 1] == 'w' && field[i][j + 1] == '0' && field[i][j + 1] == 'c') {
					rightwaySouth += 1;
				} else {
					moo4[0]=i;
					moo4[0]=j;
				}
			}
		}
return moo4;
	}
//		void check() {
//		boolean wrongwaywrong=false;
//		boolean rightwaywrong=false;
//		if (rightway>wrongway) {
//			wrongwaywrong=true;
//		}
//		else {
//		rightwaywrong=true; 
//		}
//		}

}
