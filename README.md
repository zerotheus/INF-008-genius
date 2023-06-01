# INF-008-genius

<H1>Uso do git</H1>

<H2>Iniciando repositorio</H2>

<p>Vá na pasta que voce deseja acessar e faça:<br>
git init<br>
git remote add origin git@github.com:zerotheus/INF-008-genius.git<br>
git pull
</p>

<p>Usuarios de eclipse estou enviando somente os codigos fontes recomendo enviarmos somente o conteudo de src, os arquivos que o eclipse ide esconde de voce nao devem ser commitados</p>

<H2>Uso continuo<H2>

<p>Nao faça git add ., use git add nomeArquivoModificado.java , adicione pequenas modificacoes e faça git commit -m "messagem", quando terminar faça git push origin, sempre faça pull antes de começar modificar o codigo, evita conflitos</p>

<H1>Especificações</H1>

<p>Neste trabalho você implementará (usando obrigatoriamente a linguagem Java) um sistema que organize um
campeonato do Jogo GÊNIUS. O sistema deve permitir que mais de um jogador dispute um campeonato. A
cada rodada devem ser computados e exibidos os pontos(totais e da rodada) de cada Jogador. Um jogador
deve jogar até errar sua sequência e depois passar a vez. Em caso de empate, uma rodada extra deve ser
sugerida pelo sistema para os jogadores empatados e isso deve se repetir até que um jogador vença. No fim
do campeonato deve ser possível imprimir um relatório onde sejam contemplados os campos :tempo total de
jogadas de cada jogador, Total de pontos, Nome, Apelido, Data do Campeonato, Título do Campeonato e
Jogada mais rápida de cada jogador</p>

<H2>Como jogar</H2>

<p>O GENIUS é um jogo de memória visual e sonora, com 3 níveis de velocidade e 3 de dificuldade.
- Na primeira jogada, uma cor com o som correspondente vai acender aleatoriamente no seu jogo. Você
precisa clicar novamente em cima dela, repetindo o que o jogo faz.
- A cada jogada, o GENIUS acende uma luz e emite um som a mais, formando uma sequência cada vez maior,
que deve ser sempre repetida pelo jogador.
- Se você errar a repetição, o jogo termina.
- Se você desejar, o jogo pode ser interrompido e retomado posteriormente do mesmo ponto.</p>

<H2>Dificuldade e velocidade</H2>

<p>Para aumentar ou diminuir o grau de dificuldade e a velocidade, o jogador dispõe de dois botões azuis no
centro de GENIUS.
Com o botão da esquerda você regula os 3 níveis de dificuldade. Com o botão da direita, você escolhe o
ritmo do jogo, com 3 opções de velocidade.</p>

<H2>Para Começar</H2>

<p>Vá com o cursor do mouse até o botão verde no centro de GENIUS e clique sobre ele.
Serão avaliados no trabalho itens como criatividade, implementação de funcionalidades extra, prazo,
documentação etc. Trabalho iguais ou copiados de alguma fonte terão nota Zero. Todos os trabalhos
deverão ser apresentados no Laboratório.</p>

<H1>Documentacao de desenvolvimento</H1>
<p>Os commits ajudam muito a entender oq mudou no codigo mas nem sempre sao o bastante, entao qualquer coisa que precise de mais do que um commit -m "mensagem" pode ser escrita aqui</p>