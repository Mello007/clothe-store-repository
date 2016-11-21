
var currency = '';
$(document).ready(function() {
    $('.dropdown-menu-kind li a').click(function(){
        currency = $(this).data('val');
    })
});

function deleteTeacher() {
    var nameForDelete = $('#nameForDelete').val();
    var addressForDelete = $('#addressForDelete').val();

    var requestJSONparametr = "{\"name\": \"" + nameForDelete + "\", \"address\": \"" + addressForDelete + "\"}";
    $.ajax({
        type: "POST",
        url: "/teacher/delete",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr,
    });
}

function addNewTeacher() {
    var name = $('#name').val();
    var address = $('#address').val();
    var numberPhone = $('#numberPhone').val();
    var category = $('#category').val();

    var requestJSONparametr = "{\"name\": \"" + name + "\", \"address\": \"" + address + "\"" +
        ", \"numberPhone\": \"" + numberPhone + "\", \"category\": \"" + category + "\"}";
    $.ajax({
        type: "POST",
        url: "/teacher/add",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}


function getTeachers() {
    var priceRequest = new XMLHttpRequest();
    priceRequest.open("GET", "/teacher/", true);   //Указываем адрес GET-запроса
    priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
        var parsedItem = JSON.parse(this.responseText);
        var itemsTable = document.getElementById('all-suppliers'); //получаем элемент по Id
        itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
        parsedItem._embedded.teacher.forEach(function(item)  {
            var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
            itemNameElement.innerHTML =  item['name'] ;     //внедряем название предмета, полученное с сервера
            var itemPriceElement = document.createElement('td');
            itemPriceElement.innerHTML = item['address'];
            var numberPhone = document.createElement('td');
            numberPhone.innerHTML = item['numberPhone'];
            var category = document.createElement('td');
            category.innerHTML = item['category'];
            
            var elementRow = document.createElement('tr'); /// /создаем строку таблицы

            elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
            elementRow.appendChild(itemPriceElement);
            elementRow.appendChild(numberPhone);
            elementRow.appendChild(category);
            itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
        });
    };
    
    priceRequest.send(null);
    $("#all-suppliers-table").tablesorter();
}




$(document).ready(function() {
    getTeachers();
    // setInterval(getCars,5000);
});