package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.ttt.exception.TicTacToeException;

public class TicTacToeTest {

	TicTacToe tictactoe = new TicTacToe();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void initializeNewTicTacToeGame() {
		assertNotNull(tictactoe);
	}

	@Test
	public void RunTimeExceptionFoundWhenXOutsideOfBoard() {
		exception.expect(TicTacToeException.class);
		tictactoe.play(5, 2);
	}

	@Test
	public void RunTimeExceptionFoundWhenYOutsideOfBoard() {
		exception.expect(TicTacToeException.class);
		tictactoe.play(2, 6);
	}

}
