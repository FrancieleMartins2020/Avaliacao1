````markdown
# Cálculo Paralelo de π com Threads em Java

Este projeto foi desenvolvido para a disciplina **Fundamentos de Programação Concorrente** da UTFPR - Campus Toledo, como parte da **1ª Avaliação**.

## 🧠 Objetivo

Compreender o conceito de **threads** e como utilizá-las para aproveitar melhor os recursos de processamento modernos. O programa implementa três versões distintas para calcular o valor de π usando a **série de Leibniz-Grégory**:

\[
\frac{π}{4} = 1 - \frac{1}{3} + \frac{1}{5} - \frac{1}{7} + \frac{1}{9} - ...
\]

## 📌 Requisitos Atendidos

- ✅ Versão Serial
- ✅ Versão Paralela com objeto **não compartilhado** entre as threads
- ✅ Versão Paralela com objeto **compartilhado e sincronizado**
- ✅ Cálculo com até **1 bilhão (10⁹)** de termos da série
- ✅ Uso de `double` (precisão dupla)
- ✅ Execução com 1, 2, 4, 8 e 16 threads
- ✅ Cálculo do **tempo médio** e **desvio padrão** com 3 amostragens
- ✅ Geração de gráfico comparativo

---

## 📊 Resultados de Execução

### 🔵 Versão Serial

```text
==== Versão Serial ====
Tempo médio: 35088 ms
Valor aproximado de PI: 3.1415926525880504
Desvio padrão: 363 ms
````

### 🟢 Versão Paralela (Objeto Não Compartilhado)

```text
==== Versão Paralelo sem objeto compartilhado ====
==== Threads: 1 ====
Tempo médio: 3359 ms
Valor aproximado de PI: 3.141592643589326
Desvio padrão: 1 ms

==== Threads: 2 ====
Tempo médio: 2359 ms
Valor aproximado de PI: 3.1415926435902506
Desvio padrão: 479 ms

==== Threads: 4 ====
Tempo médio: 2499 ms
Valor aproximado de PI: 3.141592643589817
Desvio padrão: 350 ms

==== Threads: 8 ====
Tempo médio: 1936 ms
Valor aproximado de PI: 3.1415926435898798
Desvio padrão: 9 ms

==== Threads: 16 ====
Tempo médio: 1109 ms
Valor aproximado de PI: 3.141592643589896
Desvio padrão: 8 ms
```

### 🟡 Versão Paralela (Objeto Compartilhado e Sincronizado)

```text
==== Versão Paralelo com objeto compartilhado ====
==== Threads: 1 ====
Tempo médio: 34641 ms
Desvio padrão: 232 ms

==== Threads: 2 ====
Tempo médio: 17389 ms
Desvio padrão: 39 ms

==== Threads: 4 ====
Tempo médio: 9039 ms
Desvio padrão: 110 ms

==== Threads: 8 ====
Tempo médio: 5454 ms
Desvio padrão: 57 ms

==== Threads: 16 ====
Tempo médio: 3464 ms
Desvio padrão: 17 ms
```

---

## 📈 Gráfico Comparativo

O gráfico abaixo compara os **tempos médios de execução** entre as 3 versões:

* 📘 **Serial**
* 🟢 **Paralelo sem compartilhamento**
* 🟡 **Paralelo com compartilhamento sincronizado**

**\![image](https://github.com/user-attachments/assets/355a5ba6-205e-42f9-9d61-344ae1c36b03)
**
![image](https://github.com/user-attachments/assets/ed57aa6d-48c2-4c9c-bc93-47d0c08edab0)

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

**\Franciele Lemos Martins**
RA: **\1111183**
Disciplina: Fundamentos de Programação Concorrente
Professor: **\ Edson Tavares de Camargo**
