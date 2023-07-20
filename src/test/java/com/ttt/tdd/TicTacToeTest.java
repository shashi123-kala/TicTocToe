package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

	@Test
	public void whenOccupiedThenRuntimeException() {
		exception.expect(TicTacToeException.class);
		tictactoe.play(2, 1);
	}

	@Test
	public void playWithX() {
		assertEquals('X', tictactoe.playWithPlayer());
	}

	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		tictactoe.play(1, 1);
		assertEquals('O', tictactoe.playWithPlayer());
	}

	@Test
	public void whenPlayThenNoWinner() {
		String actual = tictactoe.play(1, 1);
		assertEquals("No winner", actual);
	}

	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		tictactoe.play(1, 1); // X
		tictactoe.play(1, 2); // O
		tictactoe.play(2, 1); // X
		tictactoe.play(2, 2); // O
		String actual = tictactoe.play(3, 1); // X
		assertEquals("X is the Winner", actual);
	}
}
