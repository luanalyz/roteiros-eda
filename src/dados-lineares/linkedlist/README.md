# Identificação

* Nome: Luana Lyz Araujo Rocha 
* Email (@ccc): luana.lyz.araujo.rocha@ccc.ufcg.edu.br
* Matrícula: 123110697

# Roteiro: Implementação de DoubleLinkedList

## Material Teórico 

[LinkedList](https://joaoarthurbm.github.io/eda/posts/linkedlist/)

## O template

> Não altere o arquivo build.gradle

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/test/java/**

> Seu código é tão bom quanto seus testes.

> Eu vou executar meus testes quando você submeter.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `gradle compileJava` na raiz do projeto.

> Executando os testes: `gradle test` na raiz do projeto.

## Introdução

Este roteiro envolve a implementação das principais operações de linkedlist.

## A tarefa. 

### Implementação e testes


Implemente os métodos da classe LinkedList. A explicação do que fazer está como comentário no código. Seu objetivo é passar nos testes que disponibilizei. Sua implementação deve ser duplamente encadeada. Sugestão: implemente de maneira iterativa E recursiva o mesmo método.

Ah...confira (sempre!) se você passa nos testes: `gradle test`.

Óbvio que você pode simplesmente copiar código da Internet e colar lá. Eu mesmo disponibilizo código. Mas, conselho, assim você não aprende :)
 
## Mais estudo

Implemente os seguintes métodos na mesma classe:

* ```void moveToHead(int index)``` . Esse método move o elemento que está em index para a cabeça da fila. Ele é O(n) para procurar o elemento, mas para mover, você deve fazer em O(1), ou seja, apenas manipulando referências.

* ```void insereOrdenado(int v)```. Dada uma lista já em ordem crescente, insere o valor passado como parâmetro no seu devido lugar para que a lista continue ordenada após a sua inserção.

* ```void swap(Node n1, Node n2)```. Troca n1 e n2. Não é permitido trocar os valores. Você tem que manipular as referências. Esse algoritmo deve ser O(1), pois já recebe os nós a serem trocados.

* ```void inverte()```. Esse método deve inverter uma lista. Isto é, tail passa a ser head, o elemento anterior a tail passa a ser o segundo da lista e assim por diante, até chegar em head, que será o último elemento da lista (tail). Não é permitido utilizar estrutura auxiliar.

## Entregando o lab

> Passo 0. Modifique o arquivo README. Coloque seu nome, email @ccc e matrícula nos lugares indicados. Se você não fizer isso, não considero que sua prova foi assinada e, portanto, não vou corrigir. Não mude a formatação da linha. Apenas inclua seus dados.

> Passo 1. Certifique-se **NO TERMINAL** de que sua solução compila e passa nos testes. Isso deve ser feito com os comandos do gradle (compileJava e test).

> Passo 2. Certifique-se de que você respondeu as perguntas teóricas onde foi indicado aqui no README.

> Passo 3. Submeta as suas modificações para o repositório

  * `git pull`
  * `git commit -m "entregando o lab"`
  * `git push origin main`
