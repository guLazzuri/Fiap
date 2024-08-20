const frutas = ['maça', 'uva', 'mamao']
const legumes = ['batata', 'cenoura','mandioca']

const feira = [...frutas, ...legumes, 'couve', 'alface']

console.log(feira);

let carro = {
    marca: 'fiat',
    modelo: 'uno',
    ano: 2020
}
   


carro = {...carro, modelo: 'uno'}
carro = { ...carro, motor: '1.0'}

console.log(carro)

//REST PARAMETER

function soma(...numeros){
    return numeros.reduce((acumlador, item)=> acumlador + item)
}

console.log(soma(1,2,3,3,43))

// Destructuring

let alunos = ['Gustavo','Felipe','Lari']

let [aluno1, aluno2, aluno3] = alunos

console.log(aluno1)
console.log(aluno2)
console.log(aluno3)

// let car1, car2, ar3, car4

// [car1,car2,car3,car4] = ['civic', 'cruze', 'corolla', 'Sentra']

// console.log(car1)
// console.log(car2)
// console.log(car3)
// console.log(car4)

let car1, car2, car3, car4
[car1 = 'X1', car2= 'X2', car3 = 'X3', car4 = 'X4']

console.log(car1)
console.log(car2)
console.log(car3)
console.log(car4)

const filmes = {
    ficcao: 'Vingadores',
    Terror: 'Bruxa',
    comedia: 'O poderoso chefao'
}

let {ficcao, comedia}= filmes
ficcao = 'Star Wars'

console.log(ficcao)
console.log(filmes.ficcao)

//Create Element

// const titulo = "<H1>Titulo da pagina</H1>"
// document.querySelector('body').innerHTML = titulo

//Cria o h1
const titulo = document.createElement('h1')
//Cria a escrtita
const texto = document.createTextNode("Titulo da Pagina")
//Coloca a escita no H1
titulo.appendChild(texto)
titulo.setAttribute('id', 'titulo')
//Coloca o H1 no Body
document.querySelector('body').appendChild(titulo)


