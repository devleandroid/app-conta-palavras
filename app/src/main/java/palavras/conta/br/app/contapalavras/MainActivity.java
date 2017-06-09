package palavras.conta.br.app.contapalavras;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import palavras.conta.br.app.contapalavras.controller.SequenciaCaracteres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.Timer;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {


    private TextView text;
    private TextView repeticao;
    private TextView quantidade;
    private TextView time;
    private Button click;
    private EditText editText;

    private SequenciaCaracteres sequencia;
    private String palavra;
    private List<Character> characters;
    private SortedMap<Integer, List<Character>> listCharacter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view,"Mais informações pelo email: leandro.hdsl@gmail.com ;)",Snackbar.LENGTH_LONG )
                        .setAction( "Contato.",null ).show();
            }
        } );

        text = (TextView) findViewById( R.id.textPalavra );
        repeticao = (TextView) findViewById( R.id.textRepite );
        quantidade = (TextView) findViewById( R.id.textToString );
        time = (TextView) findViewById( R.id.textTime );
        editText = (EditText) findViewById( R.id.editText );
        click = (Button) findViewById( R.id.buttonClick );

        click.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregarDadosTela();
            }
        } );
    }

    private void carregarDadosTela(){
        palavra = editText.getText().toString();
        if (palavra == null) {
            Toast.makeText( getApplicationContext(), "Digite uma palavra !", Toast.LENGTH_LONG ).show();
        } else if(!palavra.isEmpty()){
            sequencia = new SequenciaCaracteres();
            sequencia.setPalavra( palavra );
            sequencia.verificar();
            text.setText( "Palavra Digitada: " + palavra );
            characters = sequencia.contaRepetidos();
            repeticao.setText( "Palavra Repetida: " + characters );
            //Log.d("Quantidade : ",String.valueOf( sequencia.contaQuantidade() ) );
            //Log.d("Quantidade : ",String.valueOf( sequencia.contaCaracter() ) );
            if(sequencia.contaQuantidade().size() > 0) {
                listCharacter = sequencia.contaQuantidade();
                quantidade.setText( "Quantidade que Repete: " + listCharacter );
            }
            long endTime = System.currentTimeMillis();
            long timeS = endTime % 1000;
            time.setText( "Tempo da Execução: " + timeS + " Milisegundos.");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
        palavra = editText.getText().toString();
        text.setText( "Palavra Digitada: " + palavra );
        sequencia = new SequenciaCaracteres();
        sequencia.setPalavra( palavra );
        sequencia.verificar();
        characters = sequencia.contaRepetidos();
        if (!characters.isEmpty()) {
            repeticao.setText( "Palavra Repetida: " + characters );
            listCharacter = sequencia.contaQuantidade();
            quantidade.setText( "Quantidade que Repete: " + listCharacter );
            long endTime = System.currentTimeMillis();
            long timeS = endTime % 1000;
            time.setText( "Tempo da Execução: " + timeS + " Milisegundos.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}
