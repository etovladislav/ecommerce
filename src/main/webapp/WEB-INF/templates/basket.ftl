<#include "main-template.ftl"/>
<#macro m_body>
<div class="container" style="background-color: white; padding: 30px;">
    <#if buckets?has_content>
        <#list buckets as bucket>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${bucket.product.name}</h3>
                </div>
                <div class="panel-body">
                    Итого: ${bucket.product.price} руб. * X <input type="number" placeholder="Количество" id="numberProduct${bucket.id}" value="${bucket.numberProduct}">
                    <button onclick="changeNumberProduct(${bucket.id})">Изменить</button>
                    <button onclick="deleteProduct(${bucket.id})">Удалить</button>
                </div>
            </div>
        </#list>
        <a href="/bucket/buy" class="btn btn-success btn-block">Оформить заказ</a>
    <#else>
        <h3>Вы еще ничего не добавили в корзину, <a href="/products">перейти к покупкам</a></h3>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>