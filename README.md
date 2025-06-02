Com base no conteúdo do PDF da avaliação da disciplina **Fundamentos de Programação Concorrente**, aqui está um modelo de `README.md` pronto para você usar no GitHub, estruturado de forma clara e objetiva:

---

```markdown
# Cálculo de π com Threads em Java

Este repositório contém a implementação de um programa em Java para calcular o valor de π (Pi) utilizando a **série de Leibniz-Grégory**, com diferentes abordagens:

- ✅ Versão **serial** 
- ✅ Versão **paralela**

Este projeto foi desenvolvido como parte da **1ª Avaliação** da disciplina _Fundamentos de Programação Concorrente_ da **UTFPR – Campus Toledo**.

---

## 📌 Objetivo

O objetivo principal é compreender o conceito de **threads** em Java e como elas podem ser usadas para explorar o paralelismo em aplicações que realizam cálculos intensivos.

A aplicação calcula o valor aproximado de π utilizando a seguinte série:

![image](https://github.com/user-attachments/assets/d8e37307-1793-423a-89c5-ca40ff2fa8ff)


---

## 🧪 Cenários Experimentais

Foram realizados testes com **1, 2, 4, 8 e 16 threads**, para até **10⁹ termos da série**, com os seguintes critérios:

- Cada thread calcula uma **soma parcial** da série;
- O tempo de execução é medido em milissegundos;
- Para cada cenário, foram feitas **3 repetições**;
- O programa calcula o **tempo médio** e o **desvio padrão** para cada quantidade de threads;
- Os resultados são apresentados em console e documentados em **gráfico em PDF**.

---

## 🗂 Estrutura do Projeto

```

.
├── serial/                      # Implementação serial (sem threads)
│   ├── Main.java
│   └── SerialLeibniz.java
│
├── paralelo-nao-compartilhado/ # Threads com objetos independentes
│   ├── Main.java
│   └── ParaleloLeibniz.java
│
├── paralelo-compartilhado/     # Threads compartilhando objeto com synchronized
│   ├── Main.java
│   └── ParaleloLeibnizShared.java
│
├── grafico.pdf                 # Gráfico de desempenho gerado
└── README.md                   # Este arquivo

````

---

## 🧵 Versões Implementadas

- **Serial**: cálculo realizado de forma sequencial, sem threads.
- **Paralela (sem compartilhamento)**: cada thread tem seu próprio objeto e calcula uma parte da série.
- **Paralela (com compartilhamento)**: todas as threads compartilham um objeto sincronizado com `synchronized`.

---

## 📊 Gráfico de Desempenho

O arquivo `grafico.pdf` mostra o tempo de execução médio em função do número de threads utilizadas (1, 2, 4, 8, 16), para 10⁸ ou 10⁹ termos.

---

## 🧑‍💻 Como Executar

1. Compile os arquivos Java:

```bash
javac Main.java NomeDaClasseDeThread.java
````

2. Execute com o número desejado de threads (quando aplicável):

```bash
java Main
```

---

## 📃 Avaliação

Critérios observados:

* Sintaxe e semântica;
* Organização e clareza do código;
* Uso correto de tipos, classes e métodos;
* Sincronização com `synchronized` nas versões compartilhadas;
* Medição precisa de tempo com `System.currentTimeMillis()`;
* Geração de gráfico com base nos tempos obtidos.

---

## 🧑‍🏫 Disciplina

* **Nome**: Fundamentos de Programação Concorrente
* **Professor**: 
* **Universidade**: UTFPR – Campus Toledo
* **Ano**: 2025

---

## ⚠️ Aviso

Este projeto foi desenvolvido exclusivamente para fins educacionais, como parte de uma avaliação individual. Cópias ou plágio são proibidos conforme as regras da disciplina.
