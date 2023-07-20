package com.ttt.tdd;

import com.ttt.exception.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public String play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(column, "Y value is outside the board!");
		setField(column, row,lastPlayer);
		lastPlayer = playWithPlayer();
		return checkWin();
	}

	private String checkWin() {
		String winner = "No winner";
		for (int index = 0; index < 3; index++) {
			if (board[0][index] == lastPlayer && board[1][index] == lastPlayer && board[2][index] == lastPlayer) {
				return lastPlayer + " is the Winner";
			}
		}
		return winner;
	}

	private void checkAxis(int axis, String message) {
		if (axis < 1 || axis > 3) {
			throw new TicTacToeException(message);
		}
	}

	private void setField(int column, int row, char lastPlayer) {
		if (board[column - 1][row - 1] != '\0') {
			throw new RuntimeException("Field is occupied!");
		} else {
			board[column - 1][row - 1] = lastPlayer;
		}
	}

	public char playWithPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
}
