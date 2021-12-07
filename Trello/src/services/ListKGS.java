package services;

public class ListKGS {
	private static int i = 1;
	private ListKGS() {
	}
	
	private static ListKGS listKGS;
	
	public static ListKGS getInstance() {
		if(listKGS == null)
			listKGS = new ListKGS();
		
		return listKGS;
	}
	
	public static String getKey() {
		ListKGS listKGS = getInstance();
		String keyToReturn = String.valueOf(listKGS.i);
		i++;
		return keyToReturn;
	}
}
