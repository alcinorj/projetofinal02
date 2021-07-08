#language: pt
#encoding: iso-8859-1

Funcionalidade: Atualizar Tipo de Contrata��o

Esquema do Cen�rio: Definir o tipo de contrata��o

Dado Acessar a p�gina de atualiza��o de tipo de contrata��o
E Selecionar o funcion�rio desejado <funcionario>
E Selecionar o tipo de contrata��o <tipodecontratacao>
Quando Solicitar a atualiza��o do tipo de contrata��o
Ent�o Sistema informa que o tipo de contrata��o foi atualizado com sucesso

Exemplos: 

|      funcionario         |  tipodecontratacao  |
| "Pedro Rocha dos Santos" | "Estagio"           |
| "Fabiana da Silva"       | "CLT"               |
| "Gustavo de Araujo"      | "Pessoa Jur�dica"   | 

Cen�rio: Valida��o de campos obrigat�rios
Dado Acessar a p�gina de atualiza��o de tipo de contrata��o
Quando Solicitar a atualiza��o do tipo de contrata��o
Ent�o Sistema informa que os campos s�o obrigat�rios


