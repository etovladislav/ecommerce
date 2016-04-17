
//Добавление товара в корзину
function addBucket(id) {
    $.ajax({
        url: "/bucket/addProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            alert('Товар успешно добавлен в корзину');
            return true;
        }
    })
}
//Удаление товара из корзины
function deleteProduct(id) {
    $.ajax({
        url: "/bucket/deleteProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            window.location.href = "/bucket/all";
            return true;
        }
    })
}
//Изменение количества товаров в корзине
function changeNumberProduct(id) {
    var numberProduct = $('#numberProduct'+id).val();
    $.ajax({
        url: "/bucket/changeNumberProduct",
        type: "POST",
        data: {
            id: id,
            number: numberProduct
        },
        success: function () {
            alert('Изменено');
            return true;
        }
    })
}

function buyProducts() {
    $.ajax({
        url: "/bucket/buyProducts",
        type: "POST",
        success: function () {
            alert('Оформлено');
            window.location.href = "/products";
            return true;
        }
    })
}