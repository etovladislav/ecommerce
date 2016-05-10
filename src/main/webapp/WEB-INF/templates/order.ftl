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
                    <iframe frameborder="0" allowtransparency="true" scrolling="no"
                            src="https://money.yandex.ru/embed/small.xml?account=41001941977729&quickpay=small&yamoney-payment-type=on&button-text=02&button-size=l&button-color=orange&targets=%D0%9E%D0%BF%D0%BB%D0%B0%D1%82%D0%B0+%D0%BF%D0%BE%D0%BA%D1%83%D0%BF%D0%BA%D0%B8&default-sum=${sum?c}&successURL=localhost%3A8181%2Forder%3Fsuccess%3Dtrue"
                            width="196" height="54"></iframe>
                    <form action="/bucket/buyProducts" method="post">
                        <button type="button" class="btn btn-success" onclick="buyProducts()">Если нет денег, кликай
                            сюда
                        </button>
                    </form>
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