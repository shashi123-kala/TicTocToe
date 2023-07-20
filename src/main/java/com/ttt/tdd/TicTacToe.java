package com.ttt.tdd;

import com.ttt.exception.TicTacToeException;

public class TicTacToe {

	public void play(int column, int row) {
		if (column < 1 || column > 3) {
			throw new TicTacToeException("X value is outside the board!");
		} else if (row < 1 || row > 3) {
			throw new RuntimeException("Y value is outside the board!");
		}
	}
}
