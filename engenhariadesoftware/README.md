## 📝 Atividade 1 -  13/02/2026  

### ❓ Tema  
Software é intangível.

### 📌 Conceito  

Software não é físico.  
Não pode ser tocado como um produto material.

Ele é composto por código, lógica e regras que executam instruções.

Por ser intangível:
- É mais difícil medir esforço.
- Mudanças são frequentes.
- Exige organização e método.

### ✅ Ideia principal  

> Software não é um objeto físico,  
> é um conjunto de instruções que precisa ser bem estruturado.

## 📝 Atividade 2  -  13/02/2026  

### 💡 Ideia central  

Engenharia de Software = **Programação + Tempo + Escala + Trade-offs**

Programar é fazer funcionar.  
Engenharia de software é fazer funcionar **ao longo do tempo**.

### 📌 Pontos importantes  

- **Tempo** → o sistema precisa evoluir e ser mantido.  
- **Escala** → precisa suportar crescimento de usuários e equipe.  
- **Trade-offs** → toda decisão tem custo e consequência.

### ✅ Resumo  

> Não é só entregar o sistema.  
> É garantir que ele continue funcionando no futuro.

## 📝 Atividade 3 — 20/02/2026  

Requisitos não funcionais definem **como o sistema deve funcionar**.

### 1️⃣ Desempenho  
Responder rapidamente, mesmo com muitos usuários.

### 2️⃣ Segurança  
Proteger dados e acessos.

### 3️⃣ Usabilidade  
Ser fácil de usar e intuitivo.

### 4️⃣ Confiabilidade  
Ter poucas falhas e alta disponibilidade.

### 5️⃣ Escalabilidade  
Suportar crescimento sem perder qualidade.

### ✅ Resumo  

> Requisitos não funcionais definem a qualidade do sistema.

## 📝 Atividade 4 - 20/02/2026  


Trade-offs são escolhas onde melhorar algo piora outro ponto.

### 🔒 Segurança × Desempenho
Mais segurança → sistema mais lento

**Exemplos:**
- Cloudflare: proteção contra ataques aumenta latência  
- Google (2FA): login mais seguro, porém mais demorado  



### 📈 Escalabilidade × Custo
Mais capacidade → mais caro

**Exemplos:**
- Netflix: suporta milhões, mas com alto custo  
- Startups: barato no início, mas pode cair ao crescer  



### ⚡ Qualidade × Velocidade
Mais qualidade → entrega mais lenta

**Exemplos:**
- Cyberpunk 2077: rápido, mas com bugs  
- Apple: mais lento, porém mais polido  



### 🧠 Resumo

| Trade-off                | Ganho          | Perda          |
|-------------------------|---------------|---------------|
| Segurança × Desempenho  | Proteção      | Velocidade     |
| Escalabilidade × Custo  | Crescimento   | Dinheiro       |
| Qualidade × Velocidade  | Qualidade     | Tempo          |



👉 Não existe solução perfeita, só decisões estratégicas.

### ✅ Conclusão Geral  

Desenvolver software não é apenas programar.  
É tomar decisões técnicas pensando no longo prazo.

## 📝 Atividade 5 - 23/02/2026
❓ Tema

Teste completo de entradas e análise de erro lógico.

💻 Código analisado
int blec(int j){
    j = j - 1;   // deveria ser j = j + 1
    j = j / 30000;
    return j;
}

Intervalo considerado:

-32768 até +32767
(total de 65536 valores possíveis)

Ele só altera resultados nos pontos de transição da divisão inteira:

29999 e 30000 (viram 0 em vez de 1)
-30000 e -29999 (viram -1 em vez de 0)

O erro é pequeno no valor,
mas crítico no limite da regra lógica. provando que na e possivel testar tudo
