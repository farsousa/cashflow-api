﻿# Cashflow API
## Regras de Negócio
Cashflow deve ser um aplicativo para gerenciar finanças pessoais. Nele, deve ser possível inserir carteiras (Dinheiro, Cartão de Crédito,...) e seus respectivos saldos. Após isso, deve ser possível inserir atividades de entrada ou saída de dinheiro para uma dessas carteiras. Ao inserir atividades de entrada, o seu valor deve ser acrescido do saldo da respectiva carteira. Ao inserir atividade de saída, o valor deve ser descontado do saldo da respectiva carteira. Ao final, deve ser disponibilizado estatísticas dos gastos a nível mensal.
## Modelos
Usuário (nome, email, senha)

Carteira (descricao, saldo)

Atividade (descricao, valor, data de previsão, data de efetivação, status, tipo, carteira)

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
### R2 - Listagem de carteiras
### R3 - Exclusão de carteira por id
### R3 - Edição de carteira por id
### R3 - Busca de carteira por id
