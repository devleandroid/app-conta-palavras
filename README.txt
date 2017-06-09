Aplicativo para contar palavras repetidas

Este aplicativo foi desenvolvido com o principio didatico para se endender como funciona algumas classes, tipo Integer,
Map e SortedMap. E também para servir de exemplo de uma aplicação android com algumas funcionalidades em tela, como rota
ção de tela sem perder os dados, função de botão e como implementa-lo.

Para manter os dados na tela, foi utilizado os metodos onSaveInstanceState(Bundle outState) e o
onRestoreInstanceState(Bundle savedInstanceState)

    No exemplo do aplicativo utilizei apenas esse metodo para persistir os dados em tela quando o telefone for rotaciona
    do.

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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putString( "Palavra digitada: ",  palavra );
        sequencia = new SequenciaCaracteres();
        sequencia.setPalavra( palavra );
        sequencia.verificar();
        characters = sequencia.contaRepetidos();
        outState.putString( "Palavra Repetida: ",String.valueOf( characters ) );
        listCharacter = sequencia.contaQuantidade();
        outState.putString( "Quantidade que Repete: ", String.valueOf( listCharacter ) );
        long endTime = System.currentTimeMillis();
        long timeS = endTime % 1000;
        outState.putString( "Tempo de Execução: ", String.valueOf( timeS ) );
    }

    Esta excessão é para ver se ao rotar o celular contem os dados ou não, caso seja null gera xcesão

        if (savedInstanceState != null) {
            carregarDadosTela();
            savedInstanceState.putString( "", String.valueOf( "" ) );
        } else {
            Log.i( "ERROR","Erro ao tentar recuperar dados" );
        }


Ou podemos usar a configuração no manifest do Android para que os dados na tela sejam persistidos.

Manter dados de uma lista ao rotacionar no Android.
No arquivo AndroidManifest.xml, na declaração da sua activity adicione a seguinte linha:

Esta configuração serve para savar as informações da tela,
quando for feito a rotação do celular para modo landscape( Horizontal )
android:configChanges="orientation|screenSize"

Exemplo:

<activity
    android:name="com.example.activity.MainActivity"
    android:configChanges="orientation|screenSize"
    android:label="@string/app_name" >
</activity>
