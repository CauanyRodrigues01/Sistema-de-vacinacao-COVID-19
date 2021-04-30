# :syringe: Sistema de Vacinação COVID-19 🦠

A pandemia de COVID-19, uma doença respiratória aguda causada pelo coronavírus SARS-CoV-2, vem assombrando o mundo desde que foi identificada pela primeira vez em Wuhan, na província de Hubei, República Popular da China, em 31 de dezembro de 2019. Após quase um ano de pesquisas cientistas do mundo inteiro vêm trazendo diversas alternativas de vacina com diferentes níveis de confiabilidade e sendo divulgadas no mercado. As autoridades competentes já estabeleceram a prioridade da vacinação, no entanto, é necessário organizar a demanda, e para isto desenvolvemos um Sistema de Informação que coleciona, armazena, transmite e processa dados para o fazer em relação à quantidades de doses, pacientes, médicos, equipamentos, etc.

## ⚙️ Funcionalidades

- [ ] Controle do estoque de cada estado
- [ ] Controle do estoque de cada hospital
- [ ] Controle do acesso do sistema
- [ ] Controle das vacinas
- [ ] Controle da fila
- [ ] Controle do status dos pacientes
- [ ] Controle dos equipamentos disponíveis

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

#### Planejamento de atributos e métodos

<img src="https://lh5.googleusercontent.com/oNWfDhV6pnXP5Lc-1xbOxOOItxFs3xqe-ElFOgZ1fQxkczp2BhBEGL4AtSYGogfgYSoQ27hVLxoIPChbuZbl6x3K0bxCsEXAgvIPqGgey1Ps6e7I1Sgo36SHFBHXYDvQHfoYGwDb" alt="img" style="zoom: 80%;" />

Diagrama disponível neste [link](https://online.visual-paradigm.com/share.jsp?id=313237383639362d32).

:mag_right: Observação: Todas as classes terão incluídas os métodos Gets, Sets, To Strings e Equals.

#### Planejamento dos relacionamentos

![img](https://lh4.googleusercontent.com/ScQ8JtHLDqvczYQKn7Q6BJFeMkywh7Qd9Sv0R_9_I9QFo-jkdd_lunNP0CjdgI5Dr46ffCVFz6VxX9wanLhPMh7IH1erOpwbFsP2zz_j107_STjN_OGRhsKCRJGB9AJTBb7uvOqE)Diagrama disponível neste [link](https://online.visual-paradigm.com/share.jsp?id=313237383639362d32).

#### Definição de classes

- Pessoa

  Classe que abrange todos os participantes do sistema e que possui os dados pessoais dos integrantes. Serão as pessoas que receberão as doses e serão monitoradas.

- Paciente

  É a classe que representa as pessoas que estão para receber as doses da vacina e que consequentemente estão na fila para recebê-la. O sistema vai analisar que tipo de prioridade o paciente tem.

- Profissional de Saúde

  São as pessoas que estão no sistema não como pacientes, mas com o papel importante de aplicar as doses nas pessoas. Cada profissional possui um local de trabalho e acesso ao sistema. Podem ser médicos ou enfermeiros.

- Médico

  É a classe que representa um tipo de profissional de saúde.

- Enfermeiro

  É a classe que representa um tipo de profissional de saúde.

- Estado
- É a classe que representa um estado brasileiro. É uma classe importante para o controle de dados e informações, como o total de pessoas que estão ou não imunizadas na região e se há estoque necessário no local.

- Cidade

  É a classe que representa uma cidade brasileira. É uma classe importante para o controle de dados e informações, como o total de pessoas que estão ou não imunizadas na região e se há estoque necessário no local.

- Local de Vacinação

  É a classe que representa os locais de vacinação.

- Ampola

  Classe que corresponde ao vidro da vacina e que vai ter suas informações necessárias.

- Fabricante

  Classe que representa o fabricante da vacina e portanto, indica o tipo da vacina.

## ✒️ Autores

Todos aqueles que ajudaram a levantar o projeto desde o seu início

- **Cauany Rodrigues** - *Desenvolvedora* - [Cauany Rodrigues](https://github.com/CauanyRodrigues01)
- **Maria Eduarda Viana** - *Desenvolvedora* - [Maria Eduarda Viana]()
- **Pedro Nascimento** - *Desenvolvedor; Documentação* - [Pedro Nascimento](https://github.com/m1thrandirr)

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](https://github.com/CauanyRodrigues01/Sistema-de-vacinacao-COVID-19/blob/main/LICENSE) para detalhes.

## 🎁 Expressões de gratidão

Agradecemos à professora Mirna Maia pela colaboração e por nos incentivar

------

⌨️  Feito com ❤️ por todos 😊



