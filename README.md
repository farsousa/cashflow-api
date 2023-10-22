# Cashflow API
## Regras de Negócio
Cashflow deve ser um aplicativo para gerenciar finanças pessoais. Nele, deve ser possível inserir carteiras (Dinheiro, Poupança, Conta Corrente, Cartão de Crédito, Cartão de Débito...) e seus respectivos saldos. Após isso, deve ser possível inserir atividades de entrada ou saída de dinheiro para uma dessas carteiras. Ao inserir atividades de entrada, o seu valor deve ser acrescido do saldo da respectiva carteira. Ao inserir atividade de saída, o valor deve ser descontado do saldo da respectiva carteira. Ao final, deve ser disponibilizado estatísticas dos gastos a nível mensal.
## Modelos
Usuário (nome, email, senha)

Carteira (descricao, saldo, user)

Atividade (descricao, valor, data de previsão, data de efetivação, status, tipo, carteira, user)

## Observaçoes
- O status de uma atividade consiste em PENDENTE ou EFETIVADA.
- O tipo de uma atividade consite em ENTRADA ou SAÍDA.
- Os modelos devem ter também os atributos:
  - id (para identificar o registro de forma única)
  - deletado (para exclusão lógica)
  - data de exclusão (para saber a data em que o registro foi excluído)
  - data de criação (para saber a data em que o registro foi inserido)
  - data de atualização (para saber a ultima data em que o registro foi modificado)
## Requisitos
### R1 - Cadastro de carteiras
Para cadastrar uma carteira, será necessário informar uma descrição e o saldo referente a ela.
### R2 - Listagem de carteiras
O aplicativo deve listar todas as carteiras de forma paginada com um size default de 10 itens e um page default de 0.
### R3 - Exclusão de carteira por id
Para excluir uma carteira, será necessário informar o seu respectivo id. E nesta ação, o atributo horário de exclusão deve ser preenchido com o horário do momento.
### R3 - Edição de carteira por id
Para alterar uma carteira, será necessário informar o seu respectivo id e a nova descrição. Não será possível alterar o saldo da carteira, pois isso somente será inserido no seu cadastro e alterado por meio de atividades de entrada ou saída informadas. E nesta ação, o atributo horário de alteração deve ser preenchido com o horário do momento.
### R3 - Busca de carteira por id
Para buscar uma carteira, é necessário informar o seu respectivo id.
