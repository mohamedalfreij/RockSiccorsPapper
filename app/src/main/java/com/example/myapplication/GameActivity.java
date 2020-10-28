package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends AppCompatActivity {

    Button stenButton, saxButton, papperButton, spelaIgenButton;
    ImageView stenCpu, saxCpu, papperCpu, stenSpelare, saxSpelare, papperSpelare;
    TextView textViewSpelare, textViewCpu, winnerLabel;

    String playerChoice = "";
    String cpuChoice = "";

    int playerScore = 0;
    int cpuScore = 0;
    int rounds = 1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        choiceButtons();
        resetGame();


    }

    public void resetGame(){

        spelaIgenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerScore = 0;
                cpuScore = 0;
                rounds = 1;

                stenButton.setEnabled(true);
                saxButton.setEnabled(true);
                papperButton.setEnabled(true);

                textViewSpelare.setText("0");
                textViewCpu.setText("0");
                winnerLabel.setText("No Winner yet");

                stenSpelare.setVisibility(View.GONE);
                saxSpelare.setVisibility(View.GONE);
                papperSpelare.setVisibility(View.GONE);
                stenCpu.setVisibility(View.GONE);
                saxCpu.setVisibility(View.GONE);
                papperCpu.setVisibility(View.GONE);

                spelaIgenButton.setEnabled(false);

            }
        });

    }

    public void calculateResult() {

        textViewSpelare = findViewById(R.id.textViewSpelare);
        textViewCpu = findViewById(R.id.textViewCpu);

        winnerLabel = findViewById(R.id.winnerLabel);

        textViewSpelare.setText(playerScore+"");
        textViewCpu.setText(cpuScore+"");


        setCpuchoice();

            if ((playerChoice =="Sten") && (cpuChoice == "Sten")) {
                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");


            }else if ((playerChoice =="Sax") && (cpuChoice == "Sax")){
                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");


            }else if ((playerChoice =="Påse") && (cpuChoice == "Påse")){
                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");


            }else if ((playerChoice =="Sten") && (cpuChoice == "Sax")){

                playerScore++;


                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");
            }else if ((playerChoice =="Sten") && (cpuChoice == "Påse")){
                cpuScore++;


                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");
            }else if ((playerChoice =="Sax") && (cpuChoice == "Sten")){
                cpuScore++;


                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");
            }else if ((playerChoice =="Sax") && (cpuChoice == "Påse")){
                playerScore++;


                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");
            }else if ((playerChoice =="Påse") && (cpuChoice == "Sax")){
                cpuScore++;


                textViewSpelare.setText(playerScore+"");
                textViewCpu.setText(cpuScore+"");
            }else if ((playerChoice =="Påse") && (cpuChoice == "Sten")){
                playerScore++;


               textViewSpelare.setText(playerScore + "");
               textViewCpu.setText(cpuScore + "");
            }

        }

    public String cpuChoice(){

        Random r = new Random();

        int randomNumber= r.nextInt(3);

        if (randomNumber+1 == 1){
            cpuChoice = "Sten";
        }else if (randomNumber+1 == 2){
            cpuChoice = "Sax";
        }else if(randomNumber+1 == 3){
            cpuChoice = "Påse";
        }
        return cpuChoice;

    }

    public void setCpuchoice() {

        cpuChoice();
        if (cpuChoice.equals("Sten")) {
            stenCpu.setVisibility(View.VISIBLE);
            saxCpu.setVisibility(View.GONE);
            papperCpu.setVisibility(View.GONE);

        } else if (cpuChoice.equals("Sax")) {
            stenCpu.setVisibility(View.GONE);
            saxCpu.setVisibility(View.VISIBLE);
            papperCpu.setVisibility(View.GONE);
        } else if (cpuChoice.equals("Påse")){
            stenCpu.setVisibility(View.GONE);
            saxCpu.setVisibility(View.GONE);
            papperCpu.setVisibility(View.VISIBLE);
        }
    }

    public void choiceButtons(){


        // Buttons
        stenButton = findViewById(R.id.stenButton);
        saxButton = findViewById(R.id.saxButton);
        papperButton = findViewById(R.id.papperButton);
        spelaIgenButton = findViewById(R.id.spelaIgenButton);
        spelaIgenButton.setEnabled(false);


        // Bilder spelare
        stenSpelare = findViewById(R.id.stenSpelare);
        saxSpelare = findViewById(R.id.saxSpelare);
        papperSpelare = findViewById(R.id.papperSpelare);

        stenSpelare.setVisibility(View.GONE);
        saxSpelare.setVisibility(View.GONE);
        papperSpelare.setVisibility(View.GONE);

        // Bilder cpu
        stenCpu = findViewById(R.id.stenCpu);
        saxCpu = findViewById(R.id.saxCpu);
        papperCpu = findViewById(R.id.papperCpu);

        stenCpu.setVisibility(View.GONE);
        saxCpu.setVisibility(View.GONE);
        papperCpu.setVisibility(View.GONE);



        stenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rounds < 7) {

                    stenSpelare.setVisibility(View.VISIBLE);
                    saxSpelare.setVisibility(View.GONE);
                    papperSpelare.setVisibility(View.GONE);
                    playerChoice = "Sten";
                    calculateResult();
                    rounds++;

                } else if (rounds == 7) {

                    stenButton.setEnabled(false);
                    saxButton.setEnabled(false);
                    papperButton.setEnabled(false);

                    spelaIgenButton.setEnabled(true);

                    stenSpelare.setVisibility(View.GONE);
                    saxSpelare.setVisibility(View.GONE);
                    papperSpelare.setVisibility(View.GONE);

                    playerChoice = "Sten";
                    calculateResult();

                    stenSpelare.setVisibility(View.VISIBLE);

                    if (cpuChoice == "Sten"){
                        stenCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Sax"){
                        saxCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Påse"){
                        papperCpu.setVisibility(View.VISIBLE);
                    }

                    if (playerScore > cpuScore) {
                        winnerLabel.setText("Human Won !");
                    } else if (cpuScore > playerScore) {
                        winnerLabel.setText("Computer Won !");
                    } else if (cpuScore == playerScore) {
                        winnerLabel.setText("Draw, Try again");
                    }
                    spelaIgenButton.setEnabled(true);


                }
            }
        });
        saxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rounds < 7) {

                    stenSpelare.setVisibility(View.GONE);
                    saxSpelare.setVisibility(View.VISIBLE);
                    papperSpelare.setVisibility(View.GONE);
                    playerChoice = "Sax";
                    calculateResult();
                    rounds++;

                } else if (rounds == 7) {

                    stenButton.setEnabled(false);
                    saxButton.setEnabled(false);
                    papperButton.setEnabled(false);

                    stenSpelare.setVisibility(View.GONE);
                    saxSpelare.setVisibility(View.GONE);
                    papperSpelare.setVisibility(View.GONE);

                    playerChoice = "Sax";
                    calculateResult();

                    saxSpelare.setVisibility(View.VISIBLE);

                    if (cpuChoice == "Sten"){
                        stenCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Sax"){
                        saxCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Påse"){
                        papperCpu.setVisibility(View.VISIBLE);
                    }

                    if (playerScore > cpuScore) {
                        winnerLabel.setText("Human won !");
                    } else if (cpuScore > playerScore) {
                        winnerLabel.setText("Computer won !");
                    } else if (cpuScore == playerScore) {
                        winnerLabel.setText("Draw, Try again !");
                    }
                    spelaIgenButton.setEnabled(true);

                }
            }

        });
        papperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rounds < 7) {

                    stenSpelare.setVisibility(View.GONE);
                    saxSpelare.setVisibility(View.GONE);
                    papperSpelare.setVisibility(View.VISIBLE);
                    playerChoice = "Påse";
                    calculateResult();
                    rounds++;

                } else if (rounds == 7) {

                    stenButton.setEnabled(false);
                    saxButton.setEnabled(false);
                    papperButton.setEnabled(false);

                    stenSpelare.setVisibility(View.GONE);
                    saxSpelare.setVisibility(View.GONE);
                    papperSpelare.setVisibility(View.GONE);

                    playerChoice = "Påse";
                    calculateResult();

                    papperSpelare.setVisibility(View.VISIBLE);
                    if (cpuChoice == "Sten"){
                        stenCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Sax"){
                        saxCpu.setVisibility(View.VISIBLE);
                    }else if (cpuChoice == "Påse"){
                        papperCpu.setVisibility(View.VISIBLE);
                    }

                    if (playerScore > cpuScore) {
                        winnerLabel.setText("Human Won !");
                    } else if (cpuScore > playerScore) {
                        winnerLabel.setText("Computer Won !");
                    } else if (cpuScore == playerScore) {
                        winnerLabel.setText("Draw, Try again !");
                    }
                    spelaIgenButton.setEnabled(true);

                }
            }
        });

    }
}
