package palavras.conta.br.app.contapalavras;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import palavras.conta.br.app.contapalavras.controller.SequenciaCaracteres;

import java.util.List;
import java.util.SortedMap;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals( "palavras.conta.br.app.contapalavras",appContext.getPackageName() );
//    }

    private SequenciaCaracteres sequencia;
    private String palavra;
    private SortedMap<Integer, List<Character>> listCharacter;

    @Test
    public void contaPalavras(){
        sequencia = new SequenciaCaracteres();
        palavra = "papagaio";
        sequencia.setPalavra( palavra );
        sequencia.verificar();
        assertEquals( "papagaio", palavra );
    }

    @Test
    public void contaQuantidade(){
        sequencia = new SequenciaCaracteres();
        palavra = "corocovado";
        sequencia.setPalavra( palavra );
        sequencia.verificar();
        listCharacter = sequencia.contaQuantidade();
        assertEquals( listCharacter, sequencia.contaQuantidade() );
    }
}
