$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    $.get("/keeper/rest/lesson/" + id, function (data, status) {
        headline.innerHTML = data.headline;
        const phraseArray = data.phraseCards;
        for (let i = 0; i < phraseArray.length; i++) {
            const phrase = phraseArray[i];
            insertRow(phrase.phrase, phrase.translation);
        }

        reset();
    });

    document.getElementById("reset").onclick = reset;

});


function insertRow(phrase, translation) {
    const table = document.getElementById("phraseCards").getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    cell1.innerHTML = phrase;
    cell1.className = "phrase";
    cell1.addEventListener("click", () => exposeTranslation(cell2));

    cell2.innerHTML = translation;
    cell2.className = "translation";
}

const exposeTranslation = function (translation) {
    translation.style.visibility = '';
};

function reset() {
    const translations = document.getElementsByClassName("translation");
    for (let i = 0; i < translations.length; i++) {
        translations[i].style.visibility = 'hidden';

    }
}
