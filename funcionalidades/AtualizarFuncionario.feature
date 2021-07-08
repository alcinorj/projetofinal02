#language: pt
#encoding: iso-8859-1

Funcionalidade: Atualizar Tipo de Contratação

Esquema do Cenário: Definir o tipo de contratação

Dado Acessar a página de atualização de tipo de contratação
E Selecionar o funcionário desejado <funcionario>
E Selecionar o tipo de contratação <tipodecontratacao>
Quando Solicitar a atualização do tipo de contratação
Então Sistema informa que o tipo de contratação foi atualizado com sucesso

Exemplos: 

|      funcionario         |  tipodecontratacao  |
| "Pedro Rocha dos Santos" | "Estagio"           |
| "Fabiana da Silva"       | "CLT"               |
| "Gustavo de Araujo"      | "Pessoa Jurídica"   | 

Cenário: Validação de campos obrigatórios
Dado Acessar a página de atualização de tipo de contratação
Quando Solicitar a atualização do tipo de contratação
Então Sistema informa que os campos são obrigatórios


