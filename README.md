# Consultify

Consultify é um projeto de estudo criado para demonstrar o uso de Spring Boot em um sistema de gerenciamento de agendamentos para clínicas. Este projeto inclui funcionalidades básicas como gestão de profissionais, agendamentos e sistema de convites para novos usuários.

## Funcionalidades

- **Cadastro de Profissionais**: Médicos e recepcionistas podem ser cadastrados no sistema.
- **Gerenciamento de Agendamentos**: Crie, atualize e visualize agendamentos para pacientes.
- **Sistema de Convites**: Administradores podem gerar tokens de convite para criar novas contas para médicos e recepcionistas.
- **Autenticação e Autorização**: Implementação básica para proteger rotas e gerenciar acesso.

## Estrutura do Projeto

### Estrutura de Dados

- **Professional**: Representa um médico ou recepcionista.
- **Admin**: Representa um administrador do sistema.
- **Appointment**: Representa um agendamento de consulta.
- **InviteToken**: Representa um token de convite para novos usuários.

### Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para mapeamento objeto-relacional e manipulação de dados.
- **Spring Security**: Para gerenciamento de autenticação e autorização.
- **H2 Database**: Banco de dados em memória (pode ser substituído por outros bancos de dados).

## Configuração do Projeto

### Requisitos

- Java 17 ou superior
- Maven
