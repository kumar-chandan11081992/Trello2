package services;

public class CardKGS {
		private static int i = 1;
		private CardKGS() {
		}
		
		private static CardKGS boardKGS;
		
		public static CardKGS getInstance() {
			if(boardKGS == null)
				boardKGS = new CardKGS();
			
			return boardKGS;
		}
		
		public static String getKey() {
			CardKGS cardKGS = getInstance();
			String keyToReturn = String.valueOf(cardKGS.i);
			i++;
			return keyToReturn;
		}
}
