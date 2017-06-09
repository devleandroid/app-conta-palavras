# app-conta-palavras
Aplicativo Educativo para estudo do desenvolvimento em Android para contar palavras repetidas. 
Para manter os dados na tela, foi utilizado o metodo onSaveInstanceState(Bundle outState) 

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

repeticao.setText( "Palavra Repetida: " + characters );

listCharacter = sequencia.contaQuantidade();

quantidade.setText( "Quantidade que Repete: " + listCharacter );

long endTime = System.currentTimeMillis();

long timeS = endTime % 1000;

time.setText( "Tempo da Execução: " + timeS + " Milisegundos.");

}

Esta excessão é para ver se ao rotar o celular contem os dados ou não, caso seja null gera xcesão

    if (savedInstanceState != null) {
        carregarDadosTela();
        savedInstanceState.putString( "", String.valueOf( "" ) );
    } else {
        Log.i( "ERROR","Erro ao tentar recuperar dados" );
    }
