package mahJong;

public class MakeWin {
	
	private Combination firstMeld;
	private Combination secondMeld;
	private Combination thirdMeld;
	private Combination fouthMeld;
	private Combination eyes;
	private Win win;
	
	public MakeWin(String[] input) {
		firstMeld = makeMeld(new String[]{input[0], input[1], input[2]});
		secondMeld = makeMeld(new String[]{input[3], input[4], input[5]});
		thirdMeld = makeMeld(new String[]{input[6], input[7], input[8]});
		fouthMeld = makeMeld(new String[]{input[9], input[10], input[11]});
		eyes = makeEyes(new String[]{input[12], input[13]});
		win = new Win(firstMeld, secondMeld, thirdMeld, fouthMeld, eyes);
	}
	
	public Win getWin() {
		return win;
	}
	
//	public void makeFirstComb(String[] input, Combination meld) {
//		if(isTriplet(input)) {
//			Tile t1 = makeTile(input[0]);
//			Tile t2 = makeTile(input[1]);
//			Tile t3 = makeTile(input[2]);
//			firstMeld = new Triplet (t1, t2, t3);
//		}
//	}
	
	public boolean isTriplet(String[] tile) {
		if(tile[0].charAt(1) == tile[1].charAt(1) && tile[0].charAt(1) == tile[2].charAt(1)) {
			return true;
		}
		return false;
	}
	
	public Tile makeTile(String tile) {
		return new Tile(tile);
	}
	
	public Meld makeMeld(String[] tile) {
		Tile firstTile = new Tile(tile[0]);
		Tile secondTile = new Tile(tile[1]);
		Tile thirdTile = new Tile(tile[2]);
		if(isTriplet(tile)) {
			return new Triplet(firstTile, secondTile, thirdTile);
		}
		return new Sequence(firstTile, secondTile, thirdTile);
	}
	
	public Eyes makeEyes(String[] tile) {
		Tile firstTile = new Tile(tile[0]);
		Tile secondTile = new Tile(tile[1]);
		return new Eyes(firstTile, secondTile);
	}
	
}
