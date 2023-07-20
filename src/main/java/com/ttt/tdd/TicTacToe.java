package com.ttt.tdd;

import com.ttt.exception.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';
	private static final int SIZE = 3;

	public String play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(column, "Y value is outside the board!");
		setField(column, row, lastPlayer);
		lastPlayer = playWithPlayer();
		if (isWinner(column, row)) {
			return lastPlayer + " is the Winner";
		} else if (isDraw()) {
			return "It is a draw";
		} else {
			return "No winner";
		}
	}

	private boolean isDraw() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (board[x][y] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isWinner(int column, int row) {
		int playerTotal = lastPlayer * SIZE;
		char horizontal, vertical, diagonal1, diagonal2;
		horizontal = vertical = diagonal1 = diagonal2 = '\0';
		for (int i = 0; i < SIZE; i++) {
			horizontal += board[i][row - 1];
			vertical += board[column - 1][i];
			diagonal1 += board[i][i];
			diagonal2 += board[i][SIZE - i - 1];
			if (horizontal == playerTotal || vertical == playerTotal || diagonal1 == playerTotal
					|| diagonal2 == playerTotal) {
				return true;
			}
		}
		return false;
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
