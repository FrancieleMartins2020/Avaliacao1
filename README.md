
# Cálculo Paralelo de π com Threads em Java

Este projeto foi desenvolvido para a disciplina **Fundamentos de Programação Concorrente** da UTFPR - Campus Toledo, como parte da **1ª Avaliação**.

## 🧠 Objetivo

Compreender o conceito de **threads** e como utilizá-las para aproveitar melhor os recursos de processamento modernos.
O programa implementa três versões distintas para calcular o valor de π usando a **série de Leibniz-Grégory**:

![image](https://github.com/user-attachments/assets/7c3a9179-0c30-41f3-b19e-81049923098a)

## 📌 Requisitos Atendidos

- ✅ Versão Serial
- ✅ Versão Paralela com objeto **não compartilhado** entre as threads
- ✅ Versão Paralela com objeto **compartilhado e sincronizado**
- ✅ Cálculo com até **1 bilhão (10⁹)** de termos da série
- ✅ Uso de `double` (precisão dupla)
- ✅ Execução com 1, 2, 4, 8 e 16 threads
- ✅ Cálculo do **tempo médio** e **desvio padrão** com 3 amostragens
- ✅ Geração de gráfico comparativo

## 📊 Resultados de Execução

### 🔵 Versão Serial

```text
==== Versão Serial ====
Tempo médio: 35088 ms
Valor aproximado de PI: 3.1415926525880504
Desvio padrão: 363 ms
```

### 🟢 Versão Paralela (Objeto Não Compartilhado)

```text
==== Versão Paralelo sem objeto compartilhado ====
==== Threads: 1 ====
Tempo médio: 33527 ms
Valor aproximado de PI: 3.1415926525880504
Desvio padrão: 50 ms

==== Threads: 2 ====
Tempo médio: 23195 ms
Valor aproximado de PI: 3.141592652589258
Desvio padrão: 4802 ms

==== Threads: 4 ====
Tempo médio: 23309 ms
Valor aproximado de PI: 3.1415926525892104
Desvio padrão: 1833 ms

==== Threads: 8 ====
Tempo médio: 14742 ms
Valor aproximado de PI: 3.141592652589324
Desvio padrão: 1798 ms

==== Threads: 16 ====
Tempo médio: 11686 ms
Valor aproximado de PI: 3.141592652590205
Desvio padrão: 222 ms
```

### 🟡 Versão Paralela (Objeto Compartilhado e Sincronizado)

```text
==== Versão Paralelo com objeto compartilhado ====
==== Threads: 1 ====
Tempo médio: 34624 ms
Desvio padrão: 167 ms

==== Threads: 2 ====
Tempo médio: 17426 ms
Desvio padrão: 45 ms

==== Threads: 4 ====
Tempo médio: 9175 ms
Desvio padrão: 12 ms

==== Threads: 8 ====
Tempo médio: 5645 ms
Desvio padrão: 18 ms

==== Threads: 16 ====
Tempo médio: 3790 ms
Desvio padrão: 93 ms
```

---

## 📈 Gráfico Comparativo

O gráfico abaixo compara os **tempos médios de execução** entre as 3 versões:

* 📘 **Serial**
* 🟢 **Paralelo sem compartilhamento**
* 🟡 **Paralelo com compartilhamento sincronizado**

![image](https://github.com/user-attachments/assets/9a6f280a-d3a5-4eaf-ab68-e97988d2a0fb)

![image](https://github.com/user-attachments/assets/8d129b99-6d4f-41e8-9cd2-40f12143b071)


---

## 📂 Estrutura do Projeto

```
├── SerialCalculoPi/
│   └── Main.java
├── ParaleloCalculoPi/
│   ├── Main.java
│   └── ParaleloCalculoPi.java
├── ParaleloComObjCompartilhadoCalculoPi/
│   ├── Main.java
│   ├── ParaleloComObjCompartilhadoCalculoPi.java
│   └── SomaCompartilhada.java
├── Grafico/
│   └── GraficoComparativo.java
├── README.md
```

---

## ⚙️ Tecnologias Utilizadas

* **Java 17**
* **Maven** (gerenciador de dependências)
* **JFreeChart** (para geração de gráficos)
* **Java Swing** (interface gráfica com JFrame/ChartPanel)

---

## 📝 Instruções de Execução

1. Compile os arquivos:

   ```bash
   javac -cp ".;libs/jfreechart-1.5.3.jar;libs/jcommon-1.0.23.jar" */*.java
   ```

2. Execute qualquer versão:

   ```bash
   java -cp ".;libs/jfreechart-1.5.3.jar;libs/jcommon-1.0.23.jar" ParaleloCalculoPi.Main
   ```

3. Para exibir o gráfico comparativo:

   ```bash
   java -cp ".;libs/jfreechart-1.5.3.jar;libs/jcommon-1.0.23.jar" Grafico.ComparadorPi
   ```
---

## 👨‍💻 Autor

* **Franciele Lemos Martins**
* **RA: 1111183**
* **Disciplina: Fundamentos de Programação Concorrente**
* **Professor: Edson Tavares de Camargo**

---

### 📚 Referências e Inspiração

Este projeto foi desenvolvido com base em conceitos aprendidos em aula e também com apoio de estudos em repositórios públicos. 
Agradecimentos aos autores das implementações a seguir, que serviram como referência:

* 📌 [ufrn-concprog/pi-leibniz](https://github.com/ufrn-concprog/pi-leibniz/blob/master/src/SumAggregator.java): Referência para controle de soma e divisão de tarefas entre threads.
* 📌 [Adam-Cr42/Calculo-de-pi-usando-threads---java](https://github.com/Adam-Cr42/Calculo-de-pi-usando-threads---java/blob/main/main.java): Exemplo de paralelismo aplicado à série de Leibniz.
* 📌 [Lucasmtsoares/Thread-Com-Java](https://github.com/Lucasmtsoares/Thread-Com-Java): Referência geral para criação e controle de múltiplas threads em Java.

As referências foram utilizadas apenas como apoio conceitual e a implementação entregue foi feita de forma autoral, conforme as diretrizes da avaliação.
