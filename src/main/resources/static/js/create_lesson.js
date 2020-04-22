function addLesson() {
    event.preventDefault();
    const headline = document.getElementById('headline').value;
    const backlight = document.getElementById('headline');
    if (headline === "") {
        backlight.style.borderColor = 'red';
    } else {
        backlight.style.borderColor = 'green';
        const lessonObj = {
            headline: headline,
            phraseCards: []
        };
        const table = document.getElementById("sentences").getElementsByTagName('tbody')[0];

        let hasErrors = false;
        for (let row of table.rows) {
            const phrase = row.cells[0].firstElementChild.value;
            const translation = row.cells[1].firstChild.value;
            if (phrase === "") {
                row.cells[0].firstElementChild.style.borderColor = 'red';
                hasErrors = true;
            } else {
                row.cells[0].firstElementChild.style.borderColor = 'green';
            }
            if (translation === "") {
                row.cells[1].firstElementChild.style.borderColor = 'red';
                hasErrors = true;
            } else {
                row.cells[1].firstElementChild.style.borderColor = 'green';
            }

            console.log(phrase + " - " + translation);
            lessonObj.phraseCards[lessonObj.phraseCards.length] = {
                phrase: phrase,
                translation: translation
            }
        }
        console.log(lessonObj);

        if (!hasErrors) {
            fetch("/keeper/rest/lesson/", {
                method: 'POST',
                body: JSON.stringify(lessonObj),
                headers: {'Content-type':'application/json; charset=UTF-8'}
            })
                .then(data =>  window.location.href = '/keeper/') // Manipulate the data retrieved back, if we want to do something with it
                .catch(err => console.log(err));
        }

    }

}
function addLine() {
    const table = document.getElementById("sentences").getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    cell1.innerHTML = "<input type=\"text\" name=\"phrase\" >";
    cell2.innerHTML = "<input type=\"text\" name=\"transation\" >";
}
