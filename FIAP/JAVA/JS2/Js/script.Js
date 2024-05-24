console.log("Primeiro")
console.log("Segundo")

function novaSaida(){
    console.log("Gustavo Lazzuri")
}

console.log("Terceiro")
novaSaida()

function soma(num1 = 0, num2 = 0){
 return num1 + num2
}

soma(5,5)
console.log(soma );  

let somaMInutos(...nums){
    let total = 0
    for (let num of nums){
    total =+ num
    }
    return total
}


