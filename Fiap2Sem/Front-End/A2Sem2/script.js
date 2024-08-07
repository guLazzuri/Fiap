const Alunos = [ 
{nota: 5, nome: 'Gustavo'},
{nota: 7, nome: 'Felipe'},
{nota: 8, nome: 'Andre'},
{nota: 3, nome: 'Joao'},
{nota: 10, nome: 'Guilherme'}
]

let listaDeAlunos = Alunos.map(Aluno => Aluno.nome)

console.log(listaDeAlunos);

let alunosAprovados = Alunos.filter(aluno => aluno.nota >= 5).map(aluno => `O ${aluno.nome} foi aprovado com nota ${aluno.nota} de media`)

console.log(alunosAprovados)

const vendedores = [ 
    {vendas: 5, nome: 'Gustavo', idade: 25},
    {vendas: 7, nome: 'Felipe', idade: 30},
    {vendas: 8, nome: 'Andre', idade: 35},
    {vendas: 3, nome: 'Joao', idade: 40},
    {vendas: 10, nome: 'Guilherme'}
    ]
const totalVendas = vendedores.reduce((valorTotal, ValorAtual) => valorTotal+ ValorAtual.vendas, 0 )

const dadosVendas = vendedores.reduce((acumulador, item)=> {
    const maisNovo = acumulador.maisNovo < item.idade ? acumulador.maisNovo: item.idade
    const maisVelho = acumulador.maisVelho > item.idade ? acumulador.maisVelho : item.idade

    return {
        totalVendas:  acumulador.totalVendas + item.vendas,
        maisNovo: maisNovo,
        maisVelho:  maisVelho
    }
},{totalVendas: 0, maisNovo: undefined, maisVelho : undefined}  )

console.log(totalVendas)

const filaBrinquedos = [ 
    {altura: 1.7, nome: 'Gustavo', idade: 25},
    {altura: 1.7, nome: 'Felipe', idade: 17},
    {altura: 1.9, nome: 'Andre', idade: 7},
    {altura: 1.65, nome: 'Joao', idade: 2},
    {altura: 1.55, nome: 'Guilherme', idade: 19}
    ]
const todaFilaPode = filaBrinquedos.every(pessoas => pessoas.altura >= 1.60)

console.log(todaFilaPode ? "Vamos la" : "Nem todos podem");

const temResponsavel = filaBrinquedos.some(pessoas.idade >= 18)
console.log(temResponsavel ? "Sim, voces podem" : "Não, precisa de alguem maior")

const responsavel = filaBrinquedos.find(pessoas => pessoas.idade >= 18)
console.log(` A pessoa responsável será ${responsavel.nome} pois ela tem ${responsavel.idade}`);

const convidados = [ 'prof Luis', 'Gustavo', 'Anne', 'prof Rafael Ronqui', 'Carolina']

const profConvidados = convidados.filter(conv => conv.includes('prof'))
console.log(profConvidados);

