Nome do problema: 11631 – Dark roads  

Link do problema: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2678  

Integrantes do grupo: Gabriel Rangel Lustosa & Davi Lima de Oliveira Rocha.  

Linguagem utilizada: Java.  

Como executar a solução: Clicar em Run dentro no Main e modificar os dados dentro do arquivo .txt para diferentes resultados.  

Explicação da modelagem: Acessando a biblioteca algs4 na linguagem Java e montando com o intuito de resolver o problema e que trabalhe MST(Minimum Spanning Tree ou Árvore Geradora Mínima).  

Algoritmo utilizado: Kruskal, também foi usado PRIM para fins de comparação.  

Papel do Union-Find/DSU: O papel principal do Union-Find no Kruskal é detectar ciclos de forma quase instantânea e gerenciar a união dos componentes do grafo à medida que as arestas são adicionadas.  

Análise de complexidade: **E log E** 

Casos especiais relevantes do problema:  

- **Vértices Isolados ou Componentes Desconexos**:  
    **O Cenário**: O que aconteceria se a entrada do problema contivesse cidades/cruzamentos que não possuem nenhuma rua conectando-os ao resto do mapa?  

    **Impacto no Kruskal**: O Kruskal naturalmente criaria uma Floresta Geradora Mínima (múltiplas árvores isoladas). O algoritmo terminaria de rodar sem dar erro, mas a árvore não conteria todos os vértices.  

    **No contexto do problema**: A especificação do problema garante que o grafo original é totalmente conectado (sempre existe pelo menos um caminho iluminado entre quaisquer duas junções). Portanto, você não precisa se preocupar em validar se sobrou algum componente isolado no final.  

- Grafos com Múltiplas Arestas entre os Mesmos Vértices (Multigrafo):  
    **O Cenário**: Duas junções $u$ e $v$ possuem mais de uma rua conectando-as diretamente, cada uma com um custo de iluminação diferente.

    **Como o Kruskal resolve**: O Kruskal lida com isso de forma brilhante e automática. Como ele ordena todas as arestas no início, a rua com o menor custo entre $u$ e $v$ será processada primeiro. O Union-Find vai aceitar essa primeira rua na MST (unindo os componentes de $u$ e $v$). Quando o laço do Kruskal chegar nas outras ruas mais caras entre esses mesmos dois vértices, o find(u) e find(v) indicarão que eles já estão no mesmo conjunto, e o Union-Find irá rejeitar as arestas redundantes automaticamente.

- Arestas com Pesos Iguais (Empates)  
    **O Cenário**: Várias ruas têm exatamente o mesmo custo de iluminação. Qual delas o algoritmo deve escolher primeiro?
  
    **Impacto no Kruskal**: Quando há pesos iguais, a ordenação (feita pelo Arrays.sort ou pela PriorityQueue) pode colocar essas arestas em qualquer ordem.
  
    **Propriedade da MST**: Isso significa que o problema pode ter múltiplas MSTs válidas com formatos diferentes. Contudo, a propriedade matemática das árvores geradoras garante que, independentemente de qual aresta de peso igual for escolhida primeiro, o peso total final da MST será exatamente o mesmo. Como o problema só pede o valor da economia ($total - mstWeight$), qualquer critério de desempate gerará a resposta correta.  

Imagem que comprova Accepted:  
![Evidencia](https://github.com/GRLERIK/T1-MST/blob/main/T1-MST/evidencias/Captura%202026-05-24%20Compara%C3%A7%C3%A3o.png)
