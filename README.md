# :syringe: Sistema de Vacinação COVID-19 🦠

A pandemia de COVID-19, uma doença respiratória aguda causada pelo coronavírus SARS-CoV-2, vem assombrando o mundo desde que foi identificada pela primeira vez em Wuhan, na província de Hubei, República Popular da China, em 31 de dezembro de 2019. Após quase um ano de pesquisas, cientistas do mundo inteiro vêm trazendo diversas alternativas de vacina com diferentes níveis de confiabilidade e sendo divulgadas no mercado. As autoridades competentes já estabeleceram a prioridade da vacinação, no entanto, é necessário organizar a demanda, e para isto desenvolvemos um Sistema de Informação que administra e controla desde a aquisição das vacinas até a sua aplicação fornecendo dados para que se faça eficaz o controle.

## Objetivo

O objetivo geral do projeto é fazer o controle das variáveis necessárias para a campanha de vacinação contra a COVID-19 fornecendo informações importantes para os participantes do sistema.

## ⚙️ Funcionalidades

- [x] Sistema de cadastramento
- [x] Sistema de informações
- [x] Controle do estoque de cada local de vacinação
- [x] Controle do acesso do sistema
- [x] Controle das vacinas
- [x] Controle da fila de pessoas
- [x] Controle do status dos pacientes
- [ ] Remover as instâncias cadastradas

## 🛠️ Construído com

- [Eclipse](https://www.eclipse.org/) - IDE para desenvolvimento Java

## Desenvolvimento

#### Grupos de prioridade que devem ser contemplados no sistema (levando em consideração o Plano Nacional de Vacinação)

1. Pessoas com 60 anos ou mais institucionalizadas
2. Povos indígenas vivendo em terras indígenas
3. Profissional da saúde
4. Pessoas de 75 ou mais
5. Povos e comunidades tradicionais ribeirinhas
6. Povos e comunidades tradicionais quilombolas
7. Pessoas de 70 a 64 anos
8. Indivíduos com comorbidades

#### Planejamento dos relacionamentos

![](https://github.com/CauanyRodrigues01/Sistema-de-vacinacao-COVID-19/blob/main/uml.png)

:mag_right: Observação: Todas as classes terão incluídas os métodos Gets, Sets, To Strings e Equals.

#### Definição de classes

- Pessoa

  Classe que abrange todos os participantes do sistema e que possui os dados pessoais dos integrantes. Serão as pessoas que receberão as doses e serão monitoradas.

- Paciente

  É a classe que representa as pessoas que estão para receber as doses da vacina e que consequentemente estão na fila para recebê-la. O sistema vai analisar que tipo de prioridade o paciente tem.

- Médico

  É a classe que representa um tipo de profissional de saúde com acesso ao sistema.

- Enfermeiro

  É a classe que representa um tipo de profissional de saúde com acesso ao sistema.

- Cidade

  É a classe que representa uma cidade brasileira. É uma classe importante para o controle de dados e informações, como o total de pessoas que estão ou não imunizadas na região.

- Local de Vacinação

  É a classe que representa os locais de vacinação. É uma classe importante para o controle de estoque, pois é nos locais de vacinação que as ampolas das vacinas estão armazenadas.

- Ampola

  Classe que corresponde ao vidro da vacina com 10 doses cada e que vai ter suas informações necessárias.

- Funções cadastramento

  Classe que possui todos os métodos que serão chamadas em Cadastro.

- Funções print

  Classe que possui todos os métodos para printar a interface das telas.
  DateErrorExceptionClasse que estende a classe Exception definindo uma exceção criada para o próprio sistema com o intuito de acusar algum erro para as datas.

#### Definição de interfaces

- Profissional de Saúde

  Interface que define métodos que todo Médico e Enfermeiro, entidades importantes para o sistema, vão ter que implementar para ter o controle do acesso de vacinação.

- Information Processor

  Interface que define os métodos que toda Cidade e Local de Vacinação devem implementar no Sistema.

## ✒️ Autores

Todos aqueles que ajudaram a levantar o projeto desde o seu início

- **Cauany Rodrigues** - *Desenvolvedora* - [Cauany Rodrigues](https://github.com/CauanyRodrigues01)
- **Maria Eduarda Viana** - *Desenvolvedora* - [Maria Eduarda Viana](https://github.com/eduardaviana)
- **Pedro Nascimento** - *Desenvolvedor* - [Pedro Nascimento](https://github.com/m1thrandirr)

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](https://github.com/CauanyRodrigues01/Sistema-de-vacinacao-COVID-19/blob/main/LICENSE) para detalhes.

## 🎁 Expressões de gratidão

Agradecemos à professora Mirna Maia pela colaboração e por nos incentivar

------

⌨️  Feito com ❤️ por todos 😊



