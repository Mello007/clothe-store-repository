
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteChair() {
    var headForDelete = $('#headForDelete').val();
    var requestJSONparametr = "{\"head\": \"" + headForDelete + "\"}";
    $.ajax({
        type: "POST",
        url: "/chair/delete",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}

function addNewChair() {
    var head = $('#head').val();
    var description = $('#description').val();
    var requestJSONparametr = "{\"name\": \"" + head + "\", \"description\": \"" + description + "\"}";
    $.ajax({
        type: "POST",
        url: "/chair/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getChair() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/chair/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-clients'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.chair.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['description'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['head'];

            var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    priceRequest.send(null);
    $("#all-clients").tablesorter();
}

$(document).ready(function() {
    getChair();
});