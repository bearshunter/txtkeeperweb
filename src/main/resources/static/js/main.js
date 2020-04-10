$(document).ready(function () {
    $.get("/keeper/rest/lesson/", function (data, status) {
        const articleArray = data;
        const filtered = articleArray.filter(function (a) {
            if (a.headline && a.headline.length > 0) {
                return true;
            }
            return false;
        });

        filtered.sort(function (a, b) {
            if (a.created < b.created) {
                return 1;
            }
            if (a.created > b.created) {
                return -1;
            }
            return 0;
        });
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


            const linkToArticle = "<div class='lesson' id='" + i + "'><a href='" + "/keeper/lesson.html?id=" + lesson.id + "'>";
            container.innerHTML = container.innerHTML + linkToArticle + "<p>" + lesson.headline + "</p></a>" + "<p class='date'>" + day + "." + month + "." + year + "</p>" + "<p class='date'>" + hours + ":" + minutes + "</p>" + "<p class='date'>" + lastDate + " Days ago" + "</p>" +
                "</div>";
            if (i > 5) {
                document.getElementById(i).style.display = 'none';
                document.getElementById(i).classList.add('hidden');
            }
            ;


        }
        ;


    });
});
document.querySelector('#showMore').onclick = function () {
    const hidden = document.getElementsByClassName('hidden');
    for (  let i = 0; i< hidden.length; i++) {
        if (i < 6) {
            hidden[i].style.display = 'inline';
            hidden[i].classList.remove('hidden');

        }
    }


};