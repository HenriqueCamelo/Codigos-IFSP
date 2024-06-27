use ALUNO_F161
go

create table tb_clientes
(
cod_clientes varchar(30),
endereço varchar(30),
cidade varchar(30),
CEP varchar(8),
UF varchar(2),
Pais varchar(30),
Telefone varchar(11),
Fax varchar(30)
constraint pk_clienteses primary key(cod_clientes),
)

create table tb_pedidos
(
NumeroPedido varchar(30),
codigo_cliente varchar(30),
codigo_funcionario varchar(30),
DataDoPedido varchar(30),
DataDeEntrega varchar(30),
DataDeEnvio varchar(30),
Frete varchar(30),
NomeDestinatario varchar(30),
EnderecoDestinatario varchar(30),
CidadeDeDestino varchar(30),
CEPdeDestino varchar(30),
PaisDeDestio varchar(30)
constraint pk_pedidos primary key(NumeroPedido),
)

create table tb_itenspedido
(
NumeroDoPedido varchar(30),
CodigoDoProduto varchar(30),
PrecoUnitario varchar(30),
Quantidade varchar(30),
Desconto varchar(30)
constraint pk_intenspedidos primary key(NumeroDoPedido),
constraint pk_intenspedidocodigos primary key(CodigoDoProduto),
)

create table tb_produtos
(
CodigoProduto varchar(30),
NomedoProduto varchar(30),
CodigoFornecedor varchar(30),
CodigoCategoria varchar(30),
QuantidadePorUnidade varchar(30),
PrecoUnitario varchar(30),
Unidadesemestoque varchar(30),
UnidadesPedidas varchar(30),
NivelDeEstoque varchar(30),
Descontinuado varchar(30)
constraint pk_CodigoProduto primary key(CodigoProduto),
)

create table tb_fornecedores
(
CodigodoFornecedor varchar(30),
NomeDaEmpresa varchar(30),
NomeDoContato varchar(30),
CargoDoContato varchar(30),
Endereco varchar(30),
Cidade varchar(30),
UF varchar(30),
CEP varchar(30),
Pais varchar(30),
Teleforne varchar(30),
Fax varchar(30)
constraint pk_fornecedor primary key(CodigodoFornecedor),
)

create table tb_categorias
(
CodigoDaCategoria varchar(30),
NomedaCategoria varchar(30),
Descricao varchar(30),
Figura varchar(30),
)





)