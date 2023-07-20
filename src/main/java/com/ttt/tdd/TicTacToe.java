package com.ttt.tdd;

import com.ttt.exception.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };

	public void play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(column, "Y value is outside the board!");
		if (board[column - 1][row - 1] != '\0') {
			throw new TicTacToeException("Field is occupied!");
		} else {
			board[column - 1][row - 1] = 'X';
		}
	}
	
	private void checkAxis(int axis, String message) {
        if (axis < 1 || axis > 3) {
            throw new TicTacToeException(message);
        }
	}
}
