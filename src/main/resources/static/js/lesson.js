const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');


document.getElementById("reset").onclick = reset;
document.getElementById('next').onclick = next;
document.getElementById('closeModal').onclick = closeModal;
let CARD_INDEX = 0 ;

fetch("/keeper/rest/lesson/" + id)
    .then(response => response.json())
    .then(lesson => renderLesson(lesson));

function renderLesson(data) {
    const headline = document.getElementById("headline");
    headline.innerHTML = data.headline;
    const phraseArray = data.phraseCards;
    for (let i = 0; i < phraseArray.length; i++) {
        const phrase = phraseArray[i];
        insertRow(phrase.phrase, phrase.translation, i);
    }

    reset();
}

function insertRow(phrase, translation, i) {
    const table = document.getElementById("phraseCards").getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    if (i!==0){
        newRow.style.display = 'none';
    }
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

    const table = document.getElementById("phraseCards");
    table.rows[CARD_INDEX].style.display ='none';
    table.rows[0].style.display ='';
    CARD_INDEX = 0;

}
function next() {
    const table = document.getElementById("phraseCards");
    const  l = table.rows.length;
    if (CARD_INDEX === l-1){
        document.getElementById("myModal").style.display = 'block';

    }  else {
        table.rows[CARD_INDEX].style.display ='none';
        CARD_INDEX ++;
        table.rows[CARD_INDEX].style.display ='';
    }




}
function closeModal() {
    window.location.reload(false);
}