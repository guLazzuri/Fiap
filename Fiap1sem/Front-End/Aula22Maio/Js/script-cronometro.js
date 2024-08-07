// variaveis de tempo
let mm = 0
let ss = 0
let cc = 0
 
// variaveis de controle
let cron
let controle = 0
 
// variaveis de elementos
let botaoLigar = document.querySelector('#ligar')
let botaoPausar = document.querySelector('#pausar')
let botaoParar = document.querySelector('#parar')
let cronometro = document.querySelector('#counter')
 
function timer(){
    cc++
    if(cc == 100){
        cc = 0
        ss++
 
        if(ss == 60){
            ss = 0
            mm++
        }
    }
    let relogio = ('0'+mm).slice(-2)+':'+('0'+ss).slice(-2)+':'+('0'+cc).slice(-2)
    cronometro.innerHTML = relogio
}
 
botaoLigar.addEventListener('click', ()=>{
    if(controle == 0){
        cron = setInterval(timer, 10)
        controle = 1
 
    }
})

botaoPausar.addEventListener('click', ()=>{
    clearInterval(cron)
    controle == 0
})

botaoParar.addEventListener('click', ()=>{
    clearInterval(cron)
    controle = 0
    mm = 0
    cc = 0
    ss = 0 
    cronometro.innerHTML = '00:00:00'
})

