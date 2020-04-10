function addLesson(event) {
    // event.preventDefault();
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
            const ajaxRequest = new XMLHttpRequest();
            ajaxRequest.open('POST', '/keeper/rest/lesson', true );
            ajaxRequest.setRequestHeader('Content-Type', 'application/json');
            ajaxRequest.send(JSON.stringify(lessonObj));

            if (ajaxRequest.status === 200) {
                window.location.href = '/keeper/';
            } else {
                alert("Error from server!!");
            }


            // $.ajax({
            //     type: "POST",
            //     contentType: "application/json; charset=utf-8",
            //     url: "/keeper/rest/lesson",
            //     data: JSON.stringify(lessonObj),
            //     cache: false,
            //     success: function (result) {
            //         window.location.href = '/keeper/'
            //     },
            //     error: function (err) {
            //         alert("Error from server!!")
            //     }
            // });
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


