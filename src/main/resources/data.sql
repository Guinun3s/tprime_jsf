INSERT INTO cliente (nome, cpf, data_nascimento, email, telefone, endereco, divida) VALUES
('João Silva', '123.456.789-00', '1980-01-01', 'joao.silva@example.com', '(11) 98765-4321', 'Rua A, 123', 80.00),
('Maria Souza', '987.654.321-00', '1990-02-02', 'maria.souza@example.com', '(21) 87654-3210', 'Avenida B, 456', 230.00),
('Carlos Pereira', '456.789.123-00', '1985-03-03', 'carlos.pereira@example.com', '(31) 76543-2109', 'Travessa C, 789', 1080.00);

INSERT INTO produto (nome, valor) VALUES
('Kaiak', 80.00),
('Malbec', 150.00),
('Essecial', 200.00),
('Ferrari Black', 880.00),
('Wisky 99', 2500.00);

INSERT INTO compra (data_compra, situacao, valor, id_cliente_fk) VALUES
('2021-01-01', false, 80.00, 1),
('2021-02-02', false, 230.00, 2),
('2021-03-03', false, 1080.00, 3);

INSERT INTO compra_produto (compra_id, produto_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO pagamento (data_pagamento, forma_pagamento, valor, id_pagamento_fk) VALUES
('2021-01-01', 'Cartão', 50.00, 1),
('2021-02-02', 'Boleto', 100.00, 2),
('2021-03-03', 'Dinheiro', 150.00, 3);