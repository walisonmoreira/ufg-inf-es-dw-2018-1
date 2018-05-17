function maiorMenor() {
    var idadeInput = document.getElementById("idade");
    var idade = idadeInput.value;
    if (idade >= 18) {
        alert("Maior de idade!");
    } else {
        alert("Menor de idade!");
    }
}
