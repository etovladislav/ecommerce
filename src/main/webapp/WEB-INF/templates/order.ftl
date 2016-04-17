<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <#if buckets?has_content>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Проверьте еще раз</h3>
            </div>
            <div class="panel-body">
                <#list buckets as bucket>
                    <h5>
                        Продукт: ${bucket.product.name} <br><br>
                        Итого: ${bucket.product.price * bucket.numberProduct} руб. <br>
                        Количество: ${bucket.numberProduct}
                    </h5>
                    <hr>
                </#list>
                <h3>
                    Общая сумма: ${sum} руб.
                </h3>
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
                    <button class="btn btn-success btn-block" id="buyProducts" onclick="buyProducts()">Оформить</button>
                <#else>
                    <a href="/settings">Пожалуйста заполните информацию по доставке</a>
                </#if>
            </div>
        </div>
    <#else>
        <h3>Вы еще ничего не добавили в корзину, <a href="/products">перейти к покупкам</a></h3>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>