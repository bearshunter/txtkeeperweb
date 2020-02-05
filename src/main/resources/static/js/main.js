$(document).ready(function () {
    $.get("/keeper/rest/lesson/", function (data, status) {
        const articleArray = data;
        const container = document.getElementById("container");
        for (let i = 0; i < articleArray.length; i++) {
            const lesson = articleArray[i];
            const linkToArticle = "<div class='lesson'><a href='" + "/keeper/lesson.html?id=" + lesson.id + "'>";
            container.innerHTML = container.innerHTML + linkToArticle + "<p>" + lesson.headline + "</p></a></div>";
        }
    });
});