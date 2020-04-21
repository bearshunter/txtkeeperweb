console.log(document.getElementById('showMore'));
fetch("/keeper/rest/lesson/")
    .then(response => response.json())
    .then(lessons => renderLessons(lessons));

function renderLessons(lessons) {
    const filtered = prepareLes(lessons);
    const container = document.getElementById("container");
    for (let i = 0; i < filtered.length; i++) {
        const lesson = filtered[i];
        const created = lesson.created;
        const now = Date.now();
        const createdObj = new Date(created);
        const lastDate = Math.trunc((now - created) / 1000 / 60 / 60 / 24);
        const day = createdObj.getDate();
        const month = createdObj.getMonth() + 1;
        const year = createdObj.getFullYear();
        const hours = createdObj.getHours();
        const minutes = createdObj.getMinutes();

        container.innerHTML = container.innerHTML + "<div  id='" + i + "'></div>";
        const phraseCard = document.getElementById(i);
        phraseCard.className = "lesson";
        phraseCard.innerHTML = `<a href='/keeper/lesson.html?id=${lesson.id}'><p>${lesson.headline}</p></a>`;
        phraseCard.innerHTML = phraseCard.innerHTML + `<p class="date">${day}.${month}.${year}</p>`;
        phraseCard.innerHTML = phraseCard.innerHTML + `<p class="date">${hours}:${minutes}</p>`;
        phraseCard.innerHTML = phraseCard.innerHTML + `<p class="date">${lastDate} Days ago</p>`;
        phraseCard.innerHTML = phraseCard.innerHTML + `<a class="button delete" onclick="deleteLesson(${lesson.id})" href="#"></a>`;
        phraseCard.innerHTML = phraseCard.innerHTML + `<a class="button edit"  href='/keeper/edit_lesson.html?id=${lesson.id}'></a>`;


        if (i > 5) {
            document.getElementById(i).style.display = 'none';
            document.getElementById(i).classList.add('hidden');
        }
    }
}

function prepareLes(lessons) {
    const filteredLes = lessons.filter(a => {
        if (a.headline && a.headline.length > 0) {
            return true;
        } else {
            return false;
        }
    });
    filteredLes.sort(function (a, b) {
        if (a.created < b.created) {
            return 1;
        }
        if (a.created > b.created) {
            return -1;
        }
        return 0;
    });

    console.log(filteredLes);
    return filteredLes;
}

document.querySelector('#showMore').onclick = function () {
    const hidden = document.getElementsByClassName('hidden');
    for (let i = 0; i < hidden.length; i++) {
        if (i < 6) {
            hidden[i].style.display = 'inline';
            hidden[i].classList.remove('hidden');
        }
    }
};
window.onscroll = function () {
    let scrollElem = document.getElementById("scrollToTop");
    if (document.documentElement.scrollTop > document.documentElement.clientHeight) {
        scrollElem.style.opacity = "0.5";
    } else {
        scrollElem.style.opacity = "0";
    }
};
let timeOut;

function goUp() {
    let top = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
    if (top > 0) {
        window.scrollBy(0, -100);
        timeOut = setTimeout('goUp()', 20);
    } else clearTimeout(timeOut);
}


function deleteLesson(id) {
    fetch("/keeper/rest/lesson/" + id, {
            method: "DELETE"
        }
    ).then(res => console.log(res));
    document.location.reload();
}