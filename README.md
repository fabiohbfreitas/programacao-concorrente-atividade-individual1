# Programação concorrente - Trabalho Individual 1

## Sistema bancário utilizando Threads

### Entidades
- **Bank:** Responsável por transferir corretamente o dinheiro entre contas distintas
- **Account:** Responsável por manter o valor que uma determinada entidade com conta possui no banco
- **Store:** Reponsável por utilizar o banco para transferir da conta do cliente para sua própria conta
- **Employee:** Recebe o salário em uma conta e transfere 20% para uma conta de investimentos
- **Client:** Quem utiliza a loja para fazer compras

### Funcionamento Geral do sistema
- O Sistema possui 1 Bank, 2 Stores com 2 Employees cada (4 funcionário ao total) e 5 Clients.
- Store e Client possuem somente uma Account. Employee possuem uma conta para recebimento de salário e outra para investimentos
- O Saldo inicial da Account dos Clients é 1000 e dos demais é 0.
- Clients e Employees são threads, ou seja, além da thread principal existem 7 outras threads.
- A tarefa dos Clients é escolher aleatoriamente uma Store e realizar uma compra de 100 ou 200 até que o saldo na sua conta seja 0.
- Stores receberão compras de multiplos clientes e assim que possuírem pelo menos 1400 em sua conta farão o pagamento de seus Employees.
- A tarefa dos Employees é verificar se sua conta recebeu o pagamento, caso sim, transferir 20% para a conta de investimentos.
- Após todos os clientes ficarem com balanço 0, o banco será informado que as transações finalizaram e os Employees podem encerrar suas tarefas.
- Nem todos os Employees receberão seu salário.
- A soma do saldo de todas as contas do sistema é 5000 (1000 por cliente).
