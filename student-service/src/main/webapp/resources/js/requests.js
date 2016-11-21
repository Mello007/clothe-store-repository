
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteStudent() {
    var name = $('#nameForDelete').val();
    
    var requestJSONparametr = "{\"name\": \"" + name + "\"}";
    $.ajax({
        type: "POST",
        url: "/student/delete",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}

function searchStudent() {
    var name = $('#nameForSearch').val();
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "search/student/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-items'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.student.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['name'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['dateOfBirthDay'];
            var priceElement = document.createElement('td');
            priceElement.innerHTML = item['phoneNumber'];
            var dateOfSale = document.createElement('td');
            dateOfSale.innerHTML = item['sex'];
            var dateOfSupply = document.createElement('td');
            dateOfSupply.innerHTML = item['dateOfSale'];

            var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(priceElement);
            elementRow.appendChild(dateOfSupply);
            elementRow.appendChild(dateOfSale);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });

    };

    priceRequest.send(null);
}

function addNewStudent() {
    var name = $('#name').val();
    var dateOfBirthDay = $('#dateOfBirthDay').val();
    var sex = $('#sex').val();
    var phoneNumber = $('#phoneNumber').val();
    
    var requestJSONparametr = "{\"name\": \"" + name + "\", \"dateOfBirthDay\": \"" + dateOfBirthDay + "\", \"sex\": \"" + sex + "\"" +
        ", \"phoneNumber\": \"" + phoneNumber + "\"}";
    $.ajax({
        type: "POST",
        url: "/student/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}




    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/student/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-items'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
            parsedItem._embedded.student.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['name'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['dateOfBirthDay'];
                var priceElement = document.createElement('td');
                priceElement.innerHTML = item['phoneNumber'];
                var dateOfSale = document.createElement('td');
                dateOfSale.innerHTML = item['sex'];
                var dateOfSupply = document.createElement('td');
                dateOfSupply.innerHTML = item['dateOfSale'];

                var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
                elementRow.appendChild(priceElement);
                elementRow.appendChild(dateOfSupply);
                elementRow.appendChild(dateOfSale);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });

    };

priceRequest.send(null);

$(document).ready(function() {
    $("#all-items-table").tablesorter();
});