insert into categoria(nome) values('livros');
insert into categoria(nome) values('eletronicos');
insert into categoria(nome) values('games');
insert into categoria(nome) values('eletros');

insert into produto(nome, descricao, preco, img_url) values('note', 'o melhor note', 2790., 'http://note.com');
insert into produto(nome, descricao, preco, img_url) values('o senhor dos anéis', 'o melhor livro', 275., 'http://osenhor.com');
insert into produto(nome, descricao, preco, img_url) values('mario 3', 'o melhor jogo', 255., 'http://mario.com');
insert into produto(nome, descricao, preco, img_url) values('aspirador', 'o melhor aspirador', 175., 'http://aspirador.com');

insert into Produto_categoria(id_produto, id_categoria) values(1, 2);
insert into produto_categoria(id_produto, id_categoria) values(2, 1);
insert into produto_categoria(id_produto, id_categoria) values(3, 3);
insert into produto_categoria(id_produto, id_categoria) values(4, 4);

insert into usuario(nome, email, fone, niver, senha) values('adolf dolf', 'ado@gmail.com', '999012376', '2000-09-02', '1423');
insert into usuario(nome, email, fone, niver, senha) values('zaifofias mas', 'mas@gmail.com', '991004567', '1985-03-11', '5849');
insert into usuario(nome, email, fone, niver, senha) values('tiuca namae', 'tiuca@gmaiol.com', '981256166', '1998-04-07', '3012');

insert into pedido(momento, estado, cliente_id) values(timestamp with time zone '2026-01-12T08:01:15Z', 3, 3);
insert into pedido(momento, estado, cliente_id) values(timestamp with time zone '2026-01-15T10:16:22Z', 1, 1);
insert into pedido(momento, estado, cliente_id) values(timestamp with time zone '2026-01-17T15:09:55Z', 2, 3);

insert into item(id_pedido, id_produto, quantidade, preco) values(1, 1, 2, 2790.);
insert into item(id_pedido, id_produto, quantidade, preco) values(2, 2, 1, 275.);
insert into item(id_pedido, id_produto, quantidade, preco) values(3, 3, 1, 255.);
insert into item(id_pedido, id_produto, quantidade, preco) values(3, 4, 2, 175.);

insert into pagamento(pedido_id, momento) values(1, timestamp with time zone '2026-01-12T12:09:22Z');
insert into pagamento(pedido_id, momento) values(2, timestamp with time zone '2026-01-17T15:00:33Z');
insert into pagamento(pedido_id, momento) values(3, timestamp with time zone '2026-01-23T11:15:21Z');