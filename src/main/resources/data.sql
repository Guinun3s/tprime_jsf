INSERT INTO cliente (nome, cpf, data_nascimento, email, telefone, endereco, divida) VALUES
('João Silva', '123.456.789-00', '1980-01-01', 'joao.silva@example.com', '(11) 98765-4321', 'Rua A, 123', 500.00),
('Maria Souza', '987.654.321-00', '1990-02-02', 'maria.souza@example.com', '(21) 87654-3210', 'Avenida B, 456', 300.00),
('Carlos Pereira', '456.789.123-00', '1985-03-03', 'carlos.pereira@example.com', '(31) 76543-2109', 'Travessa C, 789', 150.00),
('Ana Costa', '321.654.987-00', '1995-04-04', 'ana.costa@example.com', '(41) 65432-1098', 'Praça D, 101', 200.00),
('Pedro Lima', '654.321.987-00', '2000-05-05', 'pedro.lima@example.com', '(51) 54321-0987', 'Alameda E, 202', 250.00);

INSERT INTO produto (nome, valor) VALUES
('Arroz', 10.00),
('Feijão', 5.00),
('Macarrão', 3.00),
('Carne', 20.00),
('Frango', 15.00);

INSERT INTO compra (data_compra, situacao, valor, id_cliente_fk, id_produto_fk) VALUES
('2021-01-01', false, 550.00, 1, 1),
('2021-02-02', false, 400.00, 2, 2),
('2021-03-03', false, 450.00, 3, 3),
('2021-04-04', false, 400.00, 4, 4),
('2021-05-05', false, 500.00, 5, 5);

INSERT INTO pagamento (data_pagamento, forma_pagamento, valor, id_pagamento_fk) VALUES
('2021-01-01', 'Cartão', 50.00, 1),
('2021-02-02', 'Boleto', 100.00, 2),
('2021-03-03', 'Dinheiro', 150.00, 3),
('2021-04-04', 'Cartão', 200.00, 4),
('2021-05-05', 'Boleto', 250.00, 5);