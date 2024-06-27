-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13/12/2023 às 18:21
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `livraria`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tabcarrinho`
--

CREATE TABLE `tabcarrinho` (
  `carId` int(11) NOT NULL,
  `carProId` int(11) NOT NULL,
  `carQtde` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tabcarrinho`
--

INSERT INTO `tabcarrinho` (`carId`, `carProId`, `carQtde`) VALUES
(1, 2, 3),
(2, 0, 4),
(4, 4, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tabfuncionarios`
--

CREATE TABLE `tabfuncionarios` (
  `funId` int(11) NOT NULL,
  `funNome` varchar(40) NOT NULL,
  `funSenha` varchar(40) NOT NULL,
  `funEmail` varchar(40) NOT NULL,
  `funCargo` varchar(40) NOT NULL,
  `funUsuario` varchar(40) NOT NULL,
  `funFoto` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tabfuncionarios`
--

INSERT INTO `tabfuncionarios` (`funId`, `funNome`, `funSenha`, `funEmail`, `funCargo`, `funUsuario`, `funFoto`) VALUES
(1, 'Eva Araripe Lacerda', 'felipe1233', 'eva.lacerda@gmail.com', 'gerente', 'Eva', 'foto'),
(6, 'Jerson Mendes', 'gigi1234', 'jerson@gmail.com', 'Vendedor', 'Jerson', 'foto'),
(7, 'Beatriz Joana', '1010', 'beatriz@gmail.com', 'Diretora de Marketing', 'Bia', 'foto');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cadas`
--

CREATE TABLE `tb_cadas` (
  `cadId` int(11) NOT NULL,
  `cadNome` varchar(40) NOT NULL,
  `cadCel` varchar(15) DEFAULT NULL,
  `cadDataNasc` date NOT NULL,
  `cadSenha` varchar(30) DEFAULT NULL,
  `cadVerificacao` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_cadas`
--

INSERT INTO `tb_cadas` (`cadId`, `cadNome`, `cadCel`, `cadDataNasc`, `cadSenha`, `cadVerificacao`) VALUES
(1, 'Roberto Filho Almeida', '(11)9784-5563', '0000-00-00', 'julia009', 'julia009'),
(2, 'Joana Martins Almeida', '(11)9876-3562', '0000-00-00', 'oie##3', 'oie##3'),
(3, 'Gabriela Tavares de Olive', '(11)9227-5678', '0000-00-00', 'yujinlindo!!!', 'yujinlindo!!!'),
(4, 'Karen Falcâni', '(11)9876 5432', '1999-01-08', 'urar123', 'urar123'),
(5, 'Alberto Menezes Neto', '(11)9345-4231', '1989-07-23', 'Ordisses1999', 'Ordisses1999'),
(6, 'Valéria Teresa Melo', '(11)9754-9856', '1963-02-21', 'julia', 'julia'),
(8, 'Rog', 'eqweq', '2003-03-03', '123', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_livros`
--

CREATE TABLE `tb_livros` (
  `livroId` int(11) NOT NULL,
  `livroNome` varchar(30) NOT NULL,
  `livroEdi` varchar(30) NOT NULL,
  `livroAut` varchar(30) NOT NULL,
  `livroDataLan` varchar(30) NOT NULL,
  `livroImg` varchar(30) DEFAULT NULL,
  `livroDescr` varchar(30) DEFAULT NULL,
  `livroPrec` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_livros`
--

INSERT INTO `tb_livros` (`livroId`, `livroNome`, `livroEdi`, `livroAut`, `livroDataLan`, `livroImg`, `livroDescr`, `livroPrec`) VALUES
(1, 'Don QUIXOTE', 'FRIV', 'Miguel de Cervante', '1612-02-02', 'Dom Quixote', 'Dom Quixote', '14'),
(2, 'Metarmofose', 'Uno', 'Kafca', '1963-12-21', 'Metamorfose', 'Metarmofose', '40'),
(4, 'Dom Casmurro', 'ae', 'Machado de Assis', '1910-09-21', 'dom casmurro', 'Dom Casmurro', '22'),
(5, 'Diario de um banana', 'paviu', 'Jeff Kiney', '2002-05-22', 'diario', 'Diario de um Banana', '50'),
(6, 'O Capitão Panfílio', 'Noite', 'Alexandre Dumas', '2014-01-01', 'capitao', 'O Capitão Panfílio', '26'),
(7, 'Quincas Borba', 'PTD', 'Machado de Assi', '1891-09-05', 'quincas', 'Quincas Borba', '34'),
(9, 'A Casa das Palavras', 'ABC', 'Marina Colasanti', '2000-06-01', 'casa', 'A casa Das Palavras', '50');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tabcarrinho`
--
ALTER TABLE `tabcarrinho`
  ADD PRIMARY KEY (`carId`);

--
-- Índices de tabela `tabfuncionarios`
--
ALTER TABLE `tabfuncionarios`
  ADD PRIMARY KEY (`funId`);

--
-- Índices de tabela `tb_cadas`
--
ALTER TABLE `tb_cadas`
  ADD PRIMARY KEY (`cadId`);

--
-- Índices de tabela `tb_livros`
--
ALTER TABLE `tb_livros`
  ADD PRIMARY KEY (`livroId`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tabcarrinho`
--
ALTER TABLE `tabcarrinho`
  MODIFY `carId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tabfuncionarios`
--
ALTER TABLE `tabfuncionarios`
  MODIFY `funId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `tb_cadas`
--
ALTER TABLE `tb_cadas`
  MODIFY `cadId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `tb_livros`
--
ALTER TABLE `tb_livros`
  MODIFY `livroId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
