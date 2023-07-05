#O nome desse arquivo precisa ser esse para ser importado

insert into cozinha(id, nome) values (1, 'Tailandesa');
insert into cozinha(id, nome) values (2, 'Indiana');


insert into restaurante(nome, taxa_frete, cozinha_id) values("Thai Gourmet", 10, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values("Thai Delivery", 9.50, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values("Tuk Tuk Comida", 15, 2);
insert into restaurante(nome, taxa_frete, cozinha_id) values ("Gastro", 25, 1);
insert into restaurante(nome, taxa_frete, cozinha_id) values ("Restaurante da Índia", 25, 2);



insert into forma_pagamento(id, descricao) value(1, "Pagamento por Dinheiro");
insert into forma_pagamento(id, descricao) value(2, "Pagamento por Cartão de Credito");
insert into forma_pagamento(id, descricao) value(3, "Pagamento por Cartão de Débito");
insert into forma_pagamento(id, descricao) value(4, "Pagamento por Pix");
insert into forma_pagamento(id, descricao) value(5, "Pagamento por Boleto");


insert into estado(id, nome) values(1, "Rio Grande do Sul");
insert into estado(id, nome) values(2, "Santa Catarina");
insert into estado(id, nome) values(3, "Paraná");
insert into estado(id, nome) values(4, "São Paulo");
insert into estado(id, nome) values(5, "Rio de Janeiro");
insert into estado(id, nome) values(6, "Pará");
insert into estado(id, nome) values(7, "Distrito Federal");
insert into estado(id, nome) values(8, "Minas Gerais");



insert into cidade(id, nome, estado_id) values(1, "Caxias do Sul", 1);
insert into cidade(id, nome, estado_id) values(2, "Gramado", 1);
insert into cidade(id, nome, estado_id) values(3, "Canela", 1);
insert into cidade(id, nome, estado_id) values(4, "Tores", 1);



insert into permissao(id, nome, descricao) values(1, "CriarUsuario", "Permite ao usuário inserir novos Usuarios");
insert into permissao(id, nome, descricao) values(2, "Criar Prato", "Permite ao usuário criar novos pratos");
insert into permissao(id, nome, descricao) values(3, "CriarRestaurante", "Permite ao usuário criar um novo restaurante");
insert into permissao(id, nome, descricao) values(4, "CriarCozinha", "Permite ao usuário inserir uma nova cozinha");
insert into permissao(id, nome, descricao) values(5, "Cozinhar", "Permite o usuário cozinhar");
insert into permissao(id, nome, descricao) values(6, "ComprarAlimentos", "Permite ao usuário comprar mais alimentos para estoque");
insert into permissao(id, nome, descricao) values(7, "GerarNotaFiscal", "Permite ao usuário Gerar Nota Fiscal");
insert into permissao(id, nome, descricao) values(8, "FazerPedido", "Permite ao cliente ou atendente fazer um pedido");
insert into permissao(id, nome, descricao) values(9, "ContartarEvento", "Permite ao cliente ou atendente fazer um pedido");
insert into permissao(id, nome, descricao) values(10, "PermissaoRepetida", "Essa permissão foi adicionada repetida");









