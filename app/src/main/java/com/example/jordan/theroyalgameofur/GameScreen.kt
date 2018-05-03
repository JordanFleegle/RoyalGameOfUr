package com.example.jordan.theroyalgameofur

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_screen.*

var tileSelect = 0

class GameScreen : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.player1Tile1 -> { tileSelect = 0 }
            R.id.player1Tile2 -> { tileSelect = 1 }
            R.id.player1Tile3 -> { tileSelect = 2 }
            R.id.player1Tile4 -> { tileSelect = 3 }
            R.id.player2Tile1 -> { tileSelect = 0 }
            R.id.player2Tile2 -> { tileSelect = 1 }
            R.id.player2Tile3 -> { tileSelect = 2 }
            R.id.player2Tile4 -> { tileSelect = 3 }
            R.id.Tile5 -> { tileSelect = 4 }
            R.id.Tile6 -> { tileSelect = 5 }
            R.id.Tile7 -> { tileSelect = 6 }
            R.id.Tile8 -> { tileSelect = 7 }
            R.id.Tile9 -> { tileSelect = 8 }
            R.id.Tile10 -> { tileSelect = 9 }
            R.id.Tile11 -> { tileSelect = 10 }
            R.id.Tile12 -> { tileSelect = 11 }
            R.id.player1Tile13 -> { tileSelect = 12 }
            R.id.player1Tile14 -> { tileSelect = 13 }
            R.id.player1Goal -> { tileSelect = 14 }
            R.id.player2Tile13 -> { tileSelect = 12 }
            R.id.player2Tile14 -> { tileSelect = 13 }
            R.id.player2Goal -> { tileSelect = 14 }
            R.id.P1Start -> { tileSelect = -1 }
            R.id.P2Start -> { tileSelect = -1 }
        }
    }

    internal val EMPTY = 0
    internal val DOUBLE_OCCUPATION = 2
    internal val PLAYER2 = -1
    internal val PLAYER1 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)


        val p1Tile0 = findViewById<ImageButton>(R.id.player1Tile1)
        val p1Tile1 = findViewById<ImageButton>(R.id.player1Tile2)
        val p1Tile2 = findViewById<ImageButton>(R.id.player1Tile3)
        val p1Tile3 = findViewById<ImageButton>(R.id.player1Tile4)
        val p2Tile0 = findViewById<ImageButton>(R.id.player2Tile1)
        val p2Tile1 = findViewById<ImageButton>(R.id.player2Tile2)
        val p2Tile2 = findViewById<ImageButton>(R.id.player2Tile3)
        val p2Tile3 = findViewById<ImageButton>(R.id.player2Tile4)
        val Tile4 = findViewById<ImageButton>(R.id.Tile5)
        val Tile5 = findViewById<ImageButton>(R.id.Tile6)
        val Tile6 = findViewById<ImageButton>(R.id.Tile7)
        val Tile7 = findViewById<ImageButton>(R.id.Tile8)
        val Tile8 = findViewById<ImageButton>(R.id.Tile9)
        val Tile9 = findViewById<ImageButton>(R.id.Tile10)
        val Tile10 = findViewById<ImageButton>(R.id.Tile11)
        val Tile11 = findViewById<ImageButton>(R.id.Tile12)
        val p1Tile12 = findViewById<ImageButton>(R.id.player1Tile13)
        val p1Tile13 = findViewById<ImageButton>(R.id.player1Tile14)
        val p1Tile14 = findViewById<ImageButton>(R.id.player1Goal)
        val p2Tile12 = findViewById<ImageButton>(R.id.player2Tile13)
        val p2Tile13 = findViewById<ImageButton>(R.id.player2Tile14)
        val p2Tile14 = findViewById<ImageButton>(R.id.player2Goal)
        val P1Start = findViewById<ImageButton>(R.id.P1Start)
        val P2Start = findViewById<ImageButton>(R.id.P2Start)
        //val tetraD1 = findViewById<ImageView>(R.id.tetraD1)
        //val tetraD2 = findViewById<ImageView>(R.id.tetraD2)
        //val tetraD3 = findViewById<ImageView>(R.id.tetraD3)
        //val tetraD4 = findViewById<ImageView>(R.id.tetraD4)





                var tetraDice = IntArray(4)
                var rollScore: Int
                var tileIndex = 0
                var stoneIndex = 0
                var player1Score = 0
                var player2Score = 0
                var gameOver = false
                var turnActive = true

                val player1 = Player(PLAYER1)
                val player2 = Player(PLAYER2)
                val board = Board()


                while (!gameOver) {
                    //set on click listener
                    tetraDice = board.roll()
                    for (x in tetraDice) {
                        if (tetraDice[x] == 1) {
                            // TODO display appropriate die icon in appropriate die slot
                        } else if (tetraDice[x] == 0) {
                            // TODO display appropriate die icon in appropriate die slot
                        }
                    }
                    rollScore = board.rollScore(tetraDice)
                    //toast result
                    Toast.makeText(this, rollScore,Toast.LENGTH_LONG).show()

                    // Player 1 turn loop
                    do {

                        //TODO set onclick listener
                        p1Tile0.setOnClickListener(this)
                        p1Tile1.setOnClickListener(this)
                        p1Tile2.setOnClickListener(this)
                        p1Tile3.setOnClickListener(this)
                        p2Tile0.setOnClickListener(this)
                        p2Tile1.setOnClickListener(this)
                        p2Tile2.setOnClickListener(this)
                        p2Tile3.setOnClickListener(this)
                        Tile4.setOnClickListener(this)
                        Tile5.setOnClickListener(this)
                        Tile6.setOnClickListener(this)
                        Tile7.setOnClickListener(this)
                        Tile8.setOnClickListener(this)
                        Tile9.setOnClickListener(this)
                        Tile10.setOnClickListener(this)
                        Tile11.setOnClickListener(this)
                        p1Tile12.setOnClickListener(this)
                        p1Tile13.setOnClickListener(this)
                        p1Tile14.setOnClickListener(this)
                        p2Tile12.setOnClickListener(this)
                        p2Tile13.setOnClickListener(this)
                        p2Tile14.setOnClickListener(this)
                        P1Start.setOnClickListener(this)
                        P2Start.setOnClickListener(this)

                        tileIndex = tileSelect

                        // valid selection check
                        if (board.getSpaces(tileIndex) === PLAYER1 || board.getSpaces(tileIndex) === DOUBLE_OCCUPATION
                                || tileIndex == -1) { // starting positions

                            // find which stone to check and update
                            for (i in 0 until player1.getStones().size) {

                                if (player1.getStones(i).getLocation() === tileIndex) {

                                    stoneIndex = i
                                    // check if move is legal
                                    if (checkMove(rollScore, board, player1.getStones(stoneIndex), player1)) {
                                        //updates to board

                                        // update opponent's captured pieces
                                        capturePieces(board, player2, tileIndex, rollScore)

                                        // update space the piece is leaving
                                        updateOldLocation(board, player1, stoneIndex, tileIndex)

                                        // update stone side information
                                        player1.getStones(stoneIndex).setLocation(tileIndex + rollScore)

                                        //update space the piece is landing on
                                        updateNewLocation(board, player1, tileIndex, rollScore)

                                        //check and clear scoring space
                                        //TODO: code to update button icons


                                        if (board.getSpaces(14) !== EMPTY) {
                                            ++player1Score
                                            board.updateBoard(14, EMPTY)
                                        }

                                        turnActive = false
                                    } else { Toast.makeText(this, "That is not a legal move.",Toast.LENGTH_LONG).show()
                                        continue
                                    }
                                }
                            }
                        } else { Toast.makeText(this, "Select one of your pieces to advance.",Toast.LENGTH_LONG).show()
                            continue
                        }
                        if (board.rosette(player1.getStones(stoneIndex).getLocation())) {
                            turnActive = true
                        }
                    } while (turnActive)

                    // gameOver check
                    if (player1Score == 5) {
                        gameOver = true
                        Toast.makeText(this, "Player 1 wins!",Toast.LENGTH_LONG).show()
                    }

                    // Player 2 turn loop
                    do {

                        //TODO set onclick listener
                        p1Tile0.setOnClickListener(this)
                        p1Tile1.setOnClickListener(this)
                        p1Tile2.setOnClickListener(this)
                        p1Tile3.setOnClickListener(this)
                        p1Tile0.setOnClickListener(this)
                        p1Tile1.setOnClickListener(this)
                        p1Tile2.setOnClickListener(this)
                        p1Tile3.setOnClickListener(this)
                        Tile4.setOnClickListener(this)
                        Tile5.setOnClickListener(this)
                        Tile6.setOnClickListener(this)
                        Tile7.setOnClickListener(this)
                        Tile8.setOnClickListener(this)
                        Tile9.setOnClickListener(this)
                        Tile10.setOnClickListener(this)
                        Tile11.setOnClickListener(this)
                        p1Tile12.setOnClickListener(this)
                        p1Tile13.setOnClickListener(this)
                        p1Tile14.setOnClickListener(this)
                        p2Tile12.setOnClickListener(this)
                        p2Tile13.setOnClickListener(this)
                        p2Tile14.setOnClickListener(this)
                        P1Start.setOnClickListener(this)
                        P2Start.setOnClickListener(this)

                        // valid selection check
                        if (board.getSpaces(tileIndex) === PLAYER2 || board.getSpaces(tileIndex) === DOUBLE_OCCUPATION
                                || tileIndex == -1) { //starting position

                            // find which stone to check and update
                            for (i in 0 until player2.getStones().size) {

                                if (player2.getStones(i).getLocation() === tileIndex) {

                                    stoneIndex = i
                                    //check if move is legal
                                    if (checkMove(rollScore, board, player2.getStones(stoneIndex), player2)) {
                                        //updates to board

                                        // update opponent's captured pieces
                                        capturePieces(board, player1, tileIndex, rollScore)

                                        // update space the piece is leaving
                                        updateOldLocation(board, player2, stoneIndex, tileIndex)

                                        // update stone side information
                                        player2.getStones(stoneIndex).setLocation(tileIndex + rollScore)

                                        //update space the piece is landing on
                                        updateNewLocation(board, player2, tileIndex, rollScore)

                                        if (board.getSpaces(14) !== EMPTY) {
                                            ++player2Score
                                            board.updateBoard(14, EMPTY)
                                        }

                                        turnActive = false
                                    } else { Toast.makeText(this, "That is not a legal move.",Toast.LENGTH_LONG).show()
                                        continue
                                    }
                                }
                            }
                        } else {  Toast.makeText(this, "Select one of your pieces to advance.",Toast.LENGTH_LONG).show()
                            continue
                        }
                        if (board.rosette(player2.getStones(stoneIndex).getLocation())) {
                            turnActive = true
                        }
                    } while (turnActive)

                    // gameOver check
                    if (player2Score == 5) {
                        gameOver = true
                        Toast.makeText(this, "Player 2 wins!.",Toast.LENGTH_LONG).show()
                    }
                }
            }

            fun checkMove(rollScore: Int, board: Board, stone: Stone, player: Player): Boolean {
                var legalMove = true
                // if position plus rollscore of board = player or (!empty and rosette) or
                // > 14 then mark illegal
                if (board.getSpaces(stone.getLocation() + rollScore) === player.PLAYER_SEQUENCE || board.getSpaces(stone.getLocation() + rollScore) === DOUBLE_OCCUPATION) {

                    legalMove = false
                }
                if (board.getSpaces(stone.getLocation() + rollScore) !== 0 && stone.getLocation() + rollScore === 7) {
                    legalMove = false
                }
                if (stone.location + rollScore > board.getSpaces().size) {
                    legalMove = false
                }

                // TODO? if lands on middle track, non rosette, mark unsafe

                return legalMove
            }

            fun capturePieces(board: Board, player: Player, tileIndex: Int,
                              rollScore: Int) {
                // update any captured pieces
                if (board.getSpaces(tileIndex + rollScore) === player.getPlayerSequence() && (tileIndex + rollScore > 3 || tileIndex + rollScore < 12)) {
                    for (x in player.getStones()) {
                        //find and return captured piece to start
                        if (x.getLocation() === tileIndex + rollScore) {
                            x.setLocation(-1) // starting position value
                        }
                    }
                }
            }

            fun updateOldLocation(board: Board, player: Player, stoneIndex: Int,
                                  tileIndex: Int) {
                if ((player.getStones(stoneIndex).getLocation() < 4     // if the stone is sharing a side lane index
                                || player.getStones(stoneIndex).getLocation() > 11) && board.getSpaces(tileIndex) === DOUBLE_OCCUPATION) {
                    // maintain opposite stone information
                    board.updateBoard(tileIndex, player.getPlayerSequence() * -1)
                    // else update normally
                } else
                    board.updateBoard(tileIndex, EMPTY)
            }

            fun updateNewLocation(board: Board, player: Player, tileIndex: Int,
                                  rollScore: Int) {
                if (board.getSpaces(tileIndex + rollScore) === player.getPlayerSequence() * -1 && (tileIndex + rollScore < 4 || tileIndex + rollScore > 11)) {
                    board.updateBoard(tileIndex + rollScore, DOUBLE_OCCUPATION)
                } else {
                    board.updateBoard(tileIndex + rollScore, player.getPlayerSequence())
                }
            }
    }

