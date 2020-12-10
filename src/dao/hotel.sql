-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Dez-2020 às 04:23
-- Versão do servidor: 10.3.15-MariaDB
-- versão do PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hotel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluguel`
--

CREATE TABLE `aluguel` (
  `cod_alug` int(11) NOT NULL,
  `cod_hosp` int(11) NOT NULL,
  `cod_func` int(11) NOT NULL,
  `Data_aluguel` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluguel`
--

INSERT INTO `aluguel` (`cod_alug`, `cod_hosp`, `cod_func`, `Data_aluguel`) VALUES
(1, 1, 2, '2020-12-08'),
(2, 2, 2, '2020-12-09'),
(3, 4, 3, '2020-12-09');
-- --------------------------------------------------------

--
-- Estrutura da tabela `cartao`
--

CREATE TABLE `cartao` (
  `cod_cart` int(11) NOT NULL,
  `cod_hosp` int(11) NOT NULL,
  `numero_cart` int(11) NOT NULL,
  `cvv` int(11) NOT NULL,
  `tipo` varchar(7) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cartao`
--

INSERT INTO `cartao` (`cod_cart`, `cod_hosp`, `numero_cart`, `cvv`, `tipo`, `status`) VALUES
(2, 2, 12345, 123, 'Debito', 1),
(3, 3, 54321, 321, 'Credito', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_func` int(11) NOT NULL,
  `cpf_func` bigint(11) NOT NULL,
  `nome_func` varchar(40) NOT NULL,
  `email_func` varchar(40) NOT NULL,
  `endereco_func` varchar(40) NOT NULL,
  `telefone_func` int(11) NOT NULL,
  `senha_func` varchar(20) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`cod_func`, `cpf_func`, `nome_func`, `email_func`, `endereco_func`, `telefone_func`, `senha_func`, `status`) VALUES
(1, 11111111111, 'admin', 'admin@admin', 'admin', 11111111, AES_ENCRYPT('admin', 'chave'), 1),
(2, 54384379222, 'Esther Campos', 'esther_campos@terra.com.br', 'Rua Doutor João Emílio Falcão', 991669177, AES_ENCRYPT('campos666', 'chave'), 1),
(3, 31348377289, 'Guilherme Miguel', 'gguilhermemigue@email.com.br', 'Av. Bruno Martini', 998718393, AES_ENCRYPT('guimi15', 'chave'), 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hospede`
--

CREATE TABLE `hospede` (
  `cod_hosp` int(11) NOT NULL,
  `cpf` bigint(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` int(11) NOT NULL,
  `senha_hosp` varchar(20) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hospede`
--
INSERT INTO `hospede` (`cod_hosp`, `cpf`, `nome`, `email`, `endereco`, `telefone`, `senha_hosp`, `status`) VALUES
(1, 11111111111, 'admin', 'admn@admin', 'admin', 11111111, AES_ENCRYPT('admin', 'chave'), 1),
(2, 87161331211, 'Eduardo Gomes', 'eduardogomes@gmail.com.br', 'Rua Sérgio A. Pinto', 95741236, AES_ENCRYPT('agomes123', 'chave'), 1),
(3, 43832333240, 'Vinicius Bruno', 'viniciusbruno@otlokk.com', 'Parque Esplanada II', 20254678, AES_ENCRYPT('vbruno', 'chave'), 1),
(4, 25335624061, 'Betina Caroline', 'betinacarol@yahoo.com.br', 'Rua Francisco de Souza', 94758123, AES_ENCRYPT('tina321', 'chave'), 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `cod_pag` int(11) NOT NULL,
  `numero_quar` int(11) NOT NULL,
  `cod_alug` int(11) NOT NULL,
  `num_Dias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`cod_pag`, `numero_quar`, `cod_alug`, `num_Dias`) VALUES
(1, 5, 1, 3),
(2, 4, 3, 5),
(3, 1, 2, 2);
-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE `quarto` (
  `numero_quar` int(11) NOT NULL,
  `andar` int(11) NOT NULL,
  `disponibilidade` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `preco` decimal(5,2) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `quarto`
--

INSERT INTO `quarto` (`numero_quar`, `andar`, `disponibilidade`, `categoria`, `preco`, `status`) VALUES
(1, 1, 2, 2, '500.00', 1),
(2, 1, 1, 2, '500.00', 1),
(3, 2, 1, 1, '100.00', 1),
(4, 2, 2, 1, '100.00', 1),
(5, 3, 2, 3, '1000.00', 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD PRIMARY KEY (`cod_alug`),
  ADD KEY `cod_hosp` (`cod_hosp`),
  ADD KEY `cod_func` (`cod_func`);

--
-- Índices para tabela `cartao`
--
ALTER TABLE `cartao`
  ADD PRIMARY KEY (`cod_cart`),
  ADD KEY `cod_hosp` (`cod_hosp`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`cod_func`),
  ADD UNIQUE KEY `cpf_func` (`cpf_func`);

--
-- Índices para tabela `hospede`
--
ALTER TABLE `hospede`
  ADD PRIMARY KEY (`cod_hosp`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices para tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD KEY `cod_alug` (`cod_alug`),
  ADD KEY `pagamento_ibfk_1` (`numero_quar`);

--
-- Índices para tabela `quarto`
--
ALTER TABLE `quarto`
  ADD PRIMARY KEY (`numero_quar`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluguel`
--
ALTER TABLE `aluguel`
  MODIFY `cod_alug` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cartao`
--
ALTER TABLE `cartao`
  MODIFY `cod_cart` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `hospede`
--
ALTER TABLE `hospede`
  MODIFY `cod_hosp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `aluguel_ibfk_1` FOREIGN KEY (`cod_hosp`) REFERENCES `hospede` (`cod_hosp`),
  ADD CONSTRAINT `aluguel_ibfk_2` FOREIGN KEY (`cod_func`) REFERENCES `funcionario` (`cod_func`);

--
-- Limitadores para a tabela `cartao`
--
ALTER TABLE `cartao`
  ADD CONSTRAINT `cartao_ibfk_1` FOREIGN KEY (`cod_hosp`) REFERENCES `hospede` (`cod_hosp`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`numero_quar`) REFERENCES `quarto` (`numero_quar`),
  ADD CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`cod_alug`) REFERENCES `aluguel` (`cod_alug`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
