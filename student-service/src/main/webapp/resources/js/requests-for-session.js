
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteSession() {
    var disciplineForDelete = $('#disciplineForDelete').val();
    var dateForDelete = $('#dateForDelete').val();
    var requestJSONparametr = "{\"description\": \"" + disciplineForDelete + "\", \"dateOfPass\": \"" + dateForDelete + "\"}";
    $.ajax({
        type: "POST",
        url: "/session/delete",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}

function addNewSession() {
    var description = $('#description').val();
    var teacherName = $('#teacherName').val();
    var discipline = $('#discipline').val();
    var numberGroup = $('#numberGroup').val();
    var dateOfPass = $('#dateOfPass').val();
    var requestJSONparametr = "{\"description\": \"" + description + "\", \"teacherName\": \"" + teacherName + "\"," +
        " \"discipline\": \"" + discipline + "\", \"numberGroup\": \"" + numberGroup + "\", \"dateOfPass\": \"" + dateOfPass + "\"}";
    $.ajax({
        type: "POST",
        url: "/session/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getSession() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/session/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-employees'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.session.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['description'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['teacherName'];
            var priceElement = document.createElement('td');
            priceElement.innerHTML = item['discipline'];
            var dateOfreception = document.createElement('td');
            dateOfreception.innerHTML = item['numberGroup'];
            var dateOfPass = document.createElement('td');
            dateOfPass.innerHTML = item['dateOfPass'];
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы


            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(priceElement);
            elementRow.appendChild(dateOfreception);
            elementRow.appendChild(dateOfPass);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-employees").tablesorter();
}

$(document).ready(function() {
    getSession();
    // setInterval(getCars,5000);
});