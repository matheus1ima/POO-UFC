## Atividade

### O sistema deverá: ###

- Inicializar
    - passando energia, saciedade e limpeza máximas do pet.
    - Todos os níveis devem ser iniciados no máximo na criação do pet.
    - Os outros atributos são:
        - diamantes, que ele vai ganhar jogando.
        - e idade que aumenta a cada ação realizada,
        - ambos iniciando em 0.
- Comendo, Jogando, Dormindo e tomando banho
    - Cada operação causa aumento e reduções nos atributos.
    - Nenhum atributo pode passar do máximo ou ir abaixo de 0.
- Morrendo
    - Se algum atributo chegar a 0, o pet morre e nenhuma ação pode ser feita a não ser mostrar os dados.

## Como foi feito? ###

O código foi desenvolvido em duas horas, acabei me confundindo com a lógica de quando o pet estaria morto ou vivo, mas consegui desenvolver essa parte dentro do metodo testAlive, o que facilitou na redução de "if's" dentro dos métodos. Desenvolvi os métodos definindo se eram publicos ou privados para que os valores fossem unicamente modificados ou acessados a partir dos seus devidos "set's" e "get's".

> 03.POO
