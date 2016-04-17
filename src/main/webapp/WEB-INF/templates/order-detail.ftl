<#include "admin.ftl"/>
<#macro m_body>
<div class="container">
    <h5>
        Продукт: ${order.product.name} <br><br>
        Итого: ${order.product.price * order.numberProduct} руб. <br>
        Количество: ${order.numberProduct}
    </h5>
    <hr>

    <#if shipping?has_content>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Информация о доставке</h3>
            </div>
            <div class="panel-body">
                Страна: ${shipping.country} <br>
                Получатель: ${shipping.fio} <br>
                Город: ${shipping.city} <br>
                Улица: ${shipping.street} <br>
                Дом: ${shipping.house} <br>
            </div>
        </div>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Заказы" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>