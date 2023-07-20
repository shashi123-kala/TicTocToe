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
		if (isWinner()) {
			return lastPlayer + " is the Winner";
		}
		return "No winner";
	}

	private boolean isWinner() {
		int playerTotal = lastPlayer * SIZE;
		for (int i = 0; i < SIZE; i++)
			if (board[0][i] + board[1][i] + board[2][i] == playerTotal
					|| board[i][0] + board[i][1] + board[i][2] == playerTotal) {
				return true;
			}
		if (board[0][0] + board[1][1] + board[2][2] == playerTotal)
			return true;

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
