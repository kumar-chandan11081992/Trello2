package services;

public class BoardKGS {
	private static int i = 1;
	private BoardKGS() {
	}
	
	private static BoardKGS boardKGS;
	
	public static BoardKGS getInstance() {
		if(boardKGS == null)
			boardKGS = new BoardKGS();
		
		return boardKGS;
	}
	
	public static String getKey() {
		BoardKGS boardKGS = getInstance();
		String keyToReturn = String.valueOf(boardKGS.i);
		i++;
		return keyToReturn;
	}
}
