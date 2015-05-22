package com.example.androidtictactoe2player;

/*************************************
*   @author Harrison Jordan
*************************************/

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab23
 */
public class TicTacToe2Player extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TTT2GameView game = new TTT2GameView(this);
		setContentView(game);
		game.startGame();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tic_tac_toe2_player, menu);
		return true;
	}
}
