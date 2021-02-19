# Exceptions

## v1 - Very bad solution
- Lógica de validação não delegada à classe `Reservation`.

## v2 - bad solution: método retornando string
- A semântica da operação é prejudicada
- Retornar string não tem nada a ver com atualização de reserva
- E se a operação tivesse que retornar um string?
- Ainda não é possível tratar exceções em construtores
- Ainda não há auxílio do compilador: o programador deve "lembrar" de verificar se houve
erro
- A lógica fica estruturada em condicionais aninhadas