<#include "main-template.ftl"/>
<#macro m_body>
<div class="container background">
    <h2>
        Детали заказа
    </h2>
    <hr>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                Заказ №: ${order.id} <br>
                Статус: ${order.orderStatus}
            </h3>
        </div>
        <div class="panel-body">
            <#list order.orderDetail as order>
                <a href="/products/detail?id=${order.product.id}">Название продукта: ${order.product.name}</a>
                <hr>
            </#list>
        </div>
    </div>
</div> <!-- /container -->
</#macro>
<@main title="Заказ" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>