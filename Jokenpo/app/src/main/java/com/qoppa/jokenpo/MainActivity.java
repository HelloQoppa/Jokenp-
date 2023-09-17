package com.qoppa.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void verificarGanhador(String escolhaDoUsuario) {
        System.out.println("Item Clicado: " + escolhaDoUsuario);

        String escolhaDoApp = gerarEscolhaAleatoriaDoApp();

        TextView textViewResultado = findViewById(R.id.textViewResultado);

        if (
                (escolhaDoUsuario.equals("pedra") && escolhaDoApp.equals("tesoura")) ||
                        (escolhaDoUsuario.equals("papel") && escolhaDoApp.equals("pedra")) ||
                        (escolhaDoUsuario.equals("tesoura") && escolhaDoApp.equals("papel"))


        ) {
            textViewResultado.setText("Ganhou");
        } else if (
                (escolhaDoApp.equals("pedra") && escolhaDoUsuario.equals("tesoura")) ||
                        (escolhaDoApp.equals("papel") && escolhaDoUsuario.equals("pedra")) ||
                        (escolhaDoApp.equals("tesoura") && escolhaDoUsuario.equals("papel"))
        ) {
            textViewResultado.setText("Perdeu");

        }else {
            textViewResultado.setText("Empatou");
        }

    }

    private String gerarEscolhaAleatoriaDoApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int random = new Random().nextInt(3);

        String escolhaApp = opcoes[random];

        ImageView imageApp = findViewById(R.id.image_app);

        switch (escolhaApp) {
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    public void selecionarPedra(View view) {
        this.verificarGanhador("pedra");
    }


    public void selecionarPapel(View view) {
        this.verificarGanhador("Papel");

    }

    public void selecionarTesoura(View view) {
        this.verificarGanhador("Tesoura");

    }
}