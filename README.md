# PedidoFácil

## Alunos
**Arthur Riquieri Campos - 838656**
**Fernando Yudi Yaginuma - 837755**
**Igor Bianchini Ulian - 837782**
**Vinícius Corrêa Goulart Silva - 838641**

## 1. Tema Escolhido
**Sistema de Pedidos Online**

---

## 2. Arquitetura Geral
- **Camadas**:  
  UI → Facade → Services → Models → Repositórios (em memória)  
- **Diagrama Simplificado**:
  [UI] ↔ [PedidoFacade] ↔ [PedidoService, PagamentoService, ClienteService] ↔ [Modelos, Repositórios]

---

## 3. Padrões de Projeto Aplicados

### 3.1 Strategy
- **O que é**: Formas de pagamento encapsuladas em classes que implementam `PagamentoStrategy`.  
- **Onde está**:  
- `PagamentoCartao`  
- `PagamentoBoleto`  
- `PagamentoPix`  
- **Por quê**:  
- Evita condicionais gigantes dentro de `PagamentoService`.  
- Facilita adição de novas estratégias (ex.: `PagamentoPayPal`) sem alterar classes existentes.

### 3.2 Prototype
- **O que é**: Permite “duplicar” um pedido existente com `Pedido.clone()`.  
- **Onde está**:  
- Classe `Pedido` implementa `Cloneable`.  
- Método `clone()` cria cópia profunda dos produtos e atribui novo ID ao pedido.  
- **Por quê**:  
- Evita recriação manual de todos os itens do pedido.  
- Facilita a repetição de compras frequentes (pedidos recorrentes).

### 3.3 Facade
- **O que é**: Uma classe que esconde a complexidade de vários serviços e repositórios por trás de métodos de alto nível.  
- **Onde está**:  
- `PedidoFacade` expõe operações como:  
  1. `criarPedidoParaCliente(long clienteId)`  
  2. `adicionarProdutoAoPedido(Pedido pedido, Produto produto)`  
  3. `duplicarPedido(long pedidoId)`  
  4. `finalizarPedidoComPagamento(long pedidoId, PagamentoStrategy strategy)`  
- **Por quê**:  
- Unifica operações de criação de pedido, persistência e pagamento em uma API simples para a camada de UI.  
- Melhora a manutenibilidade e reduz o acoplamento direto entre UI e serviços internos.

---

## 4. Justificativas Detalhadas

1. **Strategy**  
 - Evita condicionais (`if/else`) dentro de `PagamentoService`.  
 - Cada método de pagamento (“Cartão”, “Boleto”, “Pix”) está isolado em sua própria classe.  
 - Facilita testes unitários específicos de cada estratégia (`PagamentoCartaoTest`, etc.).  

2. **Prototype**  
 - Método `clone()` em `Pedido` faz cópia profunda de `List<Produto>`.  
 - Gera novo ID automaticamente, mantendo o pedido “original” imutável.  
 - Mostra como usar `Cloneable` para duplicação de objetos complexos.  

3. **Facade**  
 - `PedidoFacade` reúne chamadas a `PedidoService`, `PagamentoService` e `ClienteService`.  
 - A camada de apresentação (linha de comando ou outra interface) não precisa saber detalhes de como cada serviço funciona.  
 - Qualquer alteração interna (ex.: trocar repositório em memória por JPA) não afeta diretamente a UI.

---

## 5. Considerações Finais
- **Expansibilidade**  
- Com **Strategy**, você pode criar `PagamentoPayPal`, `PagamentoTransferenciaBancaria`, etc., sem modificar `PagamentoService`.  
- O **Prototype** facilita pedidos recorrentes sem escrever código de cópia manual.  

- **Manutenibilidade**  
- Em um projeto real, os repositórios ficariam em banco de dados (JPA, Hibernate) e haveria injeção de dependência (Spring, Guice). Aqui, tudo é em memória e instanciado manualmente para fins didáticos.  
- O **Facade** já deixa claro onde trocar a implementação de persistência (basta alterar `PedidoService` e `ClienteService`).  

- **Qualidade de Código**  
- Pacotes bem organizados: `model`, `service`, `strategy`, `facade`, `repository`.  
- Cada classe segue o princípio da responsabilidade única.  
- Tratamento de exceções mínimo garantido (por exemplo, no uso de `clone()` e nos serviços).  

- **Testes Unitários**  
- Recomenda-se criar testes para cada `PagamentoStrategy` (ex.: `PagamentoCartaoTest`).  
- Testar `Pedido.clone()` para garantir que a lista de produtos seja realmente copiada, não apenas referenciada.  

---

## 6. Como Executar
1. **Clonar repositório**  
 ```bash
 git clone https://github.com/seu-usuario/PedidoFacil.git
 cd PedidoFacil
```
2. **Compilar**  
 ```bash
 javac -d bin com.pedidofacil/src/**/*.java
```
3. **Executar**
 ```bash
 java -cp bin pedidofacil.Main
```

--- 

## 7. Diagrama de Classes (UML Simplificado)
![Diagrama de classes](https://github.com/user-attachments/assets/3f79b5fb-5e59-4c09-9365-d6ed8d161041)

