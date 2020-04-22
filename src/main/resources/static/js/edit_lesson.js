const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');
console.log(document.getElementById('showMore'));
fetch("/keeper/rest/lesson/" + id)
    .then(response => response.json())
    .then(lesson => renderLesson(lesson));

function renderLesson(data) {
    console.log(data);
    document.getElementById("headline").value = data.headline;
    const cards = data.phraseCards;
    for (let i = 0; i < cards.length; i++) {
        const card = cards[i];
        insertRow(card.phrase, card.translation);
    }
}

function insertRow(phrase, translation) {
    const table = document.getElementById("phraseCards").getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    cell1.innerHTML = `<input type="text" name="phrase" value="${phrase}">`;
    cell2.innerHTML = `<input type="text" name="translation" value="${translation}">`;

}

function addLesson() {
    event.preventDefault();
    const data = {};
    data.headline = document.getElementById("headline").value;
    data.lessonId = id;
    data.phraseCards = [];
    const table = document.getElementById("phraseCards");
    for (let row of table.rows) {
        const phrase = row.cells[0].firstElementChild.value;
        const translation = row.cells[1].firstElementChild.value;
        const phraseCard = {phrase: phrase, translation: translation};
        data.phraseCards.push(phraseCard);
    }
    console.log(data);
    fetch("/keeper/rest/lesson/" + id, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {'Content-type':'application/json; charset=UTF-8'}
        })
        .then(data => console.log(data)) // Manipulate the data retrieved back, if we want to do something with it
        .catch(err => console.log(err)); // Do something with the error
}