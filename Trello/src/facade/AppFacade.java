package facade;

import java.util.HashMap;
import java.util.Map;

import dataStore.DB;
import interfaces.*;

public class AppFacade {
	ICardService cardService;
	IBoardService boardService;
	IListService listService;
	IUserService userService;
	DB database;

	AppFacade(ICardService cardService, IBoardService boardService, IListService listService,
			IUserService userService, DB database) {
		this.cardService = cardService;
		this.boardService = boardService;
		this.listService = listService;
		this.userService = userService;
		this.database = database;
	}

	public void Show() {
		HashMap<String, IBoard> boards = this.database.getBoards();
		if(boards.isEmpty()) {
			System.out.println("No boards");
		}
		
		for(Map.Entry<String, IBoard> boardEntry : boards.entrySet()) {
			System.out.println(boardEntry.getValue().ToString());
		}
	}
	
	public void CreateBoard(String name) {
		IBoard board = this.boardService.createBoard(name, null, name, null, null);
	}
	
	
}
