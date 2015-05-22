/**
* @author Multiple
*/

package com.example.androidtictactoe2player;
import p2p.*;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab23
 */
@SuppressLint("HandlerLeak")
public class TTT2GameView extends View {
    // Game Constants
    private final int COLS = 3, ROWS = 3;
    private final int XVAL = 1, OVAL = 2, TIEVAL = 3;
    private final int HDHEIGHT = 60;

    // Game State Data
    private int [][] board = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
    private int playerTurn = 1;   // 1 is for X, 2 is for O
    private int winState = 0;
    private boolean gameOver = false;
    private boolean gameStarted = false;
    private boolean establishing1 = false;
    private boolean establishing2 = false;
    private boolean samePlayer = false;
    private boolean myTurn;
    private String usernameStr = "";
    private String othernameStr = "";

    // Flag for Single Player Mode
    private boolean singlePlayerMode = false;

    // Peer-To-Peer data structure
    private P2PAndroid p2p = null;

    // EditText objects for username and opponent's username
    private EditText usernameText;
    private EditText othernameText;

    // AlertDialog to get username and opponent's username
    private AlertDialog alertDialog;
    
    // Button objects
    private Button btnOK;
    private Button btnCancel;

    // Drawing objects
    private Paint borderPaint;
    private Paint headingPaint;
    private Paint textPaint;
    private Paint emptyPaint;
    private Paint grayedPaint;
    private Paint xMarkPaint;
    private Paint oMarkPaint;

    private RectF oRect = new RectF();    // for drawing the O
    
    // Loading the strings
    private String establishCommStr = getContext().getString(R.string.establishing);
    private String yourTurnStr = getContext().getString(R.string.yourturn);
    private String yourX = getContext().getString(R.string.yourx);
    private String yourO = getContext().getString(R.string.youro);
    private String xTurnStr = getContext().getString(R.string.xturntext);
    private String oTurnStr = getContext().getString(R.string.oturntext);
    private String welcomeStr = getContext().getString(R.string.welcometext);
    private String xwinsStr = getContext().getString(R.string.xwinstext);
    private String owinsStr = getContext().getString(R.string.owinstext);
    private String aDrawStr = getContext().getString(R.string.adrawtext);
    private String playingSelf = getContext().getString(R.string.yourself);
    private String unRequired = getContext().getString(R.string.usernamereqtext);
    private String onRequired = getContext().getString(R.string.othernamereqtext);

    // Special Message Task handler
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 1:
            case 2:
            case 3: // Win, Lose or Draw message
                    Toast.makeText(getContext(),hdMessage(),
                                     Toast.LENGTH_LONG).show();
                    break;
            case 4: // Get incoming messages
                    new ReceiveP2P().execute();
                    break;
            default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    // The constructor
    public TTT2GameView(Context context) {
        super(context);
        borderPaint = new Paint();
        borderPaint.setARGB(255, 0, 0, 0);
        borderPaint.setAntiAlias(true);
        borderPaint.setStyle(Style.STROKE);
        borderPaint.setStrokeWidth(5);

        headingPaint = new Paint();
        headingPaint.setARGB(255, 255, 255, 0);
        headingPaint.setAntiAlias(true);
        headingPaint.setStyle(Style.FILL);

        textPaint = new Paint();
        textPaint.setARGB(255, 65, 105, 225);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(30);

        emptyPaint = new Paint();
        emptyPaint.setARGB(255, 255, 255, 255);
        emptyPaint.setAntiAlias(true);
        emptyPaint.setStyle(Style.FILL);

        grayedPaint = new Paint();
        grayedPaint.setARGB(255, 128, 128, 128);
        grayedPaint.setAntiAlias(true);
        grayedPaint.setStyle(Style.FILL);

        // Paint for the X
        xMarkPaint = new Paint();
        xMarkPaint.setARGB(255, 0, 0, 0);  // black color
        xMarkPaint.setStyle(Style.FILL);
        xMarkPaint.setStrokeWidth(20);
        
        // Paint for the O
        oMarkPaint = new Paint();
        oMarkPaint.setARGB(255, 255, 0, 0);  // red color
        oMarkPaint.setStyle(Style.STROKE);
        oMarkPaint.setStrokeWidth(20);
    }

    // Draws the board when updated
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        int vOffset = (this.getHeight() - HDHEIGHT) / ROWS;
        int hOffset = this.getWidth() / COLS;
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] == 1)
                        drawX(canvas,j*hOffset+30,HDHEIGHT+i*vOffset+30,
                                (j*hOffset)+hOffset-30,HDHEIGHT+(i*vOffset)+vOffset-30);
                    else
                        drawO(canvas,j*hOffset+30,HDHEIGHT+i*vOffset+30,
                                (j*hOffset)+hOffset-30,HDHEIGHT+(i*vOffset)+vOffset-30);
                } else
                    canvas.drawRect(j*hOffset, HDHEIGHT+i*vOffset, (j*hOffset)+hOffset,
                                             HDHEIGHT+(i*vOffset)+vOffset, emptyPaint);
            }
        
        canvas.drawRect(0, 0, this.getWidth(), HDHEIGHT, headingPaint);
        
        String message = hdMessage();
        int offset = (int)(this.getWidth() - textPaint.measureText(message) - 10) / 2;
        canvas.drawText(message, offset, HDHEIGHT-15, textPaint);

        for (int i = 0; i <= ROWS; i++)
            canvas.drawLine(0, HDHEIGHT + vOffset * i, this.getWidth(), HDHEIGHT + vOffset * i, borderPaint);
        for (int i = 0; i <= COLS; i++)
            canvas.drawLine(hOffset * i, HDHEIGHT, hOffset * i, this.getHeight(), borderPaint);
    }
    
    // Method for drawing an X Board
    protected void drawX(Canvas canvas, int x1, int y1, int x2, int y2) {
        int xOff = x2 - x1;
        int yOff = y2 - y1;
        if (xOff > yOff) {
            x1 += (xOff-yOff) / 2;
            x2 -= (xOff-yOff) / 2;
        } else {
            y1 += (yOff-xOff) / 2;
            y2 -= (yOff-xOff) / 2;
        }
        canvas.drawLine(x1,y1,x2,y2,xMarkPaint);
        canvas.drawLine(x2,y1,x1,y2,xMarkPaint);
    }
    
    // Method for drawing an O on Board
    protected void drawO(Canvas canvas, int x1, int y1, int x2, int y2) {
        int xOff = x2 - x1;
        int yOff = y2 - y1;
        if (xOff > yOff) {
            x1 += (xOff-yOff) / 2;
            x2 -= (xOff-yOff) / 2;
        } else {
            y1 += (yOff-xOff) / 2;
            y2 -= (yOff-xOff) / 2;
        }
        oRect.set(x1,y1,x2,y2);
        canvas.drawOval(oRect,oMarkPaint);   // Door knob
    }
/*************************************
*   @author Harrison Jordan
*************************************/
    // Handles what to do when the board is touched
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gameOver) {
            endGame();
            startGame();
        } else if (event.getY() > HDHEIGHT && gameStarted && myTurn) {
            int rOff = (int) ((event.getY()-HDHEIGHT) /
                                ((this.getHeight()-HDHEIGHT) / ROWS));
            int cOff = (int) (event.getX() / (this.getWidth() / COLS));
            if (board[rOff][cOff] == 0) {
                board[rOff][cOff] = playerTurn;
                playerTurn = 3 - playerTurn;
                if (!samePlayer) {
                    myTurn = false;
                       new SendP2P().execute();
                }
                checkGameState();
                invalidate();
                if (!samePlayer && !gameOver)
                       handler.sendMessageDelayed(Message.obtain(handler, 4),1000);
            }
        }
        return super.onTouchEvent(event);
    }
/*************************************
*   @author Harrison Jordan
*************************************/
    // Determines the state of the game: win, lose, draw or no outcome
    private void checkGameState() { 
    	boolean isWinner = false;
    	int player;
    	
    	for(player = 1; player <= 2; player++){
    		// Horizontal
    		if		(board[0][0] == player && board[0][1] == player && board[0][2] == player)
    			isWinner = true;
    		else if	(board[1][0] == player && board[1][1] == player && board[1][2] == player)
    			isWinner = true;
    		else if	(board[2][0] == player && board[2][1] == player && board[2][2] == player)
    			isWinner = true;
    		// Vertical
    		else if	(board[0][0] == player && board[1][0] == player && board[2][0] == player)
    			isWinner = true;
    		else if	(board[0][1] == player && board[1][1] == player && board[2][1] == player)
    			isWinner = true;
    		else if	(board[0][2] == player && board[1][2] == player && board[2][2] == player)
    			isWinner = true;
    		// Diagonal
    		else if	(board[0][0] == player && board[1][1] == player && board[2][2] == player)
    			isWinner = true;
    		else if	(board[0][2] == player && board[1][1] == player && board[2][0] == player)
    			isWinner = true;
    		if(isWinner)
    			break;
    	}
    
    	if (isWinner || isDraw()) {
             gameOver = true;
             winState = (isWinner) ? player : 3;
             handler.sendMessage(Message.obtain(handler, winState));
         }
        
         establishing2 = false;
    }
    
/*************************************
*   @author Harrison Jordan
*************************************/
    // Determines if the game is a draw
    private boolean isDraw() {
        for (int i = 0; i < ROWS; ++i)
            for (int j = 0; j < COLS; ++j)
                if (board[i][j] == 0)
                    return false;
        return true;
    }

    // Starts the game
    public void startGame() {
        if (singlePlayerMode)
            runAsSinglePlayer();
        else
            initP2P();
        invalidate();
    }

    // Accessor for gameStarted flag
    public boolean gameStarted() {
        return gameStarted;
    }

    // Ends the game and resets key data fields
    public void endGame() {
        gameStarted = samePlayer = establishing1 = establishing2 = false;
        playerTurn = XVAL;
        winState = 0;
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                board[i][j] = 0;
        invalidate();
        new CloseP2P().execute();
    }
/*************************************
*   @author Harrison Jordan
*************************************/
    // Determines what goes into the header portion of the window
    private String hdMessage() {
        if (establishing1)
            return establishCommStr;
        if (establishing2)
            return (myTurn) ? yourX : yourO;
        if (!gameStarted)
            return welcomeStr;
        if (gameOver)
            if (winState == TIEVAL)
                return aDrawStr;
            else if (winState == XVAL)
                return xwinsStr;
            else if (winState == OVAL)
                return owinsStr;
            else
                return welcomeStr;
        if (myTurn && !samePlayer)
            return yourTurnStr;
        if (playerTurn == XVAL)
            return xTurnStr;
        return oTurnStr;
    }
    
    private void runAsSinglePlayer() {
        samePlayer = true;
        myTurn = true;
        gameStarted = true;
        gameOver = false;
        invalidate();
        Toast.makeText(getContext(),playingSelf,Toast.LENGTH_LONG).show();
    }
    
    // Creates a dialog box that gets the user's and the opponent's name
    private void initP2P() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.prompts, null);
        
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setView(promptsView).setCancelable(false);

        usernameText = (EditText) promptsView
                      .findViewById(R.id.editTextDialogUserName);
        othernameText = (EditText) promptsView
                      .findViewById(R.id.editTextDialogOtherUserName);

        btnOK = (Button) promptsView.findViewById(R.id.okButton);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameStr = usernameText.getText().toString().trim();
                othernameStr = othernameText.getText().toString().trim();
                if (usernameStr.length() == 0) {
                    usernameText.requestFocus();
                    usernameText.setError(unRequired);
                } else if (othernameStr.length() == 0) {
                    othernameText.requestFocus();
                    othernameText.setError(onRequired);
                } else
                    alertDialog.dismiss();
            }
        });

        btnCancel = (Button) promptsView.findViewById(R.id.cancelButton);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endGame();
                System.exit(0);
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (usernameStr.equalsIgnoreCase(othernameStr)) {
                    runAsSinglePlayer();
                } else {
                    establishing1 = true;
                    invalidate();
                    new StartP2P().execute();
                }
            }
        });
        
        alertDialog.show();
    }

    // This asynchronous task starts the P2P session
    private class StartP2P extends AsyncTask<Void, Void, String> {
       @Override
       protected String doInBackground(Void... params) {
           p2p = new P2PAndroid(usernameStr);    // start the p2p session
           String err = p2p.getErrorStatus();
           if (err == null || err.length() == 0) {
               p2p.talkTo(othernameStr);         // determine who to talk to
               err = p2p.getErrorStatus();
           }
           if (err == null || err.length() == 0) {
               p2p.handShake();                  // wait for other player
               err = p2p.getErrorStatus();
           }
           return err;          // return any error message
       }

       @Override
       protected void onPostExecute(String statusMess) {
          // The P2P session started successfully if no error message
          if (statusMess == null || statusMess.equals("")) {
                new ChoosePlayers().execute();
          }
          else
             Toast.makeText(getContext(),statusMess,Toast.LENGTH_SHORT).show();
       }
    }

    // This asynchronous task chooses who is first between the 2 players
    private class ChoosePlayers extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... params) {
             int num1 = (int) (Math.random() * 100);    // random # from 0 to 99
             p2p.sendInt(num1);                         // sending the #
             int num2 = p2p.receiveInt();               // receiving opponents #
             return Integer.valueOf(num1 - num2);
        }

        @Override
        protected void onPostExecute(Integer statusInt) {
           // The P2P session started successfully if no error message
           if (statusInt == 0)
               new ChoosePlayers().execute();
           else {
               myTurn = (statusInt > 0);       // The highest # goes first
               Toast.makeText(getContext(),(statusInt > 0) ? yourX : yourO,
                                                  Toast.LENGTH_LONG).show();
               gameOver = false;
                  gameStarted = true;
                  establishing1 = false;
                  establishing2 = true;
                  invalidate();
                  if (!myTurn)
                       handler.sendMessageDelayed(Message.obtain(handler, 4),1000);
           }
        }
     }

    // This asynchronous task attempts to send the board array
    // to deliver the user's next move to the opponent
    private class SendP2P extends AsyncTask<Void, Void, String> {
       @Override
       protected String doInBackground(Void... params) {
          // Sending board to other player
          p2p.sendObject(board);
          return p2p.getErrorStatus();
       }
         
       @Override
       protected void onPostExecute(String result) {
          if (result != null && result.length() > 0)
              Toast.makeText(getContext(),result,Toast.LENGTH_LONG).show();
       }
    }

    // This asynchronous task attempts to receive the board array
    // showing the opponent's next move
    private class ReceiveP2P extends AsyncTask<Void, Void, String> {
       @Override
       protected String doInBackground(Void... params) {
            int [][] newBoard = (int [][]) p2p.receiveObject(false);
            String err = p2p.getErrorStatus();
            if (err != null && err.length() > 0)
                 return err;
            if (newBoard != null) {
                for (int i = 0; i < ROWS; ++i)
                    for (int j = 0; j < COLS; ++j)
                        board[i][j] = newBoard[i][j];
                return "";
            } else {
                   handler.sendMessageDelayed(Message.obtain(handler, 4),1000);
                   return null;
            }
       }

       @Override
       protected void onPostExecute(String result) {
          // Show any error message
          if (result != null && result.length() > 0) {
              Toast.makeText(getContext(),result,Toast.LENGTH_LONG).show();
          } else if (result != null) {
              playerTurn = 3 - playerTurn;
              myTurn = true;
              checkGameState();
              invalidate();
              if (!gameOver)
                  Toast.makeText(getContext(),yourTurnStr,Toast.LENGTH_SHORT).show();
          }
       }
    }

    // This asynchronous task Closes the P2P session
    private class CloseP2P extends AsyncTask<Void, Void, Void> {
       @Override
       protected Void doInBackground(Void... params) {
          if (p2p != null) {
             p2p.close();
             p2p = null;
          }
          return null;
       }
    }
}