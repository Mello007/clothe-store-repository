
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteSchedule() {
    var disciplineForDelete = $('#disciplineForDelete').val();

    var requestJSONparametr = "{\"name\": \"" + disciplineForDelete + "\"}";
    $.ajax({
        type: "POST",
        url: "/schedule/delete",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr,
    });
}

function addNewSchedule() {
    var teacher = $('#teacher').val();
    var discipline = $('#discipline').val();
    var lectureHull = $('#lectureHull').val();

    var requestJSONparametr = "{\"teacher\": \"" + teacher + "\", \"discipline\": \"" + discipline + "\", \"lectureHull\": \"" + lectureHull + "\"}";
    $.ajax({
        type: "POST",
        url: "/schedule/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getSchedule() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/schedule/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-tests'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.schedule.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['teacher'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['discipline'];
            var date = document.createElement('td');
            date.innerHTML = item['lectureHull'];
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(date);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-tests").tablesorter();

}




$(document).ready(function() {
    getSchedule();
});