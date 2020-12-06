-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Dez-2020 às 04:31
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

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartao`
--

CREATE TABLE `cartao` (
  `cod_cart` int(11) NOT NULL,
  `cod_hosp` int(11) NOT NULL,
  `numero_cart` int(11) NOT NULL,
  `cvv` int(11) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_func` int(11) NOT NULL,
  `cpf_func` int(11) NOT NULL,
  `nome_func` varchar(40) NOT NULL,
  `email_func` varchar(40) NOT NULL,
  `endereco_func` varchar(40) NOT NULL,
  `telefone_func` int(11) NOT NULL,
  `senha_func` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hospede`
--

CREATE TABLE `hospede` (
  `cod_hosp` int(11) NOT NULL,
  `cpf` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` int(11) NOT NULL,
  `senha_hosp` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hospede`
--

INSERT INTO `hospede` (`cod_hosp`, `cpf`, `nome`, `email`, `endereco`, `telefone`, `senha_hosp`, `status`) VALUES
(1, 2147483647, 'teste', 'teste', 'teste', 11111111, '698dc19d489c4e4db73e', 1),
(2, 1111111112, 'teste', 'teste', 'teste', 11111111, 'teste', 1),
(3, 2111111112, 'teste', 'teste', 'teste', 11111111, '6ïYƒÈ½Aîí8ßýK', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `numero_quar` int(11) NOT NULL,
  `cod_alug` int(11) NOT NULL,
  `num_Dias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE `quarto` (
  `numero_quar` int(11) NOT NULL,
  `andar` int(11) NOT NULL,
  `disponibilidade` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `preço` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD KEY `numero_quar` (`numero_quar`),
  ADD KEY `cod_alug` (`cod_alug`);

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
  MODIFY `cod_cart` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_func` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `hospede`
--
ALTER TABLE `hospede`
  MODIFY `cod_hosp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `quarto`
--
ALTER TABLE `quarto`
  MODIFY `numero_quar` int(11) NOT NULL AUTO_INCREMENT;

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
