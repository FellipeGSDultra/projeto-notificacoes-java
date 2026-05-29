# Sistema de Controle de Notificações (Java) 📨

Um sistema de gerenciamento de mensagens e notificações desenvolvido em Java, aplicando os fundamentos da Programação Orientada a Objetos (POO).
Este projeto foi construído com foco em Arquitetura Limpa e separação de responsabilidades, inspirando-se no padrão MVC (Model-View-Controller) para garantir um código coeso, fácil de manter e escalável.

## 🚀 Funcionalidades

- **Autenticação de Usuários:** Sistema de login com validação de credenciais.
- **Controle de Acesso (RBAC):** Diferentes níveis de permissão (Admin e Cliente), com menus exclusivos para cada perfil.
- **Cadastro Automatizado:** Criação de novas contas via menu inicial, com atribuição automática do perfil Cliente.
- **Gerenciamento de Notificações:**
  - Clientes podem enviar mensagens categorizadas (Feedback, Problemas com a conta, Reclamação).
  - Administradores podem ler as notificações, que são filtradas por status (Não Lida / Lida).
  - Alteração automática do status da mensagem após a leitura pelo administrador.
- **Tratamento de Exceções (Fail-Safe):** Interface blindada contra erros de digitação do usuário (tratamento de NumberFormatException), evitando que a aplicação encerre de forma inesperada.

## 🛠️ Tecnologias e Conceitos Utilizados

- **Linguagem:** Java (JDK 17+)
- **Paradigma:** Programação Orientada a Objetos (Classes, Objetos, Encapsulamento, Métodos).
- **Boas Práticas:**
  - *Single Responsibility Principle (SRP):* Separação clara entre as camadas de Visão (Telas), Serviços (Regra de Negócio) e Modelos (Dados).
  - *Injeção de Dependência:* O serviço de autenticação recebe o serviço de usuários para operar, reduzindo o acoplamento.
  - *Código DRY (Don't Repeat Yourself)* no tratamento de leitura de dados do console.

## 📂 Arquitetura do Projeto

O código está organizado em pacotes (packages) para facilitar a manutenção:

`	ext
src/
├── modelo/
│   ├── Notificacao.java          # Estrutura e dados das mensagens
│   └── Usuario.java              # Estrutura e credenciais de acesso
├── servico/
│   ├── ServicoAutenticacao.java  # Lida com a validação de login
│   ├── ServicoNotificacoes.java  # Lógica de armazenamento e filtro de leitura
│   └── ServicoUsuario.java       # "Banco de dados" em memória e cadastro
├── visao/
│   └── InterfaceUsuario.java     # Interação com o console (I/O) e menus
└── Main.java                     # Ponto de entrada e maestro do fluxo (Controlador)
`

## ⚙️ Como Executar

1. Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.
2. Clone este repositório.
3. Abra o projeto em sua IDE de preferência (VS Code, IntelliJ, Eclipse).
4. Navegue até o arquivo src/Main.java.
5. Execute a classe principal (Run).
6. Interaja com o sistema através do terminal integrado.

## 🔐 Credenciais Padrão para Teste

Ao iniciar o sistema, os seguintes usuários já estão carregados na memória:

| Login | Senha | Tipo de Usuário |
| :--- | :--- | :--- |
| admin | admin123 | Admin |
| fellipe | 1234 | Cliente |

---
*Projeto acadêmico desenvolvido para aprofundamento em Java e práticas de Back-end.*