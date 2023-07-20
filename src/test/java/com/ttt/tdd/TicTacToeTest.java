package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

	TicTacToe tictactoe = new TicTacToe();

	@Test
	public void initializeNewTicTacToeGame() {
		assertNotNull(tictactoe);
	}

}
