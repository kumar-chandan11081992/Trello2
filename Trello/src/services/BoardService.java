package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dataStore.DB;
import enumerations.Privacy;
import interfaces.IBoard;
import interfaces.IBoardService;
import interfaces.ICard;
import interfaces.IList;
import interfaces.IUser;
import models.Board;

public class BoardService implements IBoardService{

	DB database;
	public BoardService(DB database) {
		this.database = database;
	}
	
	public IBoard getBoard(String boardId) {
		return database.getBoards().get(boardId);
	}
	
	public List<IBoard> getBoards(String boardId) {
		HashSet<Entry<String, IBoard>> boardSet = (HashSet<Entry<String, IBoard>>) database.getBoards().entrySet();
		List<IBoard> boards = new LinkedList<IBoard>();
		for(Entry<String, IBoard> entry : boardSet) {
			boards.add(entry.getValue());
		}
		
		return boards;
	}
	
	@Override
	public IBoard createBoard(String name, Privacy privacy, String url, HashMap<String,IUser> members,
			HashMap<String, IList> lists) {
		IBoard board = new Board(name, privacy, members, lists);
		this.database.getBoards().put(board.getBoardId(), board);
		return board;
	}

	@Override
	public IBoard addMembersToBoard(IUser member, IBoard board) {
		HashMap<String, IUser> members = board.getMembers();
		members.put(member.getId(), member);
		return board;
	}

	@Override
	public IBoard removeMembersFromBoard(IUser member, IBoard board) {
		HashMap<String, IUser> members = board.getMembers();
		members.remove(member.getId());
		return board;
	}

	@Override
	public IBoard updateMembersInBoard(IUser member, IBoard board) {
		HashMap<String, IUser> members = board.getMembers();
		members.put(member.getId(), member);
		return board;
	}

	@Override
	public void deleteBoard(String boardId) {
		IBoard board = this.database.getBoards().get(boardId);
		HashMap<String, IList> lists = board.getLists();
		this.database.getBoards().remove(boardId);
		for(Map.Entry<String, IList> list : lists.entrySet()) {
			this.database.getLists().remove(list.getKey());
		}
	}

	@Override
	public IBoard moveCards(String listFrom, String listTo, String cardId) {
		IList listFromO = this.database.getLists().get(listFrom);
		IList listToO = this.database.getLists().get(listTo);
		ICard cardToMove = listFromO.getCards().get(cardId);
		listFromO.getCards().remove(cardId);
		listToO.getCards().put(cardId, cardToMove);
		
		return this.database.getBoards().get(listToO.getBoardId());
	}

}
